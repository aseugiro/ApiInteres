package com.tecniscan.interes.model

data class CalculoInteresResponse (
    val id: Int?,
    val fecha: String,
    val interes_simple: List<InteresPorAnioResponse>,
    val interes_compuesto: List<InteresPorAnioResponse>
)