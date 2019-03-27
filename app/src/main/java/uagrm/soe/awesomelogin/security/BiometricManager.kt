package uagrm.soe.awesomelogin.security

import android.app.Activity
import android.content.DialogInterface
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.support.annotation.RequiresApi
import uagrm.soe.awesomelogin.utils.MainThreadExecutor
import java.util.concurrent.Executor

abstract class BiometricManager {


    @RequiresApi(28)
    fun createBiometricInstance(activity: Activity): BiometricPrompt {
        var executor : Executor
            executor = activity.mainExecutor
            val cancelListener = DialogInterface.OnClickListener { _, _ -> }
            val biometricPrompt = BiometricPrompt.Builder(activity)
                    .setTitle("Title")
                    .setSubtitle("Subtitle")
                    .setDescription("Description")
                    .setNegativeButton("Cancel", executor, cancelListener)
                    .build()

        return biometricPrompt
    }

}

