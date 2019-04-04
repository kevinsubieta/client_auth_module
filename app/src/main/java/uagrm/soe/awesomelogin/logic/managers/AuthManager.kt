package uagrm.soe.awesomelogin.logic.managers

import android.content.Context
import android.view.View
import integgre.ma_volvo.business.patterns.builder.PreferencesBuilder
import integgre.ma_volvo.constanst.ConstanstFiles
import uagrm.soe.awesomelogin.domain.AuthSettings
import uagrm.soe.awesomelogin.domain.ResponseLogin
import uagrm.soe.awesomelogin.listeners.ControllerListener
import uagrm.soe.awesomelogin.listeners.OnCompleteRequest
import uagrm.soe.awesomelogin.logic.tasks.TaskGetAuthParams
import uagrm.soe.awesomelogin.logic.tasks.TaskSaveAuthParams

class AuthManager {

    val SECONDS = 0
    val MINUTES = 1
    val HOURS = 2
    val DAYS = 3

    fun getAuthParametersWithServiceByTokenId(context: Context, controllerListener: ControllerListener){
        var token = PreferencesBuilder
                .build(context,ConstanstFiles.PREFERENCES_USER)
                .getString(ConstanstFiles.USER_KEY_TOKEN, "")

        var onCompleteRequest = object : OnCompleteRequest {
            override fun onResponse(anyObject: Any) {
                controllerListener.notifyController(anyObject, ResponseLogin())
            }

            override fun onFailure() {
                controllerListener.notifyController(null, ResponseLogin())
            }
        }

        var taskGetAuthParams = TaskGetAuthParams(onCompleteRequest)
        taskGetAuthParams.token = token!!
        taskGetAuthParams.execute()
    }



    fun saveAuthParametersWithService(context: Context, authSettingsToSave: AuthSettings,
                                      controllerListener: ControllerListener){
        var token = PreferencesBuilder
                .build(context,ConstanstFiles.PREFERENCES_USER)
                .getString(ConstanstFiles.USER_KEY_TOKEN, "")

        var onCompleteRequest = object : OnCompleteRequest {
            override fun onResponse(anyObject: Any) {
                controllerListener.notifyController(anyObject, ResponseLogin())
            }

            override fun onFailure() {
                controllerListener.notifyController(null, ResponseLogin())
            }
        }
        var  taskSaveAuthParams = TaskSaveAuthParams(onCompleteRequest)
        taskSaveAuthParams.token = token!!
        taskSaveAuthParams.newParametersToSave = authSettingsToSave
        taskSaveAuthParams.execute()
    }

    fun convertPassTimeInSeconds(value: Int, position : Int) : Int{
        when (position) {
            SECONDS -> return value
            MINUTES -> return value * 60
            HOURS -> return value * 3600
            DAYS -> return value * 86400
            else -> return value
        }
    }

    fun convertSessionTimeInMinutes(value: Int, position: Int) : Int{
        when (position) {
            SECONDS -> return value / 60
            MINUTES -> return value
            HOURS -> return value * 60
            DAYS -> return value * 1440
            else -> return value
        }
    }

    fun logOut(context: Context){
        PreferencesBuilder
                .build(context,ConstanstFiles.PREFERENCES_USER)
                .removeKey(ConstanstFiles.USER_KEY_TOKEN)
    }
}