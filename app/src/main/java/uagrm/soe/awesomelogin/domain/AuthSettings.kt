package uagrm.soe.awesomelogin.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class AuthSettings : Serializable {

    @SerializedName("id")
    var id: Int? = 0

    @SerializedName("failed_login_maximum_number")
    var failedLoginMaximumNumber: Int? = 0

    @SerializedName("password_expiration_time_days")
    var passwordExpirationTimeDays: Int? = 0

    @SerializedName("session_expiration_time_min")
    var sessionExpirationTimeMin: Int? = 0

    @SerializedName("simultaneous_sessions_nro_allowed")
    var simultaneousSessionsNroAllowed: Int? = 0

}