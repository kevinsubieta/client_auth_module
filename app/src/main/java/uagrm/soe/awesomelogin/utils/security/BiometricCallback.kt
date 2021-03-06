package uagrm.soe.awesomelogin.utils.security
/**
 * Created by Kevin Subieta on 27/03/19.
 */
interface BiometricCallback {

    fun onSdkVersionNotSupported()

    fun onBiometricAuthenticationNotSupported()

    fun onBiometricAuthenticationNotAvailable()

    fun onBiometricAuthenticationPermissionNotGranted()

    fun onBiometricAuthenticationInternalError(error: String)


    fun onAuthenticationFailed()

    fun onAuthenticationCancelled()

    fun onAuthenticationSuccessful()

    fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence)

    fun onAuthenticationError(errorCode: Int, errString: CharSequence)

}