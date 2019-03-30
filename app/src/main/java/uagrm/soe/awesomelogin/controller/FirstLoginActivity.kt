package uagrm.soe.awesomelogin.controller

import android.os.Bundle
import android.view.View
import android.widget.EditText
import butterknife.BindView
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity

class FirstLoginActivity : AwesomeCompactActivity() {

    @BindView(R.id.tiOldPassword) lateinit var tiOldPassword: EditText
    @BindView(R.id.tiCurrentPassword) lateinit var tiCurrentPassword: EditText
    @BindView(R.id.tiConfirmPassword) lateinit var tiConfirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_login)
    }

    fun onClickChangeCurrentPassword(view: View){

    }



}