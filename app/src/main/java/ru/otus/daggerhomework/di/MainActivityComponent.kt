package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Component(
    dependencies = [ApplicationComponent::class]
)
@ActivityScope
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ActivityContext
            activityContext: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }

    @AppContext
    fun provideAppContext(): Context

    @ActivityContext
    fun provideActivityContext(): Context
}

@Qualifier
annotation class ActivityContext