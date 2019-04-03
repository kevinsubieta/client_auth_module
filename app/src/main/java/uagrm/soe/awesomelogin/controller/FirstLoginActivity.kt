package uagrm.soe.awesomelogin.controller

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.view.View
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import integgre.ma_volvo.constanst.ConstanstFiles
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity
import uagrm.soe.awesomelogin.domain.ResponseFirstLogin
import uagrm.soe.awesomelogin.listeners.ControllerListener
import uagrm.soe.awesomelogin.logic.managers.ChangePassManager
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
    lateinit var userName: String
    lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_login)
        ButterKnife.bind(this)
        initComponentes()
        initProgressDialog()
        this.userName = intent.getStringExtra(ConstanstFiles.KEY_FIRST_LOGIN_USER)
        changePassManager = ChangePassManager()
    }


    fun initComponentes() {
        this.tiOldPassword = findViewById(R.id.tiOldPassword)
        this.tiCurrentPassword = findViewById(R.id.tiCurrentPassword)
        this.tiConfirmPassword = findViewById(R.id.tiConfirmPassword)
    }

    fun initProgressDialog() {
        this.progressDialog = ProgressDialog(this)
        this.progressDialog.setMessage(resources.getString(R.string.dialog_change_pass_waiting))
        this.progressDialog.setCancelable(false)
    }

    fun onClickChangeCurrentPassword(view: View) {
        if (changePassManager.validateUserTextsIsEmpty(this.tiOldPassword, this.tiCurrentPassword,
                        this.tiConfirmPassword)) {
            if (changePassManager.validateIfPasswordsAreEquals(this,
                            this.tiCurrentPassword, this.tiConfirmPassword)) {
                var userNameText = this.tiOldPassword.text.toString()
                var oldPassText = this.tiOldPassword.text.toString()
                var newPassText = this.tiCurrentPassword.text.toString()
                changePassManager.changeUserPassword(this.userName, oldPassText, newPassText, this)
                progressDialog.show()
            }
        }
    }

    override fun notifyController(anyObject: Any?, fromClass: Any) {
        progressDialog.dismiss()
        if (anyObject != null) {
            var responseFromFirstLogin: ResponseFirstLogin = anyObject as ResponseFirstLogin
            if (responseFromFirstLogin.error!!.isEmpty()) {
                Toast.makeText(this, resources.getString(R.string.first_login_message_success),
                        Toast.LENGTH_SHORT).show()
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                this.finish()
            } else {
                Toast.makeText(this, responseFromFirstLogin.error!!,
                        Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, resources.getString(R.string.first_login_message_error),
                    Toast.LENGTH_SHORT).show()
        }
    }


}