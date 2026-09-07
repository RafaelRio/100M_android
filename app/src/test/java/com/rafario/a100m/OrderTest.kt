package com.rafario.a100m

import com.rafario.a100m.data.models.*
import com.rafario.a100m.ui.formatting.formatMontaditoId
import com.rafario.a100m.ui.screens.CartLinesSaver
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.saveable.SaverScope
import org.junit.Assert.*
import org.junit.Test
import java.time.DayOfWeek

class OrderTest {
    @Test fun totalsIncludeQuantities() {
        val pedido = Pedido(lineas = listOf(
            LineaPedido(1, "Uno", 1.5, 3), LineaPedido(2, "Dos", 2.0, 2)
        ))
        assertEquals(8.5, pedido.total, 0.00001)
        assertEquals(5, pedido.cantidadProductos)
        assertEquals(0.0, Pedido().total, 0.0)
    }

    @Test fun specialPriceOnlyAppliesOnMatchingDay() {
        val prices = listOf(PrecioEspecial(DayOfWeek.WEDNESDAY, 1.0))
        assertEquals(1.0, precioParaDia(2.5, prices, DayOfWeek.WEDNESDAY), 0.0)
        assertEquals(2.5, precioParaDia(2.5, prices, DayOfWeek.MONDAY), 0.0)
    }

    @Test fun menuNumbersAreNormalized() {
        assertEquals("100", formatMontaditoId(1100))
        assertEquals("007", formatMontaditoId(7))
    }

    @Test fun cartRestorationPreservesPricesQuantitiesAndNotes() {
        val line = LineaPedido(1001, "Producto", 1.25, 3, TipoProducto.MONTADITO, "Nota")
        val cart = mutableStateMapOf(line.productoId to line)
        val saved = with(CartLinesSaver) { object : SaverScope { override fun canBeSaved(value: Any) = true }.save(cart) }
        assertNotNull(saved)
        assertEquals(cart.toMap(), CartLinesSaver.restore(saved!!)!!.toMap())
        val empty = with(CartLinesSaver) { object : SaverScope { override fun canBeSaved(value: Any) = true }.save(mutableStateMapOf()) }
        assertTrue(CartLinesSaver.restore(empty!!)!!.isEmpty())
    }
}
