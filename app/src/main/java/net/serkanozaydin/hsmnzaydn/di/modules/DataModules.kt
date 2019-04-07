package net.serkanozaydin.hsmnzaydn.di.modules

import android.content.Context

import dagger.Module
import dagger.Provides
import net.serkanozaydin.hsmnzaydn.data.*
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
    fun provideCommandServices(retrofitClient: RetrofitClient):CommandServices{
        return CommandServicesImp(retrofitClient);
    }

    @Provides
    @Singleton
    fun provideCategoryServices(retrofitClient: RetrofitClient):CategoryServices{
        return CategoryServicesImp(retrofitClient);
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(context: Context): RetrofitClient {
        return RetrofitClient(context)
    }
}