package net.serkanozaydin.hsmnzaydn.data.services.LanguageServices

import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.entity.Language
import javax.security.auth.callback.Callback

interface LanguageServices {

    fun getLanguages(callback: ServiceCallback<List<Language>>)
}