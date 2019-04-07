package com.felece.kotlin.di.modules

import android.app.Application
import android.content.Context
import com.felece.kotlin.MvpApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PresenterModules {

    lateinit var context: Context

    constructor(app:Application){
        this.context = app

    }

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return context
    }

}