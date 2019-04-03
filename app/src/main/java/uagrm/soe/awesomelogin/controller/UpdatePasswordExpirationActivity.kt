package uagrm.soe.awesomelogin.controller

import uagrm.soe.awesomelogin.R
import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
//import junit.runner.Version.id
import java.text.SimpleDateFormat
import java.util.*



class UpdatePasswordExpirationActivity : AppCompatActivity() {
    lateinit var btn_update : Button
    lateinit var calendar_cant_intentos : CalendarView
    lateinit var txt_name_req_one : TextView
    lateinit var txt_detail_req_one : TextView

    //lateinit var  databaseHelper: DatabaseHelper

    var id: String = ""
    var fname: String = ""
    var lname: String = ""
    var gender: String = ""
    var standard: String = ""


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password_expiration)
        btn_update=findViewById(R.id.btn_update_req_two)
        calendar_cant_intentos=findViewById(R.id.calendarView_cant_intentos_req_two)

        txt_name_req_one=findViewById(R.id.txt_name_req_one)
        txt_detail_req_one=findViewById(R.id.txt_detail_req_one)

       // databaseHelper=DatabaseHelper(this)

        id=intent.getStringExtra(ID)
        txt_name_req_one.setText(intent.getStringExtra(NAME).toString())
        txt_detail_req_one.setText(intent.getStringExtra(DETAIL).toString())

        btn_update.setOnClickListener {
            UpdatePasswordExpiration()
        }
    }

    private fun UpdatePasswordExpiration() {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
      //  val currentDate = sdf.format(Date())
        val currentDate = sdf.format(calendar_cant_intentos.getDate())
//calendar_cant_intentos.getDate().toString()
        val user=User()
        user.id=Integer.parseInt(id)
        user.fname=fname
        user.lname=lname
        user.gender=gender
        user.standard=standard
        user.record=currentDate

        val result : Boolean = true// databaseHelper.updateUser(user)

        when{
            result->{
                Toast.makeText(this,"Data Updated Successfully " + currentDate  ,Toast.LENGTH_LONG).show()
               // finish()
            }
            else->Toast.makeText(this,"Failed to update data",Toast.LENGTH_LONG).show()
        }

    }



    companion object {
        private val ID = "Id"
        private val NAME = "name"
        private val DETAIL= "detail"
        private val REQUERIMENT = "requeriment"
        private val STATUS="status"
    }
}
