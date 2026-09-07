package com.rafario.a100m.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.rafario.a100m.data.models.LineaPedido
import com.rafario.a100m.data.models.Pedido
import com.rafario.a100m.data.models.TipoProducto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.json.JSONArray
import org.json.JSONObject

private val Context.pedidosDataStore by preferencesDataStore(name = "pedidos")

class PedidoRepository internal constructor(
    private val dataStore: DataStore<Preferences>
) {
    constructor(context: Context) : this(context.applicationContext.pedidosDataStore)

    private val pedidosKey = stringPreferencesKey("pedidos_json")

    val pedidos: Flow<List<Pedido>> = dataStore.data.map { preferences ->
        preferences[pedidosKey]?.toPedidos().orEmpty()
    }

    suspend fun addPedido(
        nombre: String,
        lineas: List<LineaPedido>
    ) {
        require(nombre.isNotBlank()) { "El pedido necesita un nombre" }
        require(lineas.isNotEmpty()) { "El pedido necesita productos" }
        dataStore.edit { preferences ->
            val currentPedidos = preferences[pedidosKey]?.toPedidos().orEmpty()
            val nextId = (currentPedidos.maxOfOrNull { it.id } ?: 0) + 1
            val newPedido = Pedido(nextId, nombre.trim(), lineas)
            preferences[pedidosKey] = (currentPedidos + newPedido).toJson()
        }
    }

    suspend fun deletePedido(pedidoId: Int) {
        dataStore.edit { preferences ->
            val currentPedidos = preferences[pedidosKey]?.toPedidos().orEmpty()
            preferences[pedidosKey] = currentPedidos.filterNot { it.id == pedidoId }.toJson()
        }
    }

    suspend fun updatePedido(
        pedidoId: Int,
        nombre: String,
        lineas: List<LineaPedido>
    ) {
        require(nombre.isNotBlank()) { "El pedido necesita un nombre" }
        require(lineas.isNotEmpty()) { "El pedido necesita productos" }
        dataStore.edit { preferences ->
            val currentPedidos = preferences[pedidosKey]?.toPedidos().orEmpty()
            require(currentPedidos.any { it.id == pedidoId }) { "El pedido ya no existe" }
            preferences[pedidosKey] = currentPedidos.map { pedido ->
                if (pedido.id == pedidoId) {
                    pedido.copy(nombre = nombre.trim(), lineas = lineas)
                } else {
                    pedido
                }
            }.toJson()
        }
    }
}

private fun List<Pedido>.toJson(): String {
    val pedidosArray = JSONArray()
    forEach { pedido ->
        pedidosArray.put(
            JSONObject()
                .put("id", pedido.id)
                .put("nombre", pedido.nombre)
                .put("lineas", pedido.lineas.toJsonArray())
        )
    }
    return pedidosArray.toString()
}

private fun List<LineaPedido>.toJsonArray(): JSONArray {
    val lineasArray = JSONArray()
    forEach { linea ->
        lineasArray.put(
            JSONObject()
                .put("productoId", linea.productoId)
                .put("nombre", linea.nombre)
                .put("precioUnitario", linea.precioUnitario)
                .put("cantidad", linea.cantidad)
                .put("tipoProducto", linea.tipoProducto.name)
                .put("observaciones", linea.observaciones)
        )
    }
    return lineasArray
}

private fun String.toPedidos(): List<Pedido> {
    val pedidosArray = JSONArray(this)
    return List(pedidosArray.length()) { index ->
        pedidosArray.getJSONObject(index).toPedido()
    }
}

private fun JSONObject.toPedido(): Pedido {
    return Pedido(
        id = getInt("id"),
        nombre = optString("nombre"),
        lineas = getJSONArray("lineas").toLineasPedido()
    )
}

private fun JSONArray.toLineasPedido(): List<LineaPedido> {
    return List(length()) { index ->
        getJSONObject(index).toLineaPedido()
    }
}

private fun JSONObject.toLineaPedido(): LineaPedido {
    return LineaPedido(
        productoId = getInt("productoId"),
        nombre = getString("nombre"),
        precioUnitario = getDouble("precioUnitario"),
        cantidad = getInt("cantidad"),
        tipoProducto = optString("tipoProducto").toTipoProducto(),
        observaciones = if (isNull("observaciones")) null else optString("observaciones").ifBlank { null }
    )
}

private fun String.toTipoProducto(): TipoProducto {
    return TipoProducto.entries.firstOrNull { it.name == this } ?: TipoProducto.OTRO
}
