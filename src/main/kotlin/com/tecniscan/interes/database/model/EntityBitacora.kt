package com.tecniscan.interes.database.model

import com.tecniscan.interes.database.model.EntityInteres
import jakarta.persistence.Basic
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "bitacora")
data class EntityBitacora(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    var id: Int?,
    var fecha: String
) {
    constructor() : this(0, "")
}