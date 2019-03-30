package uagrm.soe.awesomelogin.controller

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import butterknife.BindView
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity
import uagrm.soe.awesomelogin.logic.BiometricHandler
import uagrm.soe.awesomelogin.logic.SecurityManager
import uagrm.soe.awesomelogin.utils.security.BiometricManager
import javax.inject.Inject

class LoginActivity : AwesomeCompactActivity() {

    @BindView(R.id.userTxt) lateinit var userText: EditText
    @BindView(R.id.passTxt) lateinit var passText: EditText
    @Inject lateinit var biometricHanlder : BiometricHandler
    @Inject lateinit var securityManager: SecurityManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        biometricHanlder = BiometricHandler(this)

        passText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                val contador : TextView = findViewById(R.id.texto_contador) as TextView
                val tamanoString : String = s.length.toString()
                contador.setText(tamanoString)
            }
        });
    }



    fun onClickLoginUser(view: View) {


    }


    fun validaUserLogin(){
        if (securityManager.validateUserTextsIsEmpty(this.userText, this.passText)){
           if (securityManager.validateIfIsFirstStart()){

           }else{
               /** Go To RestoreActivity **/
           }
        }

    }


    fun onClickLoginWithBiometric(view: View){
        BiometricManager.BiometricBuilder(MainActivity@this)
                        .setTitle(getString(R.string.biometric_title))
                        .setSubtitle(getString(R.string.biometric_subtitle))
                        .setDescription(getString(R.string.biometric_description))
                        .setNegativeButtonText(getString(R.string.biometric_negative_button_text))
                        .build()
                        .authenticate(biometricHanlder)
    }




}