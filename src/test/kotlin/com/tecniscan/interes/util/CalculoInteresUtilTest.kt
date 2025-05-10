package com.tecniscan.interes.util

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class CalculoInteresUtilTest {

    @Test
    fun testCalculoNotNull() {
        val lista=CalculoInteresUtil.calculo(1.00,1,1.0)
        assertNotNull(lista)
    }


    @Test
    fun testCalculoDiezAnios() {
        val lista=CalculoInteresUtil.calculo(100.00,10,100.0)
        assertNotNull(lista)
        assertEquals(10,lista.count())
        assertEquals(1100.00,lista.get(9).interesSimple)
        assertEquals(102400.00,lista.get(9).interesCompuesto)

    }

    @Test
    fun testMontoInicialCero() {
        val lista=CalculoInteresUtil.calculo(0.00,10,100.0)
        assertNotNull(lista)
        assertEquals(10,lista.count())
        assertEquals(0.00,lista.get(9).interesSimple)
        assertEquals(0.00,lista.get(9).interesCompuesto)
    }


    @Test
    fun testUnAnio() {
        val lista=CalculoInteresUtil.calculo(100.00,1,100.0)
        assertNotNull(lista)
        assertEquals(1,lista.count())
        assertEquals(200.00,lista.get(0).interesSimple)
        assertEquals(200.00,lista.get(0).interesCompuesto)
    }

    @Test
    fun testTasaInteres() {
        val lista=CalculoInteresUtil.calculo(100.00,10,0.0)
        assertNotNull(lista)
        assertEquals(10,lista.count())
        assertEquals(100.00,lista.get(9).interesSimple)
        assertEquals(100.00,lista.get(9).interesCompuesto)
    }

}