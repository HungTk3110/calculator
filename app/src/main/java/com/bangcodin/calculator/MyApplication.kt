package com.bangcodin.calculator

import android.util.Log
import androidx.work.Configuration
import com.example.demo.data.component.DaggerAppComponent
import com.example.demo.worker.WorkerFactory
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class MyApplication : DaggerApplication() , Configuration.Provider{
    private val applicationInjector = DaggerAppComponent.builder().application(this).build()
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}