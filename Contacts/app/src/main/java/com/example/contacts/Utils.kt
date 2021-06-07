package com.example.contacts

import android.content.Context
import android.widget.Toast

class Utils {
    companion object {
        fun String.toast(context: Context) = Toast.makeText(context, this, Toast.LENGTH_LONG).show()
    }
}