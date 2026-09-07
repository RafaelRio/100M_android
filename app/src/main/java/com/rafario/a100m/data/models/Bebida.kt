package com.rafario.a100m.data.models

import java.time.DayOfWeek

data class Bebida(
    val id: Int,
    val nombre: String,
    val tamano: String?,
    val tipoBebida: TipoBebida,
    val precio: Double,
    val preciosEspeciales: List<PrecioEspecial> = emptyList()
) {
    fun precioPara(dia: DayOfWeek): Double {
        return precioParaDia(precio, preciosEspeciales, dia)
    }
}

enum class TipoBebida {
    CERVEZA,
    TINTO_DE_VERANO,
    CERVEZA_PREMIUM,
    CERVEZA_BOTELLA,
    TARDEO_PREMIUM,
    TARDEO_CHILL,
    CLASICAS,
    ENERGETICAS,
    VINO,
    CAFE_INFUSIONES
}
