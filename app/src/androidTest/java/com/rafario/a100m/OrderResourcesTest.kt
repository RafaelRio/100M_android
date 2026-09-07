package com.rafario.a100m

import android.content.res.Configuration
import androidx.test.platform.app.InstrumentationRegistry
import com.rafario.a100m.data.models.*
import com.rafario.a100m.ui.screens.toShareText
import com.rafario.a100m.ui.formatting.formatMontaditoId
import org.junit.Assert.*
import org.junit.Test
import java.util.Locale

class OrderResourcesTest {
    private val context = InstrumentationRegistry.getInstrumentation().targetContext.let {
        it.createConfigurationContext(Configuration(it.resources.configuration).apply {
            setLocale(Locale.forLanguageTag("es-ES"))
        })
    }

    @Test fun shareTextUsesMenuNumbersAndPreservesQuantities() {
        val pedido = Pedido(7, "Mesa 4", listOf(
            LineaPedido(1001, "Montadito", 1.0, 2, TipoProducto.MONTADITO),
            LineaPedido(9999, "Patatas", 2.5, 1, observaciones = "Con salsa")
        ))
        assertEquals("Pedido #7\nMesa 4\n\nMontaditos: 001, 001\n1x Patatas\n  Con salsa\n\nTotal: 4,50 €", pedido.toShareText(context))
        assertEquals("100", formatMontaditoId(1100))
        assertEquals("007", formatMontaditoId(7))
    }

    @Test fun productCountUsesSingularAndPlural() {
        assertEquals("1 producto añadido", context.resources.getQuantityString(R.plurals.cart_product_count, 1, 1))
        assertEquals("2 productos añadidos", context.resources.getQuantityString(R.plurals.cart_product_count, 2, 2))
    }
}
