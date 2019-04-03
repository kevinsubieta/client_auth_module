package uagrm.soe.awesomelogin.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class AuthSettings : Serializable {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("failed_login_maximum_number")
    var failedLoginMaximumNumber: Int = 0

    @SerializedName("password_expiration_epoch")
    var passwordExpirationTimeDays: Int = 0

    @SerializedName("session_expiration_epoch")
    var sessionExpirationTimeMin: Int = 0

    @SerializedName("simultaneous_sessions_nro_allowed")
    var simultaneousSessionsNroAllowed: Int = 0

    @SerializedName("min_special_letters_number")
    var minSpecialLettersNumber: Int = 0

    @SerializedName("min_uppercase_letters_number")
    var minUpperCaseLettersNumber: Int = 0

    @SerializedName("min_password_len")
    var minPasswordLen: Int = 0

}
