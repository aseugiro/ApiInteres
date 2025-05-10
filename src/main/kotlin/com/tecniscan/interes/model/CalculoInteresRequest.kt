package com.tecniscan.interes.model



data class CalculoInteresRequest (
    val montoInicial: Double,
    val tasaInteres: Double,
    val anios: Int
)