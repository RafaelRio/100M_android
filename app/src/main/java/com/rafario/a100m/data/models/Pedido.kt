package com.rafario.a100m.data.models

data class Pedido(
    val id: Int = 0,
    val nombre: String = "",
    val lineas: List<LineaPedido> = emptyList()
) {
    val total: Double
        get() = lineas.sumOf { it.subtotal }

    val cantidadProductos: Int
        get() = lineas.sumOf { it.cantidad }
}

data class LineaPedido(
    val productoId: Int,
    val nombre: String,
    val precioUnitario: Double,
    val cantidad: Int,
    val tipoProducto: TipoProducto = TipoProducto.OTRO,
    val observaciones: String? = null
) {
    val subtotal: Double
        get() = precioUnitario * cantidad
}

enum class TipoProducto {
    MONTADITO,
    OTRO
}
