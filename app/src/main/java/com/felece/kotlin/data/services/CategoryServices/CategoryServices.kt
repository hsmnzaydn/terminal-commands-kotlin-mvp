package com.felece.kotlin.data.services.CategoryServices

import com.felece.kotlin.data.Callback
import com.felece.kotlin.data.entity.Category

interface CategoryServices {

    fun getCategories(language:String, callback:Callback<List<Category>>)
}