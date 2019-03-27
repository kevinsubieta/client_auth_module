package integgre.ma_volvo.api.service

import integgre.ma_volvo.constanst.Constants
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import okhttp3.Credentials
import okhttp3.Interceptor


class WebService {
    private object Holder {
        val webInstance = getInstance()
    }

    companion object {
        val CONNECT_TIME_OUT = 90
        val CONNECT_WRITE_OUT = 90
        val TIME_OUT = 90

        val USER_AUTH = "Vk7iBxhuaYZSCncLIbZazA==Cz8hZS/sv70ZgG7G01DhWQ=="
        val TOKEN_AUTH = "2a10YEm0utdWochklUhh8zZ78.SghQhV48VDem1voeO9yDihEHI2vA1US"

        fun getInstance(): WebServiceInterface? {

            var stringToken = Credentials.basic(USER_AUTH, TOKEN_AUTH)

            var interceptor = AuthenticationInterceptor(stringToken)

            val gson = GsonBuilder()
                    .setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                    .create()

            if (Holder.webInstance == null) {

                val okHttpClient = OkHttpClient.Builder().readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                        .connectTimeout(CONNECT_TIME_OUT.toLong(), TimeUnit.SECONDS)
                        .writeTimeout(CONNECT_WRITE_OUT.toLong(), TimeUnit.SECONDS)
                        .addInterceptor(interceptor)
                        .build()


                val retrofit = Retrofit.Builder()
                        .baseUrl(Constants.WEB_URI)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()

                return retrofit.create(WebServiceInterface::class.java)
            }
            return Holder.webInstance
        }
    }


    @Throws(Throwable::class)
    private fun prepareRequest(call: Call<*>): Response<*> {
        call.request()
        return call.execute()
    }


    @Throws(Throwable::class)
    fun consumeGetLoginUserWithService(userName: String, password: String) {

    }




}