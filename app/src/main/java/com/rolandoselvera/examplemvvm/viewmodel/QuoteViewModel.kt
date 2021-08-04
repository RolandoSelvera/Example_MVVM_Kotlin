package com.rolandoselvera.examplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rolandoselvera.examplemvvm.model.QuoteModel
import com.rolandoselvera.examplemvvm.model.QuoteProvider
import com.rolandoselvera.examplemvvm.utils.ColorViewUtil

// ViewModel de la vista (MainActivity):
class QuoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    val colorView = MutableLiveData<Int>()

    // Inicializa ViewModel con una cita y un color de fondo al ejecutar/abrir la app por primera vez:
    init {
        randomQuote()
        randomBackgroundColor()
    }

    // Establece una cita de forma aleatoria:
    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }

    // Establece un color de forma aleatoria:
    fun randomBackgroundColor() {
        val randomColor = ColorViewUtil.randomColor()
        colorView.postValue(randomColor)
    }
}