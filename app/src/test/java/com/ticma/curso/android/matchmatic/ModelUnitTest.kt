package com.ticma.curso.android.matchmatic

import com.ticma.curso.android.matchmatic.model.TextCompareModel
import org.junit.Test
import org.junit.Assert.*

class ModelUnitTest {
    @Test
    fun testTextComparison() {
        val model = TextCompareModel()

        // Casos de prueba
        assertTrue(model.compareTexts("Hola Mundo", "Hola Mundo"))
        assertFalse(model.compareTexts("Hola Mundo", "Chau Mundo"))
        // Este caso falla porque no se está haciendo trim
        assertFalse(model.compareTexts("Hola Mundo", "Hola Mundo           "))
    }
}