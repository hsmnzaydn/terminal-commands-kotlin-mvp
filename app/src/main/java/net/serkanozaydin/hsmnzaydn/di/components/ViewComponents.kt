package net.serkanozaydin.hsmnzaydn.di.components


import dagger.Component
import net.serkanozaydin.hsmnzaydn.di.modules.DataModules
import net.serkanozaydin.hsmnzaydn.di.modules.PresenterModules
import net.serkanozaydin.hsmnzaydn.ui.CategoryActivity.CategoryActivity
import net.serkanozaydin.hsmnzaydn.ui.CommandListActivity.CommandListActivity
import javax.inject.Singleton


@Singleton
@Component(modules = [PresenterModules::class, DataModules::class])
interface ViewComponents {
    fun injectMainActivity(categoryActivity: CategoryActivity) {

    }

    fun injectCommandListActivity(commandListActivity: CommandListActivity) {

    }


}