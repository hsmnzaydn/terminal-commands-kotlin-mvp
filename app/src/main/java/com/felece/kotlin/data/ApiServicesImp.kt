package com.felece.kotlin.data

import com.felece.kotlin.data.services.CategoryServices.CategoryServices
import com.felece.kotlin.data.services.CategoryServices.CategoryServicesImp
import com.felece.kotlin.data.entity.Category
import com.felece.kotlin.data.services.CommandServices.CommandServices
import com.felece.kotlin.data.services.CommandServices.CommandServicesImp
import javax.inject.Inject

class ApiServicesImp:ApiServices {
    lateinit var categoryServices:CategoryServices
    lateinit var commandServices:CommandServices;

    @Inject
    constructor(categoryServices:CategoryServices,commandServices: CommandServices){
        this.categoryServices=categoryServices
        this.commandServices=commandServices
    }


    override fun getCategories(language: String, callback: Callback<List<Category>>) {
        categoryServices!!.getCategories(language,callback)
    }
}