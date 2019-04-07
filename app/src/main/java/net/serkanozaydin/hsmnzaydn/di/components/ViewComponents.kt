package net.serkanozaydin.hsmnzaydn.di.components


import dagger.Component
import net.serkanozaydin.hsmnzaydn.di.modules.DataModules
import net.serkanozaydin.hsmnzaydn.di.modules.PresenterModules
import net.serkanozaydin.hsmnzaydn.ui.CategoryActivity.MainActivity
import javax.inject.Singleton


@Singleton
@Component(modules = [PresenterModules::class, DataModules::class])
interface ViewComponents {
    fun injectMainActivity(mainActivity: MainActivity) {

    }


}