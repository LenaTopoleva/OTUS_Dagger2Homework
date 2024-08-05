package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@FeatureScope
@Component(
    modules = [],
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(fragmentProducer: FragmentProducer)
}