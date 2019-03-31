package uagrm.soe.awesomelogin.logic

import android.os.AsyncTask
import integgre.ma_volvo.api.service.WebService
import uagrm.soe.awesomelogin.domain.ResponseLogin
import uagrm.soe.awesomelogin.listeners.OnCompleteRequest
import kotlin.properties.Delegates

class TaskLoginUser(onCompleteRequest: OnCompleteRequest) : AsyncTask<Any, Any, Any>() {

    var onCompleteRequest: OnCompleteRequest by Delegates.notNull()
    lateinit var userName: String
    lateinit var password: String

    init {
        this.onCompleteRequest = onCompleteRequest
    }

    override fun doInBackground(vararg p0: Any?): Any? {
        try {
            var userFromService = WebService().consumePostLoginUserWithService(this.userName, this.password)
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
