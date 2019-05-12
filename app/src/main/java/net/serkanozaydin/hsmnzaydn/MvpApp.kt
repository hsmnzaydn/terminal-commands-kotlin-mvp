package net.serkanozaydin.hsmnzaydn

import android.app.Application
import android.content.Context
import com.google.firebase.FirebaseApp
import net.serkanozaydin.hsmnzaydn.di.components.DaggerViewComponents

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

        FirebaseApp.initializeApp(this)
        viewComponents = DaggerViewComponents.builder().presenterModules(PresenterModules(this)).build()
        //net.serkanozaydin.hsmnzaydn

    }
}