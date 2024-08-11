package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val colorObserver: ProducerColorObserver
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val newColor = colorGenerator.generateColor()
        colorObserver.updateColor(newColor)
        Toast.makeText(context, "Color sent, new color: $newColor", Toast.LENGTH_LONG).show()
    }
}