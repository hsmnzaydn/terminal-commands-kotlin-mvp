package net.serkanozaydin.hsmnzaydn.di.modules

import android.content.Context

import dagger.Module
import dagger.Provides
import net.serkanozaydin.hsmnzaydn.data.ApiServices
import net.serkanozaydin.hsmnzaydn.data.ApiServicesImp
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.data.DataManagerImp
import net.serkanozaydin.hsmnzaydn.data.services.CategoryServices.CategoryServices
import net.serkanozaydin.hsmnzaydn.data.services.CategoryServices.CategoryServicesImp
import net.serkanozaydin.hsmnzaydn.data.services.CommandServices.CommandServices
import net.serkanozaydin.hsmnzaydn.data.services.CommandServices.CommandServicesImp
import javax.inject.Singleton


@Module
class DataModules {

    @Provides
    @Singleton
    fun provideDataManager(apiServices: ApiServices): DataManager {
       return DataManagerImp(apiServices)
    }

    @Provides
    @Singleton
    fun provideApiServices(categoryServices: CategoryServices, commandServices: CommandServices):ApiServices{
        return ApiServicesImp(categoryServices,commandServices);
    }

    @Provides
    @Singleton
    fun provideCommandServices(retrofitClient: net.serkanozaydin.hsmnzaydn.RetrofitClient):CommandServices{
        return CommandServicesImp(retrofitClient);
    }

    @Provides
    @Singleton
    fun provideCategoryServices(retrofitClient: net.serkanozaydin.hsmnzaydn.RetrofitClient):CategoryServices{
        return CategoryServicesImp(retrofitClient);
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(context: Context): net.serkanozaydin.hsmnzaydn.RetrofitClient {
        return net.serkanozaydin.hsmnzaydn.RetrofitClient(context)
    }
}