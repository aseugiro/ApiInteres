package com.tecniscan.interes.handler

import com.tecniscan.interes.database.InteresDAO
import com.tecniscan.interes.database.model.EntityBitacora
import com.tecniscan.interes.database.model.EntityInteres
import com.tecniscan.interes.mapper.CalculoInteresMapper
import com.tecniscan.interes.model.CalculoInteresRequest
import com.tecniscan.interes.model.CalculoInteresResponse
import com.tecniscan.interes.util.CalculoInteresUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.Calendar

@Component
class InteresHandler {

    @Autowired
    private lateinit var interesDAO: InteresDAO

    fun calcularInteres(request: CalculoInteresRequest): CalculoInteresResponse {

        val fecha = Calendar.getInstance().time

        var entityBitacora = EntityBitacora(null, fecha.toString())
        var entityRepositorio = interesDAO.save(entityBitacora)

        var lstEntityInteres= mutableListOf<EntityInteres>()

        CalculoInteresUtil.calculo(request.montoInicial, request.anios, request.tasaInteres)
            .forEach { calculo->

                val save= interesDAO.save(EntityInteres(null,calculo.anio,calculo.interesSimple,entityRepositorio.id,calculo.interesCompuesto))

                lstEntityInteres.add(save)

            }


        return CalculoInteresMapper.map(entityRepositorio.id, entityRepositorio, lstEntityInteres)
    }


    fun getHistorial(id: Int): CalculoInteresResponse {

        val bitacora = interesDAO.findBitacoraByID(id)

        val intereses = interesDAO.findInteres(id)

        return CalculoInteresMapper.map(id, bitacora.get(), intereses)


    }
}