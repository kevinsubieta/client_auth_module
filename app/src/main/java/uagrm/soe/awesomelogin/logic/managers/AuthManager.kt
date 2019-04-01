package uagrm.soe.awesomelogin.logic.managers

import android.content.Context
import integgre.ma_volvo.business.patterns.builder.PreferencesBuilder
import integgre.ma_volvo.constanst.ConstanstFiles
import uagrm.soe.awesomelogin.domain.ResponseLogin
import uagrm.soe.awesomelogin.listeners.ControllerListener
import uagrm.soe.awesomelogin.listeners.OnCompleteRequest
import uagrm.soe.awesomelogin.logic.tasks.TaskGetAuthParams

class AuthManager {

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
}