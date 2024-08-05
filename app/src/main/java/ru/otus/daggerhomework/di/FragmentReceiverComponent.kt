package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@FeatureScope
@Component(
    modules = [],
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentReceiverComponent
    }

    fun inject(fragmentReceiver: FragmentReceiver)
}