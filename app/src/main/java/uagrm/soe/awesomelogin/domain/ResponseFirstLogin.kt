package uagrm.soe.awesomelogin.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ResponseFirstLogin: Serializable {

    @SerializedName("response")
    var response: String? = ""

    @SerializedName("error")
    var error: String? = ""
}