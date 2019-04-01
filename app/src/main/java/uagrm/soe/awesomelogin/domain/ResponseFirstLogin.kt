package uagrm.soe.awesomelogin.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ResponseFirstLogin: Serializable {

    @SerializedName("success")
    var success: Boolean = false

    @SerializedName("error")
    var error: String? = ""
}