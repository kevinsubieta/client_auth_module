package uagrm.soe.awesomelogin.logic.tasks

import android.os.AsyncTask
import integgre.ma_volvo.api.service.WebService
import uagrm.soe.awesomelogin.domain.ResponseLogin
import uagrm.soe.awesomelogin.listeners.OnCompleteRequest
import kotlin.properties.Delegates

class TaskChangePassword (onCompleteRequest: OnCompleteRequest) : AsyncTask<Any, Any, Any>() {

    var onCompleteRequest: OnCompleteRequest by Delegates.notNull()
    lateinit var userName: String
    lateinit var oldPassword: String
    lateinit var newPassword: String

    init {
        this.onCompleteRequest = onCompleteRequest
    }

    override fun doInBackground(vararg p0: Any?): Any? {
        try {
            var userFromService = WebService().
                    consumePostChangePasswordService(this.userName, this.oldPassword, this.newPassword)
            if (userFromService != null) {
                return userFromService
            }
        } catch (throwable: Throwable) {
            return null
        }
        return null
    }


    override fun onPostExecute(result: Any?) {
        if (result != null) {
            this.onCompleteRequest.onResponse(result as ResponseLogin)
        } else {
            this.onCompleteRequest.onFailure()
        }
    }
}