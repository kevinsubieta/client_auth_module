package integgre.ma_volvo.api.service


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import uagrm.soe.awesomelogin.domain.ResponseLogin

interface WebServiceInterface {

    @POST("login")
    fun consumePostLoginUserWithService(@Query("username") userName : String,
                                        @Query("password") password : String): Call<ResponseLogin>

}