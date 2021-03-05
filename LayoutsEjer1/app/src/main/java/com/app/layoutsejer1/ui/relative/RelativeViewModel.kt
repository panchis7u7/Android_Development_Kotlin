package com.app.layoutsejer1.ui.relative

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RelativeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is a relative Fragment"
    }
    val text: LiveData<String> = _text
}