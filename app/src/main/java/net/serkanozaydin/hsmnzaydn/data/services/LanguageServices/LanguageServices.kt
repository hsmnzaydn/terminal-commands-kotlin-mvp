package net.serkanozaydin.hsmnzaydn.data.services.LanguageServices

import net.serkanozaydin.hsmnzaydn.data.entity.Language
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback

interface LanguageServices {

    fun getLanguages(callback: ServiceCallback<List<Language>>)
}