package com.rafario.a100m.data.models

data class Montadito(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val preciosEspeciales: List<PrecioEspecial> = emptyList()
) {
    fun precioPara(dia: java.time.DayOfWeek): Double {
        return precioParaDia(precio, preciosEspeciales, dia)
    }
}
