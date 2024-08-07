package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

interface ColorRepository {

    fun updateColor(@ColorInt color: Int)

    @ColorInt
    fun getColor(): StateFlow<Int>
}

class ColorRepositoryImpl @Inject constructor() : ColorRepository {

    private val _colorFlow: MutableStateFlow<Int> = MutableStateFlow(0)
    private val colorFlow: StateFlow<Int> = _colorFlow.asStateFlow()

    override fun updateColor(color: Int) {
        _colorFlow.value = color
    }

    override fun getColor(): StateFlow<Int> = colorFlow
}