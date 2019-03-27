package uagrm.soe.awesomelogin.controller

import android.os.Bundle
import android.view.View
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity

class LoginActivity : AwesomeCompactActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun onClickLoginUser(view: View){

    }

    fun onClickLoginWithBiometric(view: View){

    }
}