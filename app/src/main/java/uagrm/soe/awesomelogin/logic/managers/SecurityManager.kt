package uagrm.soe.awesomelogin.logic.managers

import android.content.Context
import android.widget.EditText
import dagger.Module
import integgre.ma_volvo.business.patterns.builder.PreferencesBuilder
import integgre.ma_volvo.constanst.ConstanstFiles
import uagrm.soe.awesomelogin.domain.ResponseLogin
import uagrm.soe.awesomelogin.listeners.ControllerListener
import uagrm.soe.awesomelogin.listeners.OnCompleteRequest
import uagrm.soe.awesomelogin.logic.tasks.TaskLoginUser

@Module
class SecurityManager {


    fun authenticateUserWithService(userName: String, password: String,
                                     controllerListener: ControllerListener) {
        var onCompleteRequest = object : OnCompleteRequest{
            override fun onResponse(anyObject: Any) {
                controllerListener.notifyController(anyObject, ResponseLogin())
            }

            override fun onFailure() {
                controllerListener.notifyController(null,ResponseLogin())
            }
        }
        var taskLoginUser = TaskLoginUser(onCompleteRequest)
        taskLoginUser.userName = userName
        taskLoginUser.password = password
        taskLoginUser.execute()
    }

    fun getCurrentSession(context: Context): String{
        var token = PreferencesBuilder
                .build(context,ConstanstFiles.PREFERENCES_USER)
                .getString(ConstanstFiles.USER_KEY_TOKEN, "")
        return token!!
    }


    fun validateIfIsFirstStart(responseLogin: ResponseLogin) : Boolean {
        return responseLogin.mustChangePassword!!
    }

    fun validateIfUserIsAvaliable(responseLogin: ResponseLogin) : Boolean {
        return responseLogin.userEnabled!!
    }

    fun validateIfExistAnyError(responseLogin: ResponseLogin) : Boolean {
          return responseLogin.error!!.isNotEmpty()
    }

    fun validateIfUserAuthIsOk(responseLogin: ResponseLogin) : Boolean {
        return !responseLogin.failedLogin!!
    }

    fun saveUserToken(context: Context,responseLogin: ResponseLogin){
        PreferencesBuilder.build(context, ConstanstFiles.PREFERENCES_USER)
                .putString(ConstanstFiles.USER_KEY_TOKEN, responseLogin.token!!)
    }


    fun validateUserTextsIsEmpty(userText: EditText, passwordText: EditText) : Boolean {
        if (userText.text.isNullOrBlank()) {
            userText.setError("Todos los campos son obligatorios")
            return false
        }else if(passwordText.text.isNullOrBlank()){
            passwordText.setError("Todos los campos son obligatorios")
            return false
        }
        return  true
    }

}