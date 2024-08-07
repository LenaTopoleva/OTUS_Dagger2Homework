package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorRepository
import ru.otus.daggerhomework.ColorRepositoryImpl
import javax.inject.Qualifier

@Component(
    modules = [MainActivityModule::class],
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

    fun provideColorRepository(): ColorRepository
}

@Module
interface MainActivityModule {

    @Binds
    @ActivityScope
    fun bindColorRepository(colorObserver: ColorRepositoryImpl): ColorRepository
}

@Qualifier
annotation class ActivityContext