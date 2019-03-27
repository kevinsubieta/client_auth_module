package uagrm.soe.awesomelogin.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User : Serializable {

    @SerializedName("id")
    var id: Int? = 0

    @SerializedName("id_number")
    var idNumber: String? = ""

    @SerializedName("name")
    var name: Int? = 0

    @SerializedName("last_name")
    var lastName: Int? = 0

    @SerializedName("email_address")
    var emailAddress: Int? = 0

    @SerializedName("birthday")
    var birthday: Long? = 0

    @SerializedName("username")
    var username: Int? = 0

    @SerializedName("password")
    var password: Int? = 0

    @SerializedName("failed_login_number")
    var failedLoginNumber: Int? = 0

    @SerializedName("creation_datetime")
    var creationDatetime: Long? = 0

    @SerializedName("update_datetime")
    var updateDatetime: Long? = 0

    @SerializedName("password_expiration_datetime")
    var passwordExpirationDatetime: Long? = 0

    @SerializedName("session_expiration_datetime")
    var sessionExpirationDatetime: Long? = 0

    @SerializedName("last_password_change_datetime")
    var lastPasswordChangeDatetime: Long? = 0

    @SerializedName("last_logout_datetime")
    var lastLogoutDatetime: Long? = 0

    @SerializedName("password_expire")
    var passwordExpire: Boolean? = true

    @SerializedName("is_admin")
    var isAdmin: Boolean? = true

    @SerializedName("is_enabled")
    var isEnabled: Boolean? = true
}

