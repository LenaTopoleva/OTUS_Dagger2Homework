package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory()
            .create(appContext = this)
    }
}