package uagrm.soe.awesomelogin.controller

import android.os.Bundle
import android.view.View
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity
import uagrm.soe.awesomelogin.listeners.ControllerListener
import uagrm.soe.awesomelogin.logic.ChangePassManager
import uagrm.soe.awesomelogin.logic.SecurityManager
import javax.inject.Inject

class FirstLoginActivity : AwesomeCompactActivity(), ControllerListener {


    @BindView(R.id.tiOldPassword) lateinit var tiOldPassword: EditText
    @BindView(R.id.tiCurrentPassword) lateinit var tiCurrentPassword: EditText
    @BindView(R.id.tiConfirmPassword) lateinit var tiConfirmPassword: EditText
    @Inject lateinit var changePassManager: ChangePassManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButterKnife.bind(this)
        setContentView(R.layout.activity_first_login)
        changePassManager = ChangePassManager()
    }

    fun onClickChangeCurrentPassword(view: View){
        if (changePassManager.validateUserTextsIsEmpty(this.tiOldPassword, this.tiCurrentPassword,
                        this.tiConfirmPassword)){
            var userNameText = this.tiOldPassword.text.toString()
            var oldPassText = this.tiCurrentPassword.text.toString()
            var newPassText = this.tiCurrentPassword.text.toString()
            changePassManager.changeUserPassword(userNameText,oldPassText,newPassText,this)
        }
    }

    override fun notifyController(anyObject: Any?, fromClass: Any) {
        if (anyObject != null){

        }
    }


}