package net.serkanozaydin.hsmnzaydn

import android.app.Application

import net.serkanozaydin.hsmnzaydn.di.components.ViewComponents
import net.serkanozaydin.hsmnzaydn.di.modules.PresenterModules

class MvpApp: Application() {

    private var viewComponents: ViewComponents? = null

    fun getActivityComponent(): ViewComponents? {
        return viewComponents
    }

    fun setActivityComponent(activityComponent: ViewComponents) {
        this.viewComponents = activityComponent
    }

    override fun onCreate() {
        super.onCreate()

        viewComponents = DaggerViewComponents.builder().presenterModules(PresenterModules(this)).build()
        //net.serkanozaydin.hsmnzaydn

    }
}