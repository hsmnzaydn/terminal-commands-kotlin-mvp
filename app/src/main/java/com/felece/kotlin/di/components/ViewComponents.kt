package com.felece.kotlin.di.components

import com.felece.kotlin.di.modules.DataModules
import com.felece.kotlin.di.modules.PresenterModules
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [PresenterModules::class, DataModules::class])
interface ViewComponents {


}