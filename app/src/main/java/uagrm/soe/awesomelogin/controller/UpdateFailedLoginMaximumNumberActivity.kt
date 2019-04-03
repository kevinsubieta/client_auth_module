package uagrm.soe.awesomelogin.controller

import uagrm.soe.awesomelogin.R
import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_update_failed_login_maximum_number.*
//import junit.runner.Version.id
import java.text.SimpleDateFormat
import java.util.*


class UpdateFailedLoginMaximumNumberActivity : AppCompatActivity() {
    lateinit var btn_update: Button
    lateinit var btn_add: Button
    lateinit var btn_not_add: Button
    lateinit var edit_cant_intentos: EditText
    lateinit var txt_name_req_one: TextView
    lateinit var txt_detail_req_one: TextView

    //lateinit var  databaseHelper: DatabaseHelper

    var id: String = ""
    var fname: String = ""
    var lname: String = ""
    var gender: String = ""
    var standard: String = ""


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_failed_login_maximum_number)
        btn_update = findViewById(R.id.btn_update_req_one)
        btn_add = findViewById(R.id.btn_update_req_one_add)
        btn_not_add = findViewById(R.id.btn_update_req_one_not_add)
        edit_cant_intentos = findViewById(R.id.edit_cant_intentos_req_one)

        txt_name_req_one = findViewById(R.id.txt_name_req_one)
        txt_detail_req_one = findViewById(R.id.txt_detail_req_one)

        // databaseHelper=DatabaseHelper(this)

        id = intent.getStringExtra(ID)
        txt_name_req_one.setText(intent.getStringExtra(NAME).toString())
        txt_detail_req_one.setText(intent.getStringExtra(DETAIL).toString())
        edit_cant_intentos.setText(intent.getStringExtra(REQUERIMENT).toString())


        btn_update.setOnClickListener {
            UpdateFailedLoginMaximumNumber()
        }

        btn_update_req_one_add.setOnClickListener {
            val cant = edit_cant_intentos.text.toString().toInt() + 1
            edit_cant_intentos.setText(cant.toString())
        }

        btn_update_req_one_not_add.setOnClickListener {
            val cant = edit_cant_intentos.text.toString().toInt() - 1
            edit_cant_intentos.setText(cant.toString())
        }
    }

    private fun UpdateFailedLoginMaximumNumber() {
        val intent = Intent(this, ViewAllDataActivity::class.java)
        intent.putExtra(ID, 1)
        intent.putExtra(REQUERIMENT,edit_cant_intentos.text.toString())
        intent.putExtra(STATUS, "ACTIVADO")
        startActivity(intent)

        Toast.makeText(this, "Data Updated Successfully..", Toast.LENGTH_LONG).show()
        finish()

    }


    companion object {
        private val ID = "Id"
        private val NAME = "name"
        private val DETAIL = "detail"
        private val REQUERIMENT = "requeriment"
        private val STATUS = "status"
    }
}
