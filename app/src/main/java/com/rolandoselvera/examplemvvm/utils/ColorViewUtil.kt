package com.rolandoselvera.examplemvvm.utils

import android.graphics.Color
import java.util.*

class ColorViewUtil {

    // Crea un companion object para acceder a la función desde el ViewModel:
    companion object {
        // Devuelve un color de forma aleatoria:
        fun randomColor(): Int {
            val randomNumber = Random()
            return Color.argb(
                255,
                randomNumber.nextInt(256),
                randomNumber.nextInt(256),
                randomNumber.nextInt(256)
            )
        }
    }
}