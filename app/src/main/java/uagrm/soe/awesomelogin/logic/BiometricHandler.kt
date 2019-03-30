package uagrm.soe.awesomelogin.logic

import android.content.Context
import android.widget.Toast
import dagger.Module
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.utils.security.BiometricCallback

@Module
class BiometricHandler(var context: Context) : BiometricCallback {

    override fun onSdkVersionNotSupported() {
        Toast.makeText(context, context.getString(R.string.biometric_error_sdk_not_supported), Toast.LENGTH_LONG).show();
    }

    override fun onBiometricAuthenticationNotSupported() {
        Toast.makeText(context, context.getString(R.string.biometric_error_hardware_not_supported), Toast.LENGTH_LONG).show();
    }

    override fun onBiometricAuthenticationNotAvailable() {
        Toast.makeText(context, context.getString(R.string.biometric_error_fingerprint_not_available), Toast.LENGTH_LONG).show();
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        Toast.makeText(context, context.getString(R.string.biometric_error_permission_not_granted), Toast.LENGTH_LONG).show();
    }

    override fun onBiometricAuthenticationInternalError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationFailed() {
        Toast.makeText(context, context.getString(R.string.biometric_failure), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationCancelled() {
        Toast.makeText(context, context.getString(R.string.biometric_cancelled), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationSuccessful() {
        Toast.makeText(context, context.getString(R.string.biometric_success), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationHelp(helpCode: Int,  helpString: CharSequence) {
        Toast.makeText(context, helpString, Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
        Toast.makeText(context, errString, Toast.LENGTH_LONG).show();
    }
}