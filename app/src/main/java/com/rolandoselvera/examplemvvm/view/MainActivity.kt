package com.rolandoselvera.examplemvvm.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.rolandoselvera.examplemvvm.databinding.ActivityMainBinding
import com.rolandoselvera.examplemvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observador de la cita textual:
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.apply {
                txtQuote.text = currentQuote.quote
                txtBook.text = currentQuote.book
                txtAuthor.text = currentQuote.author
            }
        })

        // Observador para el color:
        quoteViewModel.colorView.observe(this, Observer { randomColor ->
            // Establece un color de fondo en el contenedor:
            binding.viewContainer.setBackgroundColor(randomColor)

            // Establece el mismo color de fondo del contenedor al status bar:
            window.statusBarColor = randomColor
        })

        // Acción al presionar el botón siguiente:
        binding.btnNext.setOnClickListener {
            quoteViewModel.randomQuote()
            quoteViewModel.randomBackgroundColor()
        }
    }
}