package com.rafario.a100m

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.test.platform.app.InstrumentationRegistry
import com.rafario.a100m.data.models.LineaPedido
import com.rafario.a100m.data.repository.PedidoRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first
import org.junit.Assert.*
import org.junit.Test
import java.io.File
import java.util.UUID

class PedidoRepositoryTest {
    @Test fun concurrentWritesPreserveOrdersAndNullNotes() = runBlocking {
        val file = File(InstrumentationRegistry.getInstrumentation().targetContext.cacheDir,
            "test-${UUID.randomUUID()}.preferences_pb")
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
        val repository = PedidoRepository(PreferenceDataStoreFactory.create(scope = scope) { file })
        try {
            val lines = listOf(LineaPedido(1001, "Producto", 1.5, 2))
            coroutineScope {
                repeat(20) { index ->
                    launch(Dispatchers.IO) { repository.addPedido("Pedido $index", lines) }
                }
            }
            val orders = repository.pedidos.first()
            assertEquals(20, orders.size)
            assertEquals(20, orders.map { it.id }.distinct().size)
            assertNull(orders.first().lineas.first().observaciones)
            coroutineScope {
                launch { repository.deletePedido(orders[0].id) }
                launch { repository.updatePedido(orders[1].id, "Editado", lines) }
                launch { repository.addPedido("Nuevo", lines) }
            }
            val updated = repository.pedidos.first()
            assertEquals(20, updated.size)
            assertFalse(updated.any { it.id == orders[0].id })
            assertEquals("Editado", updated.first { it.id == orders[1].id }.nombre)
        } finally {
            scope.coroutineContext[Job]!!.cancelAndJoin()
            file.delete()
        }
    }
}
