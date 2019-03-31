package uagrm.soe.awesomelogin.listeners

import java.util.*

interface OnCompleteRequest {
    fun onResponse(anyObject : Any)
    fun onFailure()
}