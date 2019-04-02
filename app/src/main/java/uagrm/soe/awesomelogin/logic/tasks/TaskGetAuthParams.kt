package uagrm.soe.awesomelogin.logic.tasks

import android.os.AsyncTask
import integgre.ma_volvo.api.service.WebService
import uagrm.soe.awesomelogin.domain.AuthSettings
import uagrm.soe.awesomelogin.listeners.OnCompleteRequest
import kotlin.properties.Delegates

class TaskGetAuthParams(onCompleteRequest: OnCompleteRequest) : AsyncTask<Any, Any, Any>() {

    var onCompleteRequest: OnCompleteRequest by Delegates.notNull()
    lateinit var token: String

    init {
        this.onCompleteRequest = onCompleteRequest
    }

    override fun doInBackground(vararg p0: Any?): Any? {
        try {
            var userFromService = WebService().
                    consumePostGetAllParameters(token)
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
            this.onCompleteRequest.onResponse(result as AuthSettings)
        } else {
            this.onCompleteRequest.onFailure()
        }
    }
}