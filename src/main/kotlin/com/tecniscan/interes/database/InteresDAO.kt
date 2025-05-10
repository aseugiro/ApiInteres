package com.tecniscan.interes.database

import com.tecniscan.interes.database.model.EntityBitacora
import com.tecniscan.interes.database.model.EntityInteres
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.Optional

@Component
class InteresDAO {


    @Autowired
    private lateinit var interesRepositorio: InteresRepositorio


    @Autowired
    private lateinit var bitacoraRepositorio: BitacoraRepositorio


    fun save(entityInteres: EntityInteres): EntityInteres {
        return interesRepositorio.save<EntityInteres>(entityInteres)
    }

    fun save(entityBitacora: EntityBitacora): EntityBitacora {
        return bitacoraRepositorio.save<EntityBitacora>(entityBitacora)
    }


    fun findBitacoraByID(id: Int): Optional<EntityBitacora?> {
        return bitacoraRepositorio.findById(id)
    }

    fun findInteres(id: Int): List<EntityInteres> {
        return interesRepositorio.findAllByIdBitacora(id)
    }


}