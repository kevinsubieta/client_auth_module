package uagrm.soe.awesomelogin.security

import android.Manifest
import android.content.pm.PackageManager
import android.Manifest.permission
import android.Manifest.permission.USE_FINGERPRINT
import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.app.ActivityCompat
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat
import android.os.Build


@SuppressLint("MissingPermission")
class BiometricUtils {

    companion object {
        fun isBiometricPromptEnabled(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
        }


        /*
         * Condition I: Check if the android version in device is greater than
         * Marshmallow, since fingerprint authentication is only supported
         * from Android 6.0.
         * Note: If your project's minSdkversion is 23 or higher,
         * then you won't need to perform this check.
         *
         * */
        fun isSdkVersionSupported(): Boolean {
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
        }


        /*
         * Condition II: Check if the device has fingerprint sensors.
         * Note: If you marked android.hardware.fingerprint as something that
         * your app requires (android:required="true"), then you don't need
         * to perform this check.
         *
         * */
        fun isHardwareSupported(context: Context): Boolean {
            val fingerprintManager = FingerprintManagerCompat.from(context)
            return fingerprintManager.isHardwareDetected
        }


        /*
         * Condition III: Fingerprint authentication can be matched with a
         * registered fingerprint of the user. So we need to perform this check
         * in order to enable fingerprint authentication
         *
         * */
        fun isFingerprintAvailable(context: Context): Boolean {
            val fingerprintManager = FingerprintManagerCompat.from(context)
            return fingerprintManager.hasEnrolledFingerprints()
        }


        /*
         * Condition IV: Check if the permission has been added to
         * the app. This permission will be granted as soon as the user
         * installs the app on their device.
         *
         * */
        fun isPermissionGranted(context: Context): Boolean {
            return ActivityCompat.checkSelfPermission(context, Manifest.permission.USE_FINGERPRINT) == PackageManager.PERMISSION_GRANTED
        }

    }
}