package uagrm.soe.awesomelogin.controller

import android.os.Build
import android.os.Bundle
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat
import android.view.View
import android.widget.Toast
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity
import uagrm.soe.awesomelogin.security.BiometricCallback
import uagrm.soe.awesomelogin.security.BiometricManager

class LoginActivity : AwesomeCompactActivity() , BiometricCallback{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun onClickLoginUser(view: View){

    }

    fun onClickLoginWithBiometric(view: View){
        BiometricManager.BiometricBuilder(MainActivity@this)
                        .setTitle(getString(R.string.biometric_title))
                        .setSubtitle(getString(R.string.biometric_subtitle))
                        .setDescription(getString(R.string.biometric_description))
                        .setNegativeButtonText(getString(R.string.biometric_negative_button_text))
                        .build()
                        .authenticate(MainActivity@this)
    }




    override fun onSdkVersionNotSupported() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_error_sdk_not_supported), Toast.LENGTH_LONG).show();
    }


    override fun onBiometricAuthenticationNotSupported() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_error_hardware_not_supported), Toast.LENGTH_LONG).show();
    }

    override fun onBiometricAuthenticationNotAvailable() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_error_fingerprint_not_available), Toast.LENGTH_LONG).show();
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_error_permission_not_granted), Toast.LENGTH_LONG).show();
    }

    override fun onBiometricAuthenticationInternalError(error: String) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationFailed() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_failure), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationCancelled() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_cancelled), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationSuccessful() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_success), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationHelp(helpCode: Int,  helpString: CharSequence) {
        Toast.makeText(getApplicationContext(), helpString, Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
        Toast.makeText(getApplicationContext(), errString, Toast.LENGTH_LONG).show();
    }
}