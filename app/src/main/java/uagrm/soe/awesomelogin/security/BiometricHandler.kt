package uagrm.soe.awesomelogin.security

//import uagrm.soe.awesomelogin.security.biometric.BiometricCallback
import uagrm.soe.awesomelogin.utils.security.BiometricCallback

class BiometricManager : BiometricCallback {


    override fun onSdkVersionNotSupported() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBiometricAuthenticationNotSupported() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBiometricAuthenticationNotAvailable() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBiometricAuthenticationInternalError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAuthenticationFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAuthenticationCancelled() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAuthenticationSuccessful() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}