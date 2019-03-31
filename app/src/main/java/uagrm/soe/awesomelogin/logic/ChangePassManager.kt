package uagrm.soe.awesomelogin.logic

import android.widget.EditText
import uagrm.soe.awesomelogin.domain.ResponseFirstLogin
import uagrm.soe.awesomelogin.listeners.ControllerListener
import uagrm.soe.awesomelogin.listeners.OnCompleteRequest

class ChangePassManager {

    fun changeUserPassword(userName: String, oldPassword: String,
                           newPassword: String, controllerListener: ControllerListener) {
        var onCompleteRequest = object : OnCompleteRequest {
            override fun onResponse(anyObject: Any) {
                controllerListener.notifyController(anyObject, ResponseFirstLogin())
            }

            override fun onFailure() {
                controllerListener.notifyController(null,ResponseFirstLogin())
            }
        }
        var taskChangePass = TaskChangePassword(onCompleteRequest)
        taskChangePass.userName = userName
        taskChangePass.oldPassword = oldPassword
        taskChangePass.newPassword = newPassword
        taskChangePass.execute()
    }


    fun validateUserTextsIsEmpty(userText: EditText,oldPasswordText: EditText, newPasswordText: EditText) : Boolean {
        if (userText.text.isNullOrBlank()) {
            userText.setError("Todos los campos son obligatorios")
            return false
        }else if(oldPasswordText.text.isNullOrBlank()){
            oldPasswordText.setError("Todos los campos son obligatorios")
            return false
        }else if(newPasswordText.text.isNullOrBlank()){
            newPasswordText.setError("Todos los campos son obligatorios")
            return false
        }
        return  true
    }

}