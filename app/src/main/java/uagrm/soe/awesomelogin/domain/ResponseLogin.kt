package uagrm.soe.awesomelogin.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ResponseLogin: Serializable{

    @SerializedName("is_first_login")
    var is_first_login: Boolean? = true

    @SerializedName("error")
    var error: String? = ""

    @SerializedName("token")
    var token: String? = ""

}