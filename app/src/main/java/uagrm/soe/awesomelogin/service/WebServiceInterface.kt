package integgre.ma_volvo.api.service


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import uagrm.soe.awesomelogin.domain.AuthSettings
import uagrm.soe.awesomelogin.domain.ResponseFirstLogin
import uagrm.soe.awesomelogin.domain.ResponseLogin

interface WebServiceInterface {

    @POST("login")
    fun consumePostLoginUserWithService(@Query("username") userName : String,
                                        @Query("password") password : String): Call<ResponseLogin>


    @POST("user/update/password")
    fun consumePostChangePasswordService(@Query("username") userName : String,
                                        @Query("old_password") oldPassword : String,
                                        @Query("new_password") newPassword : String): Call<ResponseFirstLogin>

    @POST("auth_settings/get")
    fun consumePostGetAllParameters(@Query("token") token : String): Call<AuthSettings>

}