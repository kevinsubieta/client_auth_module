package uagrm.soe.awesomelogin.security

import android.os.Build
import android.support.annotation.RequiresApi
import android.hardware.biometrics.BiometricPrompt


/**
 * Created by Kevin Subieta on 27/03/19.
 */
@RequiresApi(api = Build.VERSION_CODES.P)
class BiometricCallbackV28 : BiometricPrompt.AuthenticationCallback {

    private var biometricCallback: BiometricCallback? = null


    constructor(biometricCallback: BiometricCallback) {
        this.biometricCallback = biometricCallback
    }


    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
        super.onAuthenticationSucceeded(result)
        biometricCallback!!.onAuthenticationSuccessful()
    }


    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence) {
        super.onAuthenticationHelp(helpCode, helpString)
        biometricCallback!!.onAuthenticationHelp(helpCode, helpString)
    }


    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
        super.onAuthenticationError(errorCode, errString)
        biometricCallback!!.onAuthenticationError(errorCode, errString)
    }


    override fun onAuthenticationFailed() {
        super.onAuthenticationFailed()
        biometricCallback!!.onAuthenticationFailed()
    }
}