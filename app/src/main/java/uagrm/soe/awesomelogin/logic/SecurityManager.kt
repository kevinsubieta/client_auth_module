package uagrm.soe.awesomelogin.logic

import android.widget.EditText
import dagger.Module
import dagger.Provides

@Module
class SecurityManager {

    fun validateIfUserAuthSuccessful() : Boolean {
        return true
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