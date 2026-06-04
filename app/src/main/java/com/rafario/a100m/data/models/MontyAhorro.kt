package com.rafario.a100m.data.models

data class MontyAhorro(
    val id: Int,
    val nombre: String,
    val montaditos: List<Montadito>,
    val precio: Double
)
