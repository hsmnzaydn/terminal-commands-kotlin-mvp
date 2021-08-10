package net.serkanozaydin.hsmnzaydn.data.services

import hsmnzaydn.serkanozaydin.net.data.services.UserServices.UserServices
import net.serkanozaydin.hsmnzaydn.data.services.CategoryServices.CategoryServices
import net.serkanozaydin.hsmnzaydn.data.services.CommandServices.CommandServices
import net.serkanozaydin.hsmnzaydn.data.services.LanguageServices.LanguageServices


interface ApiServices: CategoryServices, CommandServices, LanguageServices, UserServices {
}