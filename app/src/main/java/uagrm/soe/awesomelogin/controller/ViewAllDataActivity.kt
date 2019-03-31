package uagrm.soe.awesomelogin.controller

import uagrm.soe.awesomelogin.R
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import java.time.LocalDate
import android.view.ContextMenu
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*


class ViewAllDataActivity : AppCompatActivity() {
    lateinit var databaseHelper: DatabaseHelper
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DataAdapter

    var hashMapArrayList: ArrayList<HashMap<String, String>> = ArrayList()
    var list: List<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all_data)
        recyclerView=findViewById(R.id.recycle_view)
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        databaseHelper= DatabaseHelper(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId){
            R.id.password_history->{

                Toast.makeText(this,"#EstamosParaAyudarte",Toast.LENGTH_LONG).show()
                /*
                val intent=Intent(this,FailedLoginMaximumNumberActivity::class.java)
                startActivity(intent)
*/
                ///mas menu
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        ReadData()
        registerForContextMenu(recyclerView)
        super.onResume()
    }

    private fun ReadData() {

        val requisito_3: User = User()
        requisito_3.fname = "03.- Failed Login Maximum Number"
        requisito_3.gender = "Cantidad N de intentos fallidos de logueo"
        requisito_3.standard = "N = 3"
        requisito_3.record = "DESACTIVADO"

        val requisito_5: User = User()
        requisito_5.fname = "05.- Password expiration"
        requisito_5.gender = "Tiempo N de duracion de la contraseña"
        requisito_5.standard = "N = 3"
        requisito_5.record = "DESACTIVADO"

        val requisito_6: User = User()
        requisito_6.fname = "06.- Session expiration"
        requisito_6.gender = "Tiempo N de duracion de la session del usuario"
        requisito_6.standard = "N =  1 mes"
        requisito_6.record = "DESACTIVADO"

        val list = listOf(requisito_3,requisito_5,requisito_6)


       // val list=databaseHelper.user

        hashMapArrayList.clear()
        if (list != null && list.size>0)
        {

            for (user:User in list) {
                val hashMap = HashMap<String,String>()
                hashMap.put(ID, user.id.toString())
                hashMap.put(NAME, user.fname)
                hashMap.put(DETAIL, user.gender)
                hashMap.put(REQUERIMENT, user.standard)
                hashMap.put(STATUS,user.record)
                hashMapArrayList.add(hashMap)
            }
            adapter = DataAdapter(this,hashMapArrayList)
            recyclerView.adapter=adapter
            Log.d("array", hashMapArrayList.toString())
            Toast.makeText(this,"Parametro registrado",Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(this,"Sin parametros",Toast.LENGTH_LONG).show()
        }
    }

  /*  override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v!!.id == R.id.recycle_view) {
            menu!!.setHeaderTitle("Set Action")
            menu.add(0, 1, 0, "Update Contact")
            menu.add(0, 2, 0, "Delete Contact")
        }
    }*/

    companion object {
        private val ID = "Id"
        private val NAME = "name"
        private val DETAIL= "detail"
        private val REQUERIMENT = "requeriment"
        private val STATUS="status"
    }

    fun onClickUpdateAuthSettings(view: View) {

        //passText = findViewById(R.id.passTxt)

        //var userName = userText.text.toString()
        Toast.makeText(this,"Primer SMS",Toast.LENGTH_LONG).show()
    }
}
