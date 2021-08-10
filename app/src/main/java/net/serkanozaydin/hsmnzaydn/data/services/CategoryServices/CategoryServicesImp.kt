package net.serkanozaydin.hsmnzaydn.data.services.CategoryServices


import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.services.CoreBaseResponse
import net.serkanozaydin.hsmnzaydn.data.services.RetrofitClient
import net.serkanozaydin.hsmnzaydn.data.services.Services
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class CategoryServicesImp : CategoryServices {


    lateinit var apiServices: Services


    @Inject
    constructor(retrofitClient: RetrofitClient) {
        apiServices = retrofitClient.getClient().create(Services::class.java)

    }


    override fun getCategories(serviceCallback: ServiceCallback<List<Category>>) {
        var call = apiServices.getCategories()

        call.enqueue(object : retrofit2.Callback<CoreBaseResponse<List<Category>>> {

            override fun onFailure(p0: Call<CoreBaseResponse<List<Category>>>, p1: Throwable) {
                serviceCallback.onError(500,p1.localizedMessage)
            }

            override fun onResponse(
                p0: Call<CoreBaseResponse<List<Category>>>,
                p1: Response<CoreBaseResponse<List<Category>>>
            ) {
                serviceCallback.onSuccess(p1.body()?.data!!)
            }

        })
    }

    override fun getCommandsOfCategory(categoryId: String, serviceCallback: ServiceCallback<List<Command>>) {
        var call = apiServices.getCommandOfCategory(categoryId)
        call.enqueue(object : retrofit2.Callback<CoreBaseResponse<List<Command>>> {

            override fun onFailure(p0: Call<CoreBaseResponse<List<Command>>>, p1: Throwable) {
                serviceCallback.onError(500,p1.localizedMessage)
            }

            override fun onResponse(
                p0: Call<CoreBaseResponse<List<Command>>>,
                p1: Response<CoreBaseResponse<List<Command>>>
            ) {
                serviceCallback.onSuccess(p1.body()?.data)
            }

        })


    }

}