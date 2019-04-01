package uagrm.soe.awesomelogin.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ResponseLogin: Serializable{

    @SerializedName("change_password")
    var mustChangePassword: Boolean = true

    @SerializedName("failed_login")
    var failedLogin: Boolean = false

    @SerializedName("user_enabled")
    var userEnabled: Boolean = false

    @SerializedName("is_admin")
    var isAdmin: Boolean = false

    @SerializedName("token")
    var token: String = ""

    @SerializedName("error")
    var error: String = ""
}