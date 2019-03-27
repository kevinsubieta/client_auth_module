package uagrm.soe.awesomelogin.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class UserPassword : Serializable{

    @SerializedName("id")
    var id: Int? = 0

    @SerializedName("password")
    var password: String? = ""

    @SerializedName("user_id")
    var userId: Int? = 0

}