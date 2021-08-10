package hsmnzaydn.serkanozaydin.net.data.services.UserServices

import net.serkanozaydin.hsmnzaydn.data.entity.UserRegisterRequest
import net.serkanozaydin.hsmnzaydn.data.entity.UserRegisterResponse
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback


interface UserServices {

    fun userRegister(userRegisterRequest: UserRegisterRequest, callback: ServiceCallback<UserRegisterResponse>)
}