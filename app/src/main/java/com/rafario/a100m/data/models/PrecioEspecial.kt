package com.rafario.a100m.data.models

import java.time.DayOfWeek

data class PrecioEspecial(
    val dia: DayOfWeek,
    val precio: Double
)

fun precioParaDia(
    precioBase: Double,
    preciosEspeciales: List<PrecioEspecial>,
    dia: DayOfWeek
): Double {
    return preciosEspeciales.firstOrNull { it.dia == dia }?.precio ?: precioBase
}
