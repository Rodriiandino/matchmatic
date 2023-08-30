package com.ticma.curso.android.matchmatic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ticma.curso.android.matchmatic.model.TextCompareModel


//El patrón de arquitectura de MVVM
//ViewModel maneja la lógica de comparación de textos y actualiza los datos en LiveData
class TextCompareViewModel : ViewModel() {

    private val model = TextCompareModel()

    // LiveData es una clase que nos permite observar cambios en los datos
    val liveData: LiveData<Boolean> get() = _liveData

    // MutableLiveData es una clase que nos permite modificar los datos
    private var _liveData = MutableLiveData<Boolean>()

    fun compareTexts(text1: String, text2: String) {
        // trim() elimina los espacios en blanco al principio y al final de un String
        // Lo trato aca y no en el model, ya que esta relacionado con la presentación y preparación de datos para la interfaz de usuario
        val trimText1 = text1.trim()
        val trimText2 = text2.trim()

        val areEqual = model.compareTexts(trimText1, trimText2)
        _liveData.value = areEqual
    }
}