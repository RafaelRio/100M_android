package com.rafario.a100m.data.models

data class Bebida(
    val id: Int,
    val nombre: String,
    val tamano: String,
    val tipoBebida: TipoBebida,
    val precio: Double,
    val preciosEspeciales: List<PrecioEspecial> = emptyList()
) {
    fun precioPara(dia: java.time.DayOfWeek): Double {
        return precioParaDia(precio, preciosEspeciales, dia)
    }
}

enum class TipoBebida(val tipo: String) {
    CERVEZA("Cerveza"),
    TINTO_DE_VERANO("Tinto de Verano"),
    CERVEZA_PREMIUM("Cerveza Premium"),
    CERVEZA_BOTELLA("Cerveza en Botella"),
    TARDEO_PREMIUM("Tardeo Premium"),
    TARDEO_CHILL("Tardeo Chill"),
    CLASICAS("Clásicas"),
    ENERGETICAS("Energéticas"),
    VINO("Vino"),
    CAFE_INFUSIONES("Café e infusiones")
}
