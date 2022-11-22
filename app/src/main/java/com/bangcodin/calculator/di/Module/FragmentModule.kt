package com.bangcodin.calculator.di.Module

import com.bangcodin.calculator.ui.base.BaseFragment
import com.bangcodin.calculator.ui.fragment.*

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeBaseFragment() : BaseFragment

    @ContributesAndroidInjector
    abstract fun contributeCalculatorFragment() : CalculatorFragment

    @ContributesAndroidInjector
    abstract fun contributeCurrencyConversionFragment() : CurrencyConversionFragment

    @ContributesAndroidInjector
    abstract fun contributeHistoryFragment() : HistoryFragment

    @ContributesAndroidInjector
    abstract fun contributeLengthFragment() : LengthFragment

    @ContributesAndroidInjector
    abstract fun contributeWeightFragment() : WeightFragment

    @ContributesAndroidInjector
    abstract fun contributeTemperatureFragment() : TemperatureFragment

    @ContributesAndroidInjector
    abstract fun contributeConverterFragment() : ConverterFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingFragment() : SettingFragment
}