package com.bangcodin.calculator.di.Module

import com.bangcodin.calculator.ui.base.BaseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeBaseActivity(): BaseActivity
}