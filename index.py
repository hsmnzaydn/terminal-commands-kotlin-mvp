import os
#
packageName=None
projectName=None
while True:
        print('Enter folder name')
        folderName=input()
        print('Which view type? \n -Activity \n -Fragment')
        viewType=input()

        if packageName==None:
              print('Enter package name')
              packageName=input()  
        if projectName==None:
              print('Enter project name')
              projectName=input()      
        os.system("mkdir "+folderName+viewType)
        os.system("touch "+folderName+viewType+"MvpPresenter.java")
        os.system("touch "+folderName+viewType+"MvpView.java")
        os.system("touch "+folderName+viewType+"Presenter.java")

        package='package '+packageName+'.ui.'+folderName+viewType+';'

        mvpPresenterImport='import '+packageName+'.ui.base.MvpPresenter;'
        mvpViewImport='import '+packageName+'.ui.base.MvpView;'
        presenterImport='import '+packageName+'.data.DataManager;\n'+'import '+packageName+'.ui.base.BasePresenter;\n'+'import javax.inject.Inject;'

        with open(folderName+viewType+"MvpPresenter.java", 'a') as file:
            file.write(package+'\n'+mvpPresenterImport+'\npublic interface '+folderName+viewType+'MvpPresenter<V extends '+folderName+viewType+'MvpView> extends MvpPresenter<V> {}')


        with open(folderName+viewType+"MvpView.java", 'a') as file:
            file.write(package+'\n'+mvpViewImport+'\npublic interface '+folderName+viewType+"MvpView extends MvpView {}")    

        with open(folderName+viewType+"Presenter.java", 'a') as file:
            file.write(package+'\n'+presenterImport+'\npublic class '+folderName+viewType+'Presenter<V extends '+folderName+viewType+'MvpView> extends BasePresenter<V> implements '+folderName+viewType+'MvpPresenter<V> {@Inject public '+folderName+viewType+'Presenter(DataManager dataManager) {super(dataManager);}}')    

        os.system('mv '+folderName+viewType+"MvpPresenter.java "+ folderName+viewType+'/')
        os.system('mv '+folderName+viewType+"MvpView.java "+ folderName+viewType+'/')
        os.system('mv '+folderName+viewType+"Presenter.java "+ folderName+viewType+'/')

        os.system('mv '+folderName+viewType+' app/src/main/java/net/serkanozaydin/hsmnzaydn/ui/')
        print('\n\n Created '+folderName+viewType+'\n')
