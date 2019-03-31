package uagrm.soe.awesomelogin.logic

import android.widget.EditText
import dagger.Module
import dagger.Provides
import uagrm.soe.awesomelogin.domain.ResponseLogin
import uagrm.soe.awesomelogin.listeners.ControllerListener
import uagrm.soe.awesomelogin.listeners.OnCompleteRequest

@Module
class SecurityManager {


    fun validateIfUserAuthSuccessful(userName: String, password: String,
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

    fun validateMinLengthPassOffPass() : Boolean {
        return true
    }

    fun validateNumberOfTryPass() : Boolean {
        return true
    }

    fun validateIfIsFirstStart() : Boolean {
        return true
    }

    fun validateIfUserIsAvaliable() : Boolean {
        return true
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