package uagrm.soe.awesomelogin.abstract


import android.app.ActivityOptions
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import uagrm.soe.awesomelogin.R


/**
 * Created by Kevin Subieta on 1/13/17.
 */

abstract class AwesomeCompactActivity : AppCompatActivity() {


    private val onBackHomeClickListener = View.OnClickListener { onBackPressed() }

    fun initToolbarComponents(viewID: Int, tittle: String, isDisplayHomeButton: Boolean) {
        val toolbar = findViewById<View>(viewID) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(tittle)
        if (isDisplayHomeButton) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            toolbar.setNavigationOnClickListener(onBackHomeClickListener)
        }
    }


    fun initToolbarComponents(viewID: Int, tittle: String, isDisplayHomeButton: Boolean, newColorArrow :Int) {
        val toolbar = findViewById<View>(viewID) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(tittle)
        if (isDisplayHomeButton) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            toolbar.setNavigationOnClickListener(onBackHomeClickListener)
        }
        setColorToBackArrow(newColorArrow)
    }


    fun initToolbarComponents(viewID: Int, isDisplayHomeButton: Boolean) {
        val toolbar = findViewById<View>(viewID) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("")
        if (isDisplayHomeButton) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            toolbar.setNavigationOnClickListener(onBackHomeClickListener)
        }
    }



    fun setColorToBackArrow(colorArrow : Int) {
        var  upArrow : Drawable = getResources().getDrawable(R.drawable.abc_ic_ab_back_material)
        upArrow.setColorFilter(getResources().getColor(colorArrow), PorterDuff.Mode.SRC_ATOP)
        supportActionBar!!.setHomeAsUpIndicator(upArrow)
    }


    fun setHomeDisplayButton(active: Boolean) {
        supportActionBar!!.setDisplayHomeAsUpEnabled(active)
    }

    fun createBundleForAnimation(context: Context): Bundle {
        return ActivityOptions.makeCustomAnimation(context,
                R.anim.animation_slide_right_to_left, R.anim.animation_slide_left_to_right).toBundle()
    }


    protected fun setAnimationOnFinishActivity() {
        overridePendingTransition(R.anim.animation_slide_right_to_left_finish, R.anim.animation_slide_left_to_right_finish)
    }


}