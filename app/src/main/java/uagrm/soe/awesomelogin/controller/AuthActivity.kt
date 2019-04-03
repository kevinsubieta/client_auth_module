package uagrm.soe.awesomelogin.controller

import android.app.ProgressDialog
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity
import uagrm.soe.awesomelogin.domain.AuthSettings
import uagrm.soe.awesomelogin.domain.ResponseFirstLogin
import uagrm.soe.awesomelogin.listeners.ControllerListener
import uagrm.soe.awesomelogin.logic.managers.AuthManager

class AuthActivity : AwesomeCompactActivity() {
    var list_of_items = arrayOf("Segundos", "Minutos", "Horas", "Días")

    lateinit var etNumMaxOfTries: EditText
    lateinit var etDaysExpPassword: EditText
    lateinit var etDaysExpSession: EditText
    lateinit var etMinNumOfSpecialChar: EditText
    lateinit var etMinNumOfUpperCase: EditText
    lateinit var etLengthPassword: EditText
    lateinit var spExpSessionUnitTime: Spinner
    lateinit var spDaysExpPassUnitTime: Spinner

    lateinit var progressDialog: ProgressDialog
    lateinit var currentAuthParametes: AuthSettings
    lateinit var srlPrincipal: SwipeRefreshLayout
    lateinit var fabSaveParams: FloatingActionButton
    lateinit var rlAuth: RelativeLayout

    var authManager: AuthManager = AuthManager()

    var selectedItemOnExpTime = 0
    var selectedItemOnSessionTime = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initComponentes()
        initSwipeRefreshLayout()
        initProgressDialog()
        initSpinners()
        loadParametersFromService()
    }

    fun initComponentes() {
        this.etNumMaxOfTries = findViewById(R.id.etNumMaxOfTries)
        this.etDaysExpPassword = findViewById(R.id.etDaysExpPassword)
        this.etDaysExpSession = findViewById(R.id.etDaysExpSession)
        this.etMinNumOfSpecialChar = findViewById(R.id.etMinNumOfSpecialChar)
        this.etMinNumOfUpperCase = findViewById(R.id.etMinNumOfUpperCase)
        this.etLengthPassword = findViewById(R.id.etLengthPassword)
        this.spExpSessionUnitTime = findViewById(R.id.spExpSessionUnitTime)
        this.spDaysExpPassUnitTime = findViewById(R.id.spDaysExpPassUnitTime)
        this.srlPrincipal = findViewById(R.id.srlPrincipal)
        this.fabSaveParams = findViewById(R.id.fabSaveParams)
        this.rlAuth = findViewById(R.id.rlAuth)
    }

    fun initSwipeRefreshLayout() {
        srlPrincipal!!.setColorSchemeColors(resources.getColor(R.color.colorPrimary))
        srlPrincipal!!.isEnabled = false
        srlPrincipal!!.isRefreshing = true

        srlPrincipal!!.setOnRefreshListener {
            this.loadParametersFromService()
        }
    }

    fun initProgressDialog() {
        this.progressDialog = ProgressDialog(this)
        this.progressDialog.setMessage(resources.getString(R.string.dialog_auth_downloading))
        this.progressDialog.setCancelable(false)
    }

    fun initSpinners() {
        val array_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)
        array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        this.spExpSessionUnitTime.adapter = array_adapter
        this.spDaysExpPassUnitTime.adapter = array_adapter

        this.spExpSessionUnitTime.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        selectedItemOnSessionTime = position
                    }
                }


        this.spDaysExpPassUnitTime.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        selectedItemOnExpTime = position
                    }
                }

        this.spExpSessionUnitTime.setSelection(1)
        this.spDaysExpPassUnitTime.setSelection(0)
    }


    fun loadParametersFromService() {
        var controllerListener = object : ControllerListener {
            override fun notifyController(anyObject: Any?, fromClass: Any) {
                srlPrincipal!!.isRefreshing = false
                srlPrincipal!!.isEnabled = true
                if (anyObject != null) {
                    var newParameteres: AuthSettings = anyObject as AuthSettings
                    updateAllComponents(newParameteres)
                    initSpinners()
                } else {
                    Toast.makeText(this@AuthActivity, resources.getString(R.string.auth_tittle_error),
                            Toast.LENGTH_SHORT).show()
                }
            }
        }
        authManager.getAuthParametersWithServiceByTokenId(this, controllerListener)

    }


    fun updateAllComponents(newParameteres: AuthSettings) {
        this.currentAuthParametes = newParameteres
        this.etNumMaxOfTries.setText(this.currentAuthParametes.failedLoginMaximumNumber.toString())
        this.etDaysExpPassword.setText(this.currentAuthParametes.passwordExpirationTimeDays.toString())
        this.etDaysExpSession.setText(this.currentAuthParametes.sessionExpirationTimeMin.toString())
        this.etMinNumOfSpecialChar.setText(this.currentAuthParametes.minSpecialLettersNumber.toString())
        this.etMinNumOfUpperCase.setText(this.currentAuthParametes.minUpperCaseLettersNumber.toString())
        this.etLengthPassword.setText(this.currentAuthParametes.minPasswordLen.toString())

    }


    fun onClickSaveNewAuthParams(view: View) {
        var newAuthSettingsToSave = AuthSettings()
        newAuthSettingsToSave.failedLoginMaximumNumber =  this.etNumMaxOfTries.text.toString().toInt()
        newAuthSettingsToSave.passwordExpirationTimeDays = authManager.convertSessionTimeInMinutes(
                        this.etDaysExpPassword.text.toString().toInt(), selectedItemOnSessionTime)
        newAuthSettingsToSave.sessionExpirationTimeMin = authManager.convertSessionTimeInMinutes(
                this.etDaysExpSession.text.toString().toInt(), selectedItemOnExpTime)
        newAuthSettingsToSave.minSpecialLettersNumber = this.etMinNumOfSpecialChar.text.toString().toInt()
        newAuthSettingsToSave.minUpperCaseLettersNumber = this.etMinNumOfUpperCase.text.toString().toInt()
        newAuthSettingsToSave.minPasswordLen = this.etLengthPassword.text.toString().toInt()
        saveAuthSettings(newAuthSettingsToSave)
    }


    fun saveAuthSettings(newParameteresToSave: AuthSettings) {
        var controllerListener = object : ControllerListener {
            override fun notifyController(anyObject: Any?, fromClass: Any) {
                progressDialog.dismiss()
                if (anyObject != null) {
                    var responseFromService: ResponseFirstLogin = anyObject as ResponseFirstLogin
                    if (responseFromService.error!!.isEmpty()) {
                        Toast.makeText(this@AuthActivity, resources.getString(R.string.auth_tittle_ok),
                                Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@AuthActivity, responseFromService.error!!,
                                Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@AuthActivity, resources.getString(R.string.auth_tittle_error),
                            Toast.LENGTH_SHORT).show()
                }
            }
        }

        authManager.saveAuthParametersWithService(this, newParameteresToSave, controllerListener)
        progressDialog.show()
    }


}