package com.rafario.a100m.ui.formatting

import androidx.annotation.StringRes
import com.rafario.a100m.R
import com.rafario.a100m.data.models.TipoBebida
import java.util.Locale

internal fun formatPrice(price: Double): String {
    return String.format(Locale.forLanguageTag("es-ES"), "%.2f €", price)
}

internal fun formatMontaditoId(id: Int): String {
    val normalizedId = if (id in 1001..1100) id - 1000 else id
    return String.format(Locale.ROOT, "%03d", normalizedId)
}

@get:StringRes
internal val TipoBebida.labelResource: Int
    get() = when (this) {
        TipoBebida.CERVEZA -> R.string.drink_type_cerveza
        TipoBebida.TINTO_DE_VERANO -> R.string.drink_type_tinto_de_verano
        TipoBebida.CERVEZA_PREMIUM -> R.string.drink_type_cerveza_premium
        TipoBebida.CERVEZA_BOTELLA -> R.string.drink_type_cerveza_botella
        TipoBebida.TARDEO_PREMIUM -> R.string.drink_type_tardeo_premium
        TipoBebida.TARDEO_CHILL -> R.string.drink_type_tardeo_chill
        TipoBebida.CLASICAS -> R.string.drink_type_clasicas
        TipoBebida.ENERGETICAS -> R.string.drink_type_energeticas
        TipoBebida.VINO -> R.string.drink_type_vino
        TipoBebida.CAFE_INFUSIONES -> R.string.drink_type_cafe_infusiones
    }
