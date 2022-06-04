package de.hackr.dev.watchschemer

import android.util.Log
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

data class Coloroid(val color1: Color, val color2: Color, val color3: Color, val stop1: Float, val stop2: Float)

object Generator {

    fun randomColoroid(): Coloroid {
        val r1 = Random.nextInt(0, 255)
        val g1 = Random.nextInt(10, 255)
        val b1 = Random.nextInt(10, 255)
        val stop1 = Random.nextInt(0, 90)
        val r2 = Random.nextInt(10, 245)
        val g2 = Random.nextInt(10, 245)
        val b2 = Random.nextInt(10, 245)
        val stop2 = Random.nextInt(stop1, 95)
        val r3 = Random.nextInt(10, 245)
        val g3 = Random.nextInt(10, 245)
        val b3 = Random.nextInt(10, 245)
        val coloroid = Coloroid(Color(r1, g1, b1),
            Color(r2, g2, b2),
            Color(r3, g3, b3),
            stop1.toFloat() / 100, stop2.toFloat() / 100)
        Log.d("Generator", coloroid.toString())
        return coloroid
    }

}