package com.ticma.curso.android.matchmatic

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ticma.curso.android.matchmatic.databinding.ActivityMainBinding
import com.ticma.curso.android.matchmatic.viewmodel.TextCompareViewModel

class MainActivity : AppCompatActivity() {
    // binding es una variable que nos permite acceder a los elementos de la vista
    private lateinit var binding: ActivityMainBinding

    // mainViewModel es una variable que nos permite acceder al ViewModel
    private val mainViewModel: TextCompareViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.liveData.observe(this) { areEqual ->
            if (areEqual) {
                showEqualResult()
            } else {
                showNotEqualResult()
            }
        }

        binding.button.setOnClickListener {
            val text1 = binding.textToCompare.text.toString()
            val text2 = binding.textToCompare2.text.toString()
            mainViewModel.compareTexts(text1, text2)
        }
    }

    private fun showEqualResult() {
        binding.textEqualToShow.visibility = View.VISIBLE
        binding.textUnequalToShow.visibility = View.GONE
    }

    private fun showNotEqualResult() {
        binding.textUnequalToShow.visibility = View.VISIBLE
        binding.textEqualToShow.visibility = View.GONE
    }
}