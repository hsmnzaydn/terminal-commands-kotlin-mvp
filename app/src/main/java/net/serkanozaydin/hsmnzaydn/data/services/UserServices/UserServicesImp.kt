package hsmnzaydn.serkanozaydin.net.data.services.UserServices


import net.serkanozaydin.hsmnzaydn.data.entity.UserRegisterRequest
import net.serkanozaydin.hsmnzaydn.data.entity.UserRegisterResponse
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.services.CoreBaseResponse
import net.serkanozaydin.hsmnzaydn.data.services.RetrofitClient
import net.serkanozaydin.hsmnzaydn.data.services.Services
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserServicesImp : UserServices {
    lateinit var apiServices: Services


    @Inject
    constructor(retrofitClient: RetrofitClient) {
        apiServices = retrofitClient.getClient().create(Services::class.java)

    }


    override fun userRegister(
        userRegisterRequest: UserRegisterRequest,
        callback: ServiceCallback<UserRegisterResponse>
    ) {
        var call = apiServices.registerUser(userRegisterRequest)

        call.enqueue(object : Callback<CoreBaseResponse<UserRegisterResponse>> {

            override fun onFailure(
                p0: Call<CoreBaseResponse<UserRegisterResponse>>,
                p1: Throwable
            ) {
                callback.onError(500,p1.message.toString())

            }

            override fun onResponse(
                p0: Call<CoreBaseResponse<UserRegisterResponse>>,
                p1: Response<CoreBaseResponse<UserRegisterResponse>>
            ) {
                callback.onSuccess(p1.body()?.data)

            }

        })
    }
}