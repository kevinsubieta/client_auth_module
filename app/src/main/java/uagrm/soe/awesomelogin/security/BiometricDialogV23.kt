package uagrm.soe.awesomelogin.security

import android.content.Context
import android.content.DialogInterface
import android.support.design.widget.BottomSheetDialog
import android.view.View
import android.graphics.drawable.Drawable
import uagrm.soe.awesomelogin.R.id.item_description
import uagrm.soe.awesomelogin.R.id.item_subtitle
import uagrm.soe.awesomelogin.R.id.item_status
import uagrm.soe.awesomelogin.R.id.item_title
import uagrm.soe.awesomelogin.R.id.img_logo
import uagrm.soe.awesomelogin.R.id.btn_cancel
import uagrm.soe.awesomelogin.R.layout.view_bottom_sheet
import android.support.annotation.NonNull
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import uagrm.soe.awesomelogin.R

/**
 * Created by Kevin Subieta on 27/03/19.
 */
class BiometricDialogV23 : BottomSheetDialog, View.OnClickListener {

    private var btnCancel: Button? = null
    private var imgLogo: ImageView? = null
    private var itemTitle: TextView? = null
    private var itemDescription:TextView? = null
    private var itemSubtitle:TextView? = null
    private var itemStatus:TextView? = null

    private var biometricCallback: BiometricCallback? = null


    constructor(context: Context, biometricCallback: BiometricCallback) : super(context) {
        this.biometricCallback = biometricCallback
    }

    constructor(context: Context, theme: Int, biometricCallback: BiometricCallback) : super(context, theme) {
        this.biometricCallback = biometricCallback
    }

    constructor(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener?, biometricCallback: BiometricCallback) : super(context, cancelable, cancelListener) {
        this.biometricCallback = biometricCallback
    }

    constructor(context: Context) : super(context)


    private fun setDialogView() {
        val bottomSheetView = layoutInflater.inflate(R.layout.view_bottom_sheet, null)
        setContentView(bottomSheetView)

        btnCancel = findViewById(R.id.btn_cancel)
        btnCancel!!.setOnClickListener(this)

        imgLogo = findViewById(R.id.img_logo)
        itemTitle = findViewById(R.id.item_title)
        itemStatus = findViewById(R.id.item_status)
        itemSubtitle = findViewById(R.id.item_subtitle)
        itemDescription = findViewById(R.id.item_description)

        updateLogo()
    }

    fun setTitle(title: String) {
        itemTitle!!.text = title
    }

    fun updateStatus(status: String) {
        itemStatus!!.setText(status)
    }

    fun setSubtitle(subtitle: String) {
        itemSubtitle!!.setText(subtitle)
    }

    fun setDescription(description: String) {
        itemDescription!!.setText(description)
    }

    fun setButtonText(negativeButtonText: String) {
        btnCancel!!.setText(negativeButtonText)
    }

    private fun updateLogo() {
        try {
            val drawable = getContext().packageManager.getApplicationIcon(context!!.getPackageName())
            imgLogo!!.setImageDrawable(drawable)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    override fun onClick(view: View) {
        dismiss()
        biometricCallback!!.onAuthenticationCancelled()
    }
}