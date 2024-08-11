package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.ColorObserverImpl
import ru.otus.daggerhomework.ProducerColorObserver
import ru.otus.daggerhomework.ReceiverColorObserver
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

    fun provideProducerColorObserver(): ProducerColorObserver

    fun provideReceiverColorObserver(): ReceiverColorObserver
}

@Module
interface MainActivityModule {

    @Binds
    fun bindProducerColorObserver(producerColorObserver: ColorObserver): ProducerColorObserver

    @Binds
    fun bindReceiverColorObserver(receiverColorObserver: ColorObserver): ReceiverColorObserver

    @Binds
    @ActivityScope
    fun bindColorObserver(colorObserver: ColorObserverImpl): ColorObserver


}

@Qualifier
annotation class ActivityContext