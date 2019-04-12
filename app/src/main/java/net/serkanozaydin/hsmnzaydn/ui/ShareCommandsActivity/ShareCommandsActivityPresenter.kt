package net.serkanozaydin.hsmnzaydn.ui.ShareCommandsActivity

import net.serkanozaydin.hsmnzaydn.R
import net.serkanozaydin.hsmnzaydn.data.DataManager
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.ui.base.BasePresenter
import javax.inject.Inject

class ShareCommandsActivityPresenter<V : ShareCommandsActivityMvpView> constructor(dataManager: DataManager) :
    BasePresenter<V>(dataManager), ShareCommandsActivityMvpPresenter<V> {

    lateinit var categoryList: ArrayList<Category>

    override fun getCategoriesAndDb() {
        mvpView.showLoading()
        dataManager.getCategories(object : ServiceCallback<List<Category>>{
            override fun onSuccess(response: List<Category>?) {
                var dbCategory=Category(1,"","",mvpView.getActivity().getString(R.string.button_commands));
                categoryList=response as ArrayList<Category>
                categoryList.add(dbCategory)

                mvpView.loadDataToList(categoryList);
                mvpView.hideLoading()
            }

            override fun onError(errorCode: Int, errorMessage: String) {
                mvpView.showError(errorMessage)
            }

        })

    }


    override fun shareCommands(selectedItems: List<Category>) {
        var headerList:ArrayList<String> = ArrayList()
        var dataList:ArrayList<String> = ArrayList()

        headerList.add("${mvpView.getActivity().getString(R.string.information_command_title)},${mvpView.getActivity().getString(R.string.information_command_description)}\r\n")

        mvpView.showLoading()
        for (i:Int in selectedItems.indices){
            var category:Category=selectedItems[i]
            if(category.v != 1){
                dataManager.getCommandsOfCategory(category.id,object : ServiceCallback<List<Command>>{
                    override fun onSuccess(response: List<Command>?) {
                    for (command:Command in response!!){
                        dataList.add("${command.title},${command.description}\r\n")
                    }
                        if(i==selectedItems.size-1){
                            mvpView.hideLoading()
                            mvpView.shareCsvFile(headerList,dataList)
                        }
                    }

                    override fun onError(errorCode: Int, errorMessage: String) {
                        mvpView.showError(errorMessage)
                    }

                })
            }else{
                dataManager.getAllCommandFromDb(object : ServiceCallback<List<Command>>{
                    override fun onSuccess(response: List<Command>?) {
                        for (command:Command in response!!){
                            dataList.add("${command.title},${command.description}\r\n")
                        }
                        if(i==selectedItems.size-1){
                            mvpView.hideLoading()
                            mvpView.shareCsvFile(headerList,dataList)
                        }

                    }

                    override fun onError(errorCode: Int, errorMessage: String) {
                    }

                })
            }



        }
        mvpView.hideLoading()



    }

}