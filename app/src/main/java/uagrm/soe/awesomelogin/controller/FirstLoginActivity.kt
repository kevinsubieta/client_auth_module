package uagrm.soe.awesomelogin.controller

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.view.View
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity
import uagrm.soe.awesomelogin.listeners.ControllerListener
import uagrm.soe.awesomelogin.logic.ChangePassManager
import uagrm.soe.awesomelogin.logic.SecurityManager
import javax.inject.Inject

class FirstLoginActivity : AwesomeCompactActivity(), ControllerListener {


    @BindView(R.id.tiOldPassword)
    lateinit var tiOldPassword: TextInputEditText
    @BindView(R.id.tiCurrentPassword)
    lateinit var tiCurrentPassword: TextInputEditText
    @BindView(R.id.tiConfirmPassword)
    lateinit var tiConfirmPassword: TextInputEditText
    @Inject
    lateinit var changePassManager: ChangePassManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_login)
        ButterKnife.bind(this)
        initComponentes()
        changePassManager = ChangePassManager()
    }


    fun initComponentes() {
        this.tiOldPassword = findViewById(R.id.tiOldPassword)
        this.tiCurrentPassword = findViewById(R.id.tiCurrentPassword)
        this.tiConfirmPassword = findViewById(R.id.tiConfirmPassword)
    }

    fun onClickChangeCurrentPassword(view: View) {
        if (changePassManager.validateUserTextsIsEmpty(this.tiOldPassword, this.tiCurrentPassword,
                        this.tiConfirmPassword)) {
            var userNameText = this.tiOldPassword.text.toString()
            var oldPassText = this.tiCurrentPassword.text.toString()
            var newPassText = this.tiCurrentPassword.text.toString()
            changePassManager.changeUserPassword(userNameText, oldPassText, newPassText, this)
        }
    }

    override fun notifyController(anyObject: Any?, fromClass: Any) {
        if (anyObject != null) {
            Toast.makeText(this, resources.getString(R.string.first_login_message_success),
                    Toast.LENGTH_SHORT).show()
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            this.finish()
        } else {
            Toast.makeText(this, resources.getString(R.string.first_login_message_error),
                    Toast.LENGTH_SHORT).show()
        }
    }


}