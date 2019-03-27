package uagrm.soe.awesomelogin.controller

import android.os.Build
import android.os.Bundle
import android.view.View
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity
import uagrm.soe.awesomelogin.security.BiometricManager

class LoginActivity : AwesomeCompactActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun onClickLoginUser(view: View){

    }

    fun onClickLoginWithBiometric(view: View){
        var biometricManager = BiometricManager()
        if (Build.VERSION.SDK_INT >= 28) {
            biometricManager.createBiometricInstance(this)
        }
    }
}