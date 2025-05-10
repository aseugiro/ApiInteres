package com.tecniscan.interes.mapper

import com.tecniscan.interes.database.model.EntityBitacora
import com.tecniscan.interes.database.model.EntityInteres
import com.tecniscan.interes.model.CalculoInteresResponse
import com.tecniscan.interes.model.InteresPorAnioResponse


class CalculoInteresMapper {
    companion object {
        fun map(id: Int?, bitacora: EntityBitacora, intereses: List<EntityInteres>): CalculoInteresResponse {

            val LstInteresSimple = mutableListOf<InteresPorAnioResponse>()
            val LstInteresCompuesto = mutableListOf<InteresPorAnioResponse>()

            val calculoInteresResponse =
                CalculoInteresResponse(id, bitacora.fecha, LstInteresSimple, LstInteresCompuesto)


            intereses
                .forEach { item ->
                    val simple = InteresPorAnioResponse(format(item.montoSimple), item.anio)
                    LstInteresSimple.add(simple)
                    val compuesto = InteresPorAnioResponse(format(item.montoCompuesto), item.anio)
                    LstInteresCompuesto.add(compuesto)

                }



            return calculoInteresResponse
        }


        private fun format(valor: Double): String {
            return "%.2f".format(valor)
        }
    }
}