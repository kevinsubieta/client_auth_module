package uagrm.soe.awesomelogin.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Session : Serializable{

    @SerializedName("id")
    var id: Int? = 0

    @SerializedName("token")
    var token: String? = ""

    @SerializedName("user_id")
    var userId: Int? = 0

}