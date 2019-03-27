package integgre.ma_volvo.api.service

import integgre.ma_volvo.constanst.Constants
import integgre.ma_volvo.persistence.*
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
    fun consumeGetLoginUserWithService(userName: String, password: String): Users? {
        var call = WebService.Holder.webInstance!!.consumeGetLoginUserWithService(userName, password)
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as Users
        } else {
            return Users()
        }
    }

    @Throws(Throwable::class)
    fun consumePostRestorePasswordWithService(user: Users): stcResult? {
        var call = WebService.Holder.webInstance!!.consumePostRestorePasswordWithService(user)
            var response = this.prepareRequest(call)
            var responseFromService = response.body()
            if (responseFromService != null) {
                return responseFromService as stcResult
            } else {
                return null
            }
    }

    @Throws(Throwable::class)
    fun consumePostRecoveryPasswordWithService(user: Users): stcResult? {
        var call = WebService.Holder.webInstance!!.consumePostRecoveryPasswordWithService(user)
        var response = this.prepareRequest(call)
        var responseFromService = response.body()
        if (responseFromService != null) {
            return responseFromService as stcResult
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumeGetLoadListAccountPoints(ciClient: String): Clientes? {
        var call = WebService.Holder.webInstance!!.consumeGetLoadListAccountPoints(ciClient)
        var response = this.prepareRequest(call)
        var responseFromService = response.body()
        if (responseFromService != null) {
            return responseFromService as Clientes
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumeGetLoadNews(userId: Int): List<Contenido>? {
        var call = WebService.Holder.webInstance!!.consumeGetLoadNews(userId)
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as List<Contenido>
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumeGetLoadAwards(): List<Productos>? {
        var call = WebService.Holder.webInstance!!.consumeGetLoadAwards()
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as List<Productos>
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumeGetLoadBranchs(): List<Sucursales>? {
        var call = WebService.Holder.webInstance!!.consumeGetLoadBranchs()
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as List<Sucursales>
        } else {
            return null
        }
    }


    @Throws(Throwable::class)
    fun consumeGetLoadPromotions(): List<Promociones>? {
        var call = WebService.Holder.webInstance!!.consumeGetLoadPromotions()
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as List<Promociones>
        } else {
            return null
        }
    }



    @Throws(Throwable::class)
    fun consumeGetLoadListPendingCourt(ciClient: String): List<Transacciones>? {
        var call = WebService.Holder.webInstance!!.consumeGetLoadListPendingCourt(ciClient)
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as List<Transacciones>
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumeGetLoadListAccountStatus(ciClient: String): Lineas? {
        var call = WebService.Holder.webInstance!!.consumeGetLoadListAccountStatus(ciClient)
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as Lineas
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumePostSetIdentificator(user: Users): Users? {
        var call = WebService.Holder.webInstance!!.consumePostSetIdentificator(user)
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as Users
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumeGetLoadMyAwards(ciClient: String): List<SP_GetComprobantes_Result>? {
        var call = WebService.Holder.webInstance!!.consumeGetLoadMyAwards(ciClient)
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as List<SP_GetComprobantes_Result>
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumePostSetNewPasswordWithService(user: Users): stcResult? {
        var call = WebService.Holder.webInstance!!.consumePostSetNewPasswordWithService(user)
        var response = this.prepareRequest(call)
        var responseFromService = response.body()
        if (responseFromService != null) {
            return responseFromService as stcResult
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumePostSaveProfilePictureWithService(cliente: Clientes): Clientes? {
        var call = WebService.Holder.webInstance!!.consumePostSaveProfilePictureWithService(cliente)
        var response = this.prepareRequest(call)
        var responseFromService = response.body()
        if (responseFromService != null) {
            return responseFromService as Clientes
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumePostSaveQueryUserWithService(query: Consultas): stcResult? {
        var call = WebService.Holder.webInstance!!.consumePostSaveQueryUserWithService(query)
        var response = this.prepareRequest(call)
        var responseFromService = response.body()
        if (responseFromService != null) {
            return responseFromService as stcResult
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumePostSaveNewFavorite(promo: PromocionXUsuarios): stcResult? {
        var call = WebService.Holder.webInstance!!.consumePostSaveNewFavorite(promo)
        var response = this.prepareRequest(call)
        var responseFromService = response.body()
        if (responseFromService != null) {
            return responseFromService as stcResult
        } else {
            return null
        }
    }


    @Throws(Throwable::class)
    fun consumePostSaveBinnacle(lstBittacle : ArrayList<Bitacora>): stcResult? {
        var call = WebService.Holder.webInstance!!.consumePostSaveBinnacle(lstBittacle)
        var response = this.prepareRequest(call)
        var responseFromService = response.body()
        if (responseFromService != null) {
            return responseFromService as stcResult
        } else {
            return null
        }
    }


    @Throws(Throwable::class)
    fun consumeGetCities(): List<stcCombo>? {
        var call = WebService.Holder.webInstance!!.consumeGetCities()
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as List<stcCombo>
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumeGetQueryTypes(): List<stcCombo>? {
        var call = WebService.Holder.webInstance!!.consumeGetQueryTypes()
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as List<stcCombo>
        } else {
            return null
        }
    }



    fun consumeGetParametersApp() : List<Parametros>? ?{
        var call = WebService.Holder.webInstance!!.consumeGetParametersApp()
        var response = this.prepareRequest(call)
        var userFromService = response.body()
        if (userFromService != null) {
            return userFromService as List<Parametros>?
        } else {
            return null
        }
    }


    @Throws(Throwable::class)
    fun consumePostSaveNewTrade(baucher: Baucher): Baucher? {
        var call = WebService.Holder.webInstance!!.consumePostSaveNewTrade(baucher)
        var response = this.prepareRequest(call)
        var responseFromService = response.body()
        if (responseFromService != null) {
            return responseFromService as Baucher
        } else {
            return null
        }
    }


    @Throws(Throwable::class)
    fun consumeGetReportUrl(comprobanteId: String): String? {
        var call = WebService.Holder.webInstance!!.consumeGetReportUrl(comprobanteId)
        var response = this.prepareRequest(call)
        var responseFromService = response.body()
        if (responseFromService != null) {
            return responseFromService as String
        } else {
            return null
        }
    }

    @Throws(Throwable::class)
    fun consumeGetUserByUserId(userId: String): Users? {
        var call = WebService.Holder.webInstance!!.consumeGetUserByUserId(userId)
        var response = this.prepareRequest(call)
        var responseFromService = response.body()
        if (responseFromService != null) {
            return responseFromService as Users
        } else {
            return null
        }
    }


    @Throws(Throwable::class)
    fun consumeGetLastNotification(userId: Long, pageNumber: Int): List<NotificationFcm>? {
        var call = WebService.Holder.webInstance!!.consumeGetNotificationsByUserIdAndPageNumber(userId, pageNumber)
        var response = this.prepareRequest(call)
        var notificationsFromService = response.body()
        if (notificationsFromService != null) {
            return notificationsFromService as List<NotificationFcm>
        } else {
            return null
        }
    }







}