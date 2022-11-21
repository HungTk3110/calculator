package com.bangcodin.calculator.di.Module

import com.bangcodin.calculator.ui.base.BaseFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeBaseFragment() : BaseFragment

}