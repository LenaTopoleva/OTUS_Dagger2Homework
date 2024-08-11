package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val colorObserver: ReceiverColorObserver
) {

    fun observeColors(): StateFlow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        return colorObserver.getColor()
    }
}