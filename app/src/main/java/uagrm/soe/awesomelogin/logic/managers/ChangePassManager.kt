package uagrm.soe.awesomelogin.logic.managers

import android.content.Context
import android.widget.EditText
import uagrm.soe.awesomelogin.domain.ResponseFirstLogin
import uagrm.soe.awesomelogin.listeners.ControllerListener
import uagrm.soe.awesomelogin.listeners.OnCompleteRequest
import uagrm.soe.awesomelogin.logic.tasks.TaskChangePassword

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


    fun validateIfPasswordsAreEquals(context: Context,oldPassword:EditText, newPassword: EditText): Boolean {
        if (!oldPassword.text.toString().equals(newPassword.text.toString())){
            oldPassword.setError("Las contraseñas deben coincidir")
            newPassword.setError("Las contraseñas deben coincidir")
            return false
        }
        return true
    }

}