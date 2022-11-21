package com.bangcodin.calculator.di.Module

import dagger.Module

@Module(
    includes = [
        ActivityModule::class ,
        ApiModule :: class ,
        RoomDbModule :: class ,
        ViewModelModule :: class ,
        RepositoryModule::class ,
        FragmentModule::class
    ]
)
class AppModule