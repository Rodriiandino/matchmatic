package com.ticma.curso.android.matchmatic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ticma.curso.android.matchmatic.model.TextCompareModel

class TextCompareViewModel : ViewModel() {

    private val model = TextCompareModel()

    // LiveData es una clase que nos permite observar cambios en los datos
    val liveData: LiveData<Boolean> get() = _liveData

    // MutableLiveData es una clase que nos permite modificar los datos
    private var _liveData = MutableLiveData<Boolean>()

    fun compareTexts(text1: String, text2: String) {
        val areEqual = model.compareTexts(text1, text2)
        _liveData.value = areEqual
    }
}