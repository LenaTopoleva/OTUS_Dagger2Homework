package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorRepository
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val activityContext: Context,
    @AppContext private val appContext: Context,
    private val colorRepository: ColorRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelProducer::class.java))
            ViewModelProducer(colorGenerator, activityContext, colorRepository) as T
        else if (modelClass.isAssignableFrom(ViewModelReceiver::class.java))
            ViewModelReceiver(appContext, colorRepository) as T
        else throw IllegalArgumentException()
    }
}