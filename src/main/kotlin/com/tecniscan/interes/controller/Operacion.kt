package com.tecniscan.interes.controller

import com.tecniscan.interes.database.InteresRepositorio
import com.tecniscan.interes.database.BitacoraRepositorio
import com.tecniscan.interes.database.model.EntityBitacora
import com.tecniscan.interes.database.model.EntityInteres
import com.tecniscan.interes.handler.InteresHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.tecniscan.interes.model.CalculoInteresRequest
import com.tecniscan.interes.model.CalculoInteresResponse
import com.tecniscan.interes.model.InteresPorAnioResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import java.util.Calendar


@RestController
@RequestMapping
class Operacion {


    @Autowired
    private lateinit var interesHandler: InteresHandler

    @CrossOrigin(maxAge = 3600)
    @PostMapping("/calcular-interes")
    fun calcularInteres(@RequestBody request: CalculoInteresRequest): CalculoInteresResponse {

        return interesHandler.calcularInteres(request);

    }


    @GetMapping("/historial-calculos")
    fun getProducto(id: Int): CalculoInteresResponse {

        return interesHandler.getHistorial(id)

    }
}