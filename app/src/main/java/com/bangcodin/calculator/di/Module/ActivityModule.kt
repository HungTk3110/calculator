package com.bangcodin.calculator.di.Module

import com.bangcodin.calculator.ui.activity.LanguageActivity
import com.bangcodin.calculator.ui.activity.MainActivity
import com.bangcodin.calculator.ui.base.BaseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeBaseActivity(): BaseActivity

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeLanguageActivity(): LanguageActivity
}