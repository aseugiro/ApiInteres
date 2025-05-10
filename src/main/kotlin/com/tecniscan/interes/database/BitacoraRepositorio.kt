package com.tecniscan.interes.database


import com.tecniscan.interes.database.model.EntityBitacora
import com.tecniscan.interes.database.model.EntityInteres
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BitacoraRepositorio : CrudRepository<EntityBitacora, Int> {


}