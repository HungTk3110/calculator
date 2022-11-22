package com.bangcodin.calculator.di.Module

import com.bangcodin.calculator.data.repository.Repository
import com.bangcodin.calculator.data.repository.Repositorylmpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsRepository(repository: Repositorylmpl) : Repository
}