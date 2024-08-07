package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent = DaggerMainActivityComponent.factory().create(
            activityContext = this,
            applicationComponent = (application as App).applicationComponent
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.producerFragmentContainer, FragmentProducer())
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.receiverFragmentContainer, FragmentReceiver())
            .commit()
    }
}