package com.example.yhous.beparent


import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.view.WindowManager
import android.widget.EditText




/**
 * A simple [Fragment] subclass.
 */
class CustomDialogFragment : DialogFragment() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_dialog, container)
    dialog.setTitle("Please enter username")
    dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    return view
  }

//  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//    return AlertDialog.Builder(activity)
//            .setIcon(android.R.drawable.stat_notify_error)
//            .setTitle("Ne sois pas timide !")
//            .setMessage("Entre un pseudo !")
//            // positive button
//            .setPositiveButton("OK") { dialog, which -> Toast.makeText(activity, "Pressed OK", Toast.LENGTH_SHORT).show() }
//            // negative button
//            .setNegativeButton("Cancel") { dialog, which -> Toast.makeText(activity, "Cancel", Toast.LENGTH_SHORT).show() }.create()
//
//  }
}// Required empty public constructor
