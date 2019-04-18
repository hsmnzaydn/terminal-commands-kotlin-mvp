package net.serkanozaydin.hsmnzaydn.di.components


import dagger.Component
import net.serkanozaydin.hsmnzaydn.di.modules.DataModules
import net.serkanozaydin.hsmnzaydn.di.modules.PresenterModules
import net.serkanozaydin.hsmnzaydn.ui.CategoryActivity.CategoryActivity
import net.serkanozaydin.hsmnzaydn.ui.CommandListActivity.CommandListActivity
import net.serkanozaydin.hsmnzaydn.ui.MyFavouriteCommandListActivity.MyFavouriteCommandListActivity
import net.serkanozaydin.hsmnzaydn.ui.ShareCommandsActivity.ShareCommandsActivity
import net.serkanozaydin.hsmnzaydn.ui.SplashScreenActivity.SplashScreenActivity
import javax.inject.Singleton


@Singleton
@Component(modules = [PresenterModules::class, DataModules::class])
interface ViewComponents {
    fun injectMainActivity(categoryActivity: CategoryActivity) {

    }

    fun injectCommandListActivity(commandListActivity: CommandListActivity) {

    }

    fun injectMyFavouriteCommandListActivity(myFavouriteCommandListActivity: MyFavouriteCommandListActivity)
    fun injectShareCommandsActivity(shareCommandsActivity: ShareCommandsActivity)
    fun injectSplashScreenActivity(splashScreenActivity: SplashScreenActivity)


}