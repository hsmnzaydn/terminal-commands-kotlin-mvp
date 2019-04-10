package net.serkanozaydin.hsmnzaydn.di.modules

import android.content.Context

import dagger.Module
import dagger.Provides
import net.serkanozaydin.hsmnzaydn.data.*
import net.serkanozaydin.hsmnzaydn.data.db.Command.CommandDb
import net.serkanozaydin.hsmnzaydn.data.db.Command.CommandDbImp
import net.serkanozaydin.hsmnzaydn.data.db.DBServices
import net.serkanozaydin.hsmnzaydn.data.db.DBServicesImp
import net.serkanozaydin.hsmnzaydn.data.pref.PrefHelper
import net.serkanozaydin.hsmnzaydn.data.pref.PrefHelperImp
import net.serkanozaydin.hsmnzaydn.data.services.ApiServices
import net.serkanozaydin.hsmnzaydn.data.services.ApiServicesImp
import net.serkanozaydin.hsmnzaydn.data.services.CategoryServices.CategoryServices
import net.serkanozaydin.hsmnzaydn.data.services.CategoryServices.CategoryServicesImp
import net.serkanozaydin.hsmnzaydn.data.services.CommandServices.CommandServices
import net.serkanozaydin.hsmnzaydn.data.services.CommandServices.CommandServicesImp
import net.serkanozaydin.hsmnzaydn.data.services.LanguageServices.LanguageServices
import net.serkanozaydin.hsmnzaydn.data.services.LanguageServices.LanguageServicesImp
import net.serkanozaydin.hsmnzaydn.data.services.RetrofitClient
import javax.inject.Singleton


@Module
class DataModules {

    @Provides
    @Singleton
    fun provideDataManager(apiServices: ApiServices,prefHelper: PrefHelper,db: DBServices): DataManager {
       return DataManagerImp(apiServices,prefHelper,db)
    }

    @Provides
    @Singleton
    fun providePrefHelper(context: Context):PrefHelper{
        return PrefHelperImp(context)
    }

    @Provides
    @Singleton
    fun provideApiServices(categoryServices: CategoryServices, commandServices: CommandServices,languageServices: LanguageServices): ApiServices {
        return ApiServicesImp(categoryServices, commandServices,languageServices);
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
    fun provideRetrofitClient(context: Context,prefHelper: PrefHelper): RetrofitClient {
        return RetrofitClient(context,prefHelper)
    }

    @Provides
    @Singleton
    fun provideLanguageServices(retrofitClient: RetrofitClient):LanguageServices{
        return LanguageServicesImp(retrofitClient)
    }

    @Provides
    @Singleton
    fun provideCommandDB(context: Context):CommandDb{
        return CommandDbImp(context)
    }

    @Provides
    @Singleton
    fun provideDBServices(commandDB:CommandDb):DBServices{
        return DBServicesImp(commandDB)
    }
}