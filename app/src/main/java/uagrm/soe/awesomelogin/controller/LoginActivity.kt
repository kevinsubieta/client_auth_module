package uagrm.soe.awesomelogin.controller

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.view.View
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import integgre.ma_volvo.constanst.ConstanstFiles
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity
import uagrm.soe.awesomelogin.domain.ResponseLogin
import uagrm.soe.awesomelogin.listeners.ControllerListener
import uagrm.soe.awesomelogin.logic.managers.BiometricHandler
import uagrm.soe.awesomelogin.logic.managers.SecurityManager
import uagrm.soe.awesomelogin.utils.security.BiometricManager
import javax.inject.Inject

class LoginActivity : AwesomeCompactActivity(), ControllerListener {


    @BindView(R.id.userTxt)
    lateinit var userText: EditText
    @BindView(R.id.passTxt)
    lateinit var passText: TextInputEditText
    @Inject
    lateinit var biometricHanlder: BiometricHandler
    @Inject
    lateinit var securityManager: SecurityManager
    lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        securityManager = SecurityManager()
        biometricHanlder = BiometricHandler(this)
        ButterKnife.bind(this)
        initProgressDialog()
        //validateIfExistAnySession()
    }


    fun onClickLoginUser(view: View) {
        userText = findViewById(R.id.userTxt)
        passText = findViewById(R.id.passTxt)

        var userName = userText.text.toString()
        var userPassword = passText.text.toString()
        this.securityManager.authenticateUserWithService(userName, userPassword, this)
        progressDialog.show()
    }


    fun initProgressDialog() {
        this.progressDialog = ProgressDialog(this)
        this.progressDialog.setMessage(resources.getString(R.string.dialog_logging_waiting))
        this.progressDialog.setCancelable(false)
    }


    fun onClickLoginWithBiometric(view: View) {

        val intent = Intent(this, ViewAllDataActivity::class.java)
        startActivity(intent)
        /*
        BiometricManager.BiometricBuilder(MainActivity@ this)
                .setTitle(getString(R.string.biometric_title))
                .setSubtitle(getString(R.string.biometric_subtitle))
                .setDescription(getString(R.string.biometric_description))
                .setNegativeButtonText(getString(R.string.biometric_negative_button_text))
                .build()
                .authenticate(biometricHanlder)
        */
    }


    fun validateIfExistAnySession() {
        var token = securityManager.getCurrentSession(this)
        if (token.isNotEmpty()) {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    override fun notifyController(anyObject: Any?, fromClass: Any) {
        progressDialog.dismiss()
        if (anyObject != null) {
            var responseLogin: ResponseLogin = anyObject as ResponseLogin
            if (securityManager.validateIfUserAuthIsOk(responseLogin)) {
                if (securityManager.validateIfUserIsAvaliable(responseLogin)) {
                    if (securityManager.validateIfIsFirstStart(responseLogin)) {
                        var intent = Intent(this, FirstLoginActivity::class.java)
                        intent.putExtra(ConstanstFiles.KEY_FIRST_LOGIN_USER, userText.text.toString())
                        startActivity(intent)
                    } else {
                        if (securityManager.validateIfExistAnyError(responseLogin)) {
                            securityManager.saveUserToken(this, responseLogin)
                            var intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, responseLogin.error!!, Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, resources.getString
                    (R.string.login_message_error_user_not_Available), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, responseLogin.error!!, Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }


}