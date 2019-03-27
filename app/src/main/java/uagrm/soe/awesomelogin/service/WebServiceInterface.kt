package integgre.ma_volvo.api.service

import integgre.ma_volvo.persistence.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Streaming

interface WebServiceInterface {

    @GET("usuario/Login/{username}")
    fun consumeGetLoginUserWithService(@Path("username") username: String,
                                       @Header("password") password: String): Call<Users>

    @POST("usuario/RestablecerContrasena")
    fun consumePostRestorePasswordWithService(@Body user: Users): Call<stcResult>


    @POST("usuario/RecuperarContrasena")
    fun consumePostRecoveryPasswordWithService(@Body user: Users): Call<stcResult>


    @GET("usuario/getPuntos/{ciClient}")
    fun consumeGetLoadListAccountPoints(@Path("ciClient") ciClient: String): Call<Clientes>


    @GET("Contenido/getContenido/{userId}")
    fun consumeGetLoadNews(@Path("userId") userId: Int): Call<List<Contenido>>


    @GET("Premio/getPremios")
    fun consumeGetLoadAwards(): Call<List<Productos>>


    @GET("Sucursal/getSucursales")
    fun consumeGetLoadBranchs(): Call<List<Sucursales>>


    @GET("Contenido/getPromociones")
    fun consumeGetLoadPromotions(): Call<List<Promociones>>


    @GET("Cuenta/getPartidasPendientes/{ciClient}")
    fun consumeGetLoadListPendingCourt(@Path("ciClient") ciClient: String): Call<List<Transacciones>>


    @GET("Cuenta/getEstadoCuenta/{ciClient}")
    fun consumeGetLoadListAccountStatus(@Path("ciClient") ciClient: String): Call<Lineas>


    @POST("Usuario/SetIdentificadores")
    fun consumePostSetIdentificator(@Body user: Users): Call<Users>


    @GET("Premio/getComprobanteCliente/{ciClient}")
    fun consumeGetLoadMyAwards(@Path("ciClient") ciClient: String): Call<List<SP_GetComprobantes_Result>>


    @POST("Usuario/NuevaContrasena")
    fun consumePostSetNewPasswordWithService(@Body user: Users): Call<stcResult>


    @POST("Usuario/GuardarImagen")
    fun consumePostSaveProfilePictureWithService(@Body cliente: Clientes): Call<Clientes>


    @POST("Consulta/GuardarConsulta")
    fun consumePostSaveQueryUserWithService(@Body query: Consultas): Call<stcResult>


    @POST("Contenido/NuevoFavorito")
    fun consumePostSaveNewFavorite(@Body promo: PromocionXUsuarios): Call<stcResult>


    @POST("Bitacora/GuardarBitacora")
    fun consumePostSaveBinnacle(@Body lstBinnacle: ArrayList<Bitacora>): Call<stcResult>


    @GET("Consulta/getCiudades")
    fun consumeGetCities(): Call<List<stcCombo>>


    @GET("Consulta/getTiposConsulta")
    fun consumeGetQueryTypes(): Call<List<stcCombo>>


    @GET("Recurso/GetParametrosApp")
    fun consumeGetParametersApp(): Call<List<Parametros>>


    @POST("Canje/NuevoCanje")
    fun consumePostSaveNewTrade(@Body baucher: Baucher): Call<Baucher>


    @GET("Canje/getReporteURL/{comprobanteId}")
    fun consumeGetReportUrl(@Path("comprobanteId") comprobanteId: String): Call<String>


    @GET("Usuario/getUsuario/{userId}")
    fun consumeGetUserByUserId(@Path("userId") userId: String): Call<Users>

    @GET("Notificacion/GetNotificacionesFcm/{UserId}/{PageNumber}")
    fun consumeGetNotificationsByUserIdAndPageNumber(@Path("UserId") userId: Long, @Path("PageNumber") pageNumber: Int): Call<List<NotificationFcm>>
}