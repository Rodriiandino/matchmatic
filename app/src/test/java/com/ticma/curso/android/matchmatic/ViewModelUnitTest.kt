package com.ticma.curso.android.matchmatic

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ticma.curso.android.matchmatic.viewmodel.TextCompareViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

class ViewModelUnitTest {

    private  lateinit var viewModel: TextCompareViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = TextCompareViewModel()
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }


    @Test
    fun viewModel_CheckInitialValue() = runTest {
        val value = viewModel.liveData.value
        assertEquals(null, value)
    }

    @Test
    fun viewModel_CheckTextComparison_true() = runTest {
        viewModel.compareTexts("Hola Mundo", "Hola Mundo")
        val value = viewModel.liveData.value
        assertEquals(true, value)
    }

    @Test
    fun viewModel_CheckTextComparison_false() = runTest {
        viewModel.compareTexts("Hola Mundo", "Chau Mundo")
        val value = viewModel.liveData.value
        assertEquals(false, value)
    }

    @Test
    fun viewModel_CheckTextComparison_trimTrue() = runTest {
        viewModel.compareTexts("Hola Mundo", "Hola Mundo           ")
        val value = viewModel.liveData.value
        assertEquals(true, value)
    }

}