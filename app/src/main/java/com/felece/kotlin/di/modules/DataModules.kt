package com.felece.kotlin.di.modules

import android.content.Context
import com.felece.kotlin.RetrofitClient
import com.felece.kotlin.data.ApiServices
import com.felece.kotlin.data.ApiServicesImp
import com.felece.kotlin.data.DataManager
import com.felece.kotlin.data.DataManagerImp
import com.felece.kotlin.data.services.CategoryServices.CategoryServices
import com.felece.kotlin.data.services.CategoryServices.CategoryServicesImp
import com.felece.kotlin.data.services.CommandServices.CommandServices
import com.felece.kotlin.data.services.CommandServices.CommandServicesImp
import dagger.Module
import dagger.Provides
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
    fun provideApiServices(categoryServices:CategoryServices,commandServices: CommandServices):ApiServices{
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
    fun provideRetrofitClient(context: Context):RetrofitClient{
        return RetrofitClient(context)
    }
}