package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

interface ColorObserver : ProducerColorObserver, ReceiverColorObserver

interface ProducerColorObserver {

    fun updateColor(@ColorInt color: Int)
}

interface ReceiverColorObserver {

    @ColorInt
    fun getColor(): StateFlow<Int>
}

class ColorObserverImpl @Inject constructor() : ColorObserver {

    private val _colorFlow: MutableStateFlow<Int> = MutableStateFlow(0)
    private val colorFlow: StateFlow<Int> = _colorFlow.asStateFlow()

    override fun updateColor(color: Int) {
        _colorFlow.value = color
    }

    override fun getColor(): StateFlow<Int> = colorFlow
}