package com.example.allui.dialogfragment

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.allui.R


class MyDialogFragment : DialogFragment() {

    private var mDialog: Dialog? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        mDialog = activity?.let { createCustomDialog(it, R.layout.dialog_custom_view) }
        return mDialog!!
    }

    fun createCustomDialog(activity: Activity, layout: Int): AlertDialog? {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        val view = inflater.inflate(layout, null)
        builder?.setView(view)
        return builder?.create()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        isCancelable = true//non-cancelable if false
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        Log.d("TAG","Dismiss")
    }
}