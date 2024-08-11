package ru.otus.daggerhomework

import android.graphics.Color
import androidx.annotation.ColorInt
import java.util.*
import javax.inject.Inject

interface ColorGenerator {

    @ColorInt
    fun generateColor(): Int
}

class ColorGeneratorImpl @Inject constructor() : ColorGenerator {

    override fun generateColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}