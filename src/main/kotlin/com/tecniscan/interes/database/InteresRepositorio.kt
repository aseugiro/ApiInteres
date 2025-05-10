package com.tecniscan.interes.database

import com.tecniscan.interes.database.model.EntityInteres
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InteresRepositorio : CrudRepository<EntityInteres, Int> {
    fun findAllByIdBitacora(idBitacora: Int) : List<EntityInteres>

}