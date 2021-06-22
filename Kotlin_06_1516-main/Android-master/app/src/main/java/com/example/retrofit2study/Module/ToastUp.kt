package com.example.retrofit2study.Module

import android.widget.Toast
import com.example.retrofit2study.MainApp

object ToastUp {
  fun showToast(msg: String) {
   Toast.makeText(MainApp.context, msg, Toast.LENGTH_SHORT).show()
 }
}