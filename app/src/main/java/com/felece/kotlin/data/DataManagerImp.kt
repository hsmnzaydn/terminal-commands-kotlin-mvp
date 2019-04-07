package com.felece.kotlin.data

import com.felece.kotlin.data.entity.Category
import javax.inject.Inject

class DataManagerImp:DataManager {
   lateinit var apiServices:ApiServices

    @Inject
    constructor(apiServices: ApiServices){
        this.apiServices=apiServices
    }


    override fun getCategories(language: String, callback: Callback<List<Category>>) {
        apiServices!!.getCategories(language,callback)

    }
}