package uagrm.soe.awesomelogin.controller

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity
import uagrm.soe.awesomelogin.utils.security.BiometricCallback
import uagrm.soe.awesomelogin.utils.security.BiometricManager
import java.util.regex.Pattern

class LoginActivity : AwesomeCompactActivity() , BiometricCallback{

    lateinit var userText: EditText
    lateinit var passText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //android:maxLength="10"
        userText = findViewById(R.id.userTxt) as EditText
        passText = findViewById(R.id.passTxt) as EditText

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
        val inputUser = userText?.text.toString().trim()
        val inputPass = passText?.text.toString().trim()

        if (inputUser.isNullOrBlank() || inputPass.isNullOrBlank()) {
            //Toast.makeText(this@LoginActivity, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            userText.setError("Todos los campos son obligatorios")
        }else{
            if (inputPass.length <= 8){
                Toast.makeText(this@LoginActivity, "Son 8 caracteres minimo", Toast.LENGTH_SHORT).show()
            }else{
                var valid = true
                // Password should contain at least one number
                var exp = ".*[0-9].*"
                var pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE)
                var matcher = pattern.matcher(inputPass)
                if (!matcher.matches()) {
                    valid = false
                }

                // Password should contain at least one capital letter
                exp = ".*[A-Z].*"
                pattern = Pattern.compile(exp)
                matcher = pattern.matcher(inputPass)
                if (!matcher.matches()) {
                    valid = false
                }

                // Password should contain at least one small letter
                exp = ".*[a-z].*"
                pattern = Pattern.compile(exp)
                matcher = pattern.matcher(inputPass)
                if (!matcher.matches()) {
                    valid = false
                }

                // Password should contain at least one special character
                // Allowed special characters : "~!@#$%^&*()-_=+|/,."';:{}[]<>?"
                exp = ".*[~!@#\$%\\^&*()\\-_=+\\|\\[{\\]};:'\",<.>/?].*"
                pattern = Pattern.compile(exp)
                matcher = pattern.matcher(inputPass)
                if (!matcher.matches()) {
                    valid = false
                }

                if (valid){
                    Toast.makeText(this@LoginActivity, "ok", Toast.LENGTH_SHORT).show()
                }else{
                    // Default validation messages
                    val PASSWORD_POLICY = """Password should be minimum 8 characters long,
            |should contain at least one capital letter,
            |at least one small letter,
            |at least one number and
            |at least one special character among ~!@#$%^&*()-_=+|[]{};:'\",<.>/?""".trimMargin()
                    Toast.makeText(this@LoginActivity, PASSWORD_POLICY, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


    fun onClickLoginWithBiometric(view: View){

        val intent=Intent(this,ViewAllDataActivity::class.java)
        startActivity(intent)
        /*
        BiometricManager.BiometricBuilder(MainActivity@this)
                        .setTitle(getString(R.string.biometric_title))
                        .setSubtitle(getString(R.string.biometric_subtitle))
                        .setDescription(getString(R.string.biometric_description))
                        .setNegativeButtonText(getString(R.string.biometric_negative_button_text))
                        .build()
                        .authenticate(MainActivity@this)
                        */
    }




    override fun onSdkVersionNotSupported() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_error_sdk_not_supported), Toast.LENGTH_LONG).show();
    }


    override fun onBiometricAuthenticationNotSupported() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_error_hardware_not_supported), Toast.LENGTH_LONG).show();
    }

    override fun onBiometricAuthenticationNotAvailable() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_error_fingerprint_not_available), Toast.LENGTH_LONG).show();
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_error_permission_not_granted), Toast.LENGTH_LONG).show();
    }

    override fun onBiometricAuthenticationInternalError(error: String) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationFailed() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_failure), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationCancelled() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_cancelled), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationSuccessful() {
        Toast.makeText(getApplicationContext(), getString(R.string.biometric_success), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationHelp(helpCode: Int,  helpString: CharSequence) {
        Toast.makeText(getApplicationContext(), helpString, Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
        Toast.makeText(getApplicationContext(), errString, Toast.LENGTH_LONG).show();
    }
}