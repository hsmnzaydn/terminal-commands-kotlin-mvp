package net.serkanozaydin.hsmnzaydn.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.ui.CategoryActivity.CategoryActivityMvpPresenter
import net.serkanozaydin.hsmnzaydn.ui.CategoryActivity.CategoryActivityMvpView
import net.serkanozaydin.hsmnzaydn.ui.CategoryActivity.CategoryActivityPresenter
import net.serkanozaydin.hsmnzaydn.ui.CommandListActivity.CommandListActivityMvpView
import net.serkanozaydin.hsmnzaydn.ui.CommandListActivity.CommandListActivityPresenter
import net.serkanozaydin.hsmnzaydn.ui.MyFavouriteCommandListActivity.MyFavouriteCommandListActivityMvpPresenter
import net.serkanozaydin.hsmnzaydn.ui.MyFavouriteCommandListActivity.MyFavouriteCommandListActivityMvpView
import net.serkanozaydin.hsmnzaydn.ui.MyFavouriteCommandListActivity.MyFavouriteCommandListActivityPresenter
import net.serkanozaydin.hsmnzaydn.ui.ShareCommandsActivity.ShareCommandsActivityMvpView
import net.serkanozaydin.hsmnzaydn.ui.ShareCommandsActivity.ShareCommandsActivityPresenter
import net.serkanozaydin.hsmnzaydn.ui.SplashScreenActivity.SplashScreenActivityMvpPresenter
import net.serkanozaydin.hsmnzaydn.ui.SplashScreenActivity.SplashScreenActivityMvpView
import net.serkanozaydin.hsmnzaydn.ui.SplashScreenActivity.SplashScreenActivityPresenter
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

    @Provides
    fun provideCommandListActivityMvpPresenter(dataManager: DataManager):CommandListActivityPresenter<CommandListActivityMvpView>{
        return CommandListActivityPresenter(dataManager)
    }

    @Provides
    fun provideMyFavouriteCommandListActivityMvpPresenter(dataManager: DataManager):MyFavouriteCommandListActivityMvpPresenter<MyFavouriteCommandListActivityMvpView>{
        return MyFavouriteCommandListActivityPresenter(dataManager)
    }

    @Provides
    fun provideShareCommandsActivityMvpPresenter(dataManager: DataManager):ShareCommandsActivityPresenter<ShareCommandsActivityMvpView>{
        return ShareCommandsActivityPresenter(dataManager)
    }

    @Provides
    fun provideSplashScreenActivityMvpPresenter(dataManager: DataManager):SplashScreenActivityMvpPresenter<SplashScreenActivityMvpView>{
        return SplashScreenActivityPresenter(dataManager)
    }
}
