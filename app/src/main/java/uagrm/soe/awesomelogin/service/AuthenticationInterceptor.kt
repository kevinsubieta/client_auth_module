package integgre.ma_volvo.api.service

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(token : String) : Interceptor{
    var authToken : String

    init {
        this.authToken = token
    }

    override fun intercept(chain: Interceptor.Chain?): Response {
        val original = chain!!.request()

        val builder = original.newBuilder()
                .header("Authorization", authToken)

        val request = builder.build()
        return chain.proceed(request)
    }

}