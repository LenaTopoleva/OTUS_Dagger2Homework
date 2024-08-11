package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            @AppContext
            appContext: Context
        ): ApplicationComponent
    }

    @AppContext
    fun provideAppContext(): Context
}

@Qualifier
annotation class AppContext

