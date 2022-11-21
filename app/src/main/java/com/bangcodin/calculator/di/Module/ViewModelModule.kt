package com.bangcodin.calculator.di.Module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangcodin.calculator.ui.viewmodel.CalculatorViewModel
import com.bangcodin.calculator.ui.viewmodel.LanguageViewModel
import com.bangcodin.calculator.ui.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CalculatorViewModel::class)
    internal abstract fun bindsCalculatorViewModel(calculatorViewModel: CalculatorViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LanguageViewModel::class)
    internal abstract fun bindsLanguageViewModel(languageViewModel: LanguageViewModel): ViewModel

}

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
