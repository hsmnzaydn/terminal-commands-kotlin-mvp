package net.serkanozaydin.hsmnzaydn.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.ui.CategoryActivity.CategoryActivityMvpPresenter
import net.serkanozaydin.hsmnzaydn.ui.CategoryActivity.CategoryActivityMvpView
import net.serkanozaydin.hsmnzaydn.ui.CategoryActivity.CategoryActivityPresenter
import net.serkanozaydin.hsmnzaydn.ui.base.BasePresenter
import net.serkanozaydin.hsmnzaydn.ui.base.MvpView


import javax.inject.Singleton

@Module
class PresenterModules(app: Application) {

    private val context: Context

    init {
        this.context = app
    }

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideBasePresenter(dataManager: DataManager): BasePresenter<MvpView> {
        return BasePresenter(dataManager)
    }

   @Provides
   fun provideCategoryActivityMvpPresenter(dataManager: DataManager):CategoryActivityMvpPresenter<CategoryActivityMvpView>{
       return CategoryActivityPresenter(dataManager);
   }
}
