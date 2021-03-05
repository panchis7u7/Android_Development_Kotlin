package com.app.layoutsejer1.ui.table

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TableViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is table Fragment"
    }
    val text: LiveData<String> = _text
}