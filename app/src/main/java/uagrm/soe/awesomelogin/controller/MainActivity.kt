package uagrm.soe.awesomelogin.controller

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import uagrm.soe.awesomelogin.R
import uagrm.soe.awesomelogin.abstract.AwesomeCompactActivity
import uagrm.soe.awesomelogin.logic.managers.AuthManager

class MainActivity : AwesomeCompactActivity() {

    var authManager: AuthManager = AuthManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.password_history) {
            authManager.logOut(this)
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }
}
