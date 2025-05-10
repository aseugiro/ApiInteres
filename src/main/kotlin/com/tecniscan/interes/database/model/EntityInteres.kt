package com.tecniscan.interes.database.model

import jakarta.persistence.Basic
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="historial_interes")
data class EntityInteres(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    var id: Int?,
    var anio: Int,
    var montoSimple: Double,
    var idBitacora : Int?,
    var montoCompuesto: Double) {

    constructor() : this(0,0,0.0,0,0.0)
}