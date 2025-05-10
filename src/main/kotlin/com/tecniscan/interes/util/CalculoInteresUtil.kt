package com.tecniscan.interes.util


import com.tecniscan.interes.model.CalculoInteres


class CalculoInteresUtil {
    companion object {

        fun calculo(montoInicial: Double, anios: Int, tasaInteres: Double): List<CalculoInteres> {
            val LstCalculoInteres = mutableListOf<CalculoInteres>()

            var anio = 1
            do {
                var calculoIS = (anio * (tasaInteres / 100) * montoInicial) + montoInicial
                var calculoIC = (1 + (tasaInteres / 100))

                var calculoICPotencia = montoInicial * Math.pow(calculoIC, anio.toDouble())

                LstCalculoInteres.add(CalculoInteres(calculoIS, calculoICPotencia, anio))

                anio = anio + 1
            } while (anio <= anios)

            return LstCalculoInteres
        }
    }
}