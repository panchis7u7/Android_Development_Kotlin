package com.app.layoutsejer1.ui.linear

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LinearViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is a linear Fragment"
    }
    val text: LiveData<String> = _text
}