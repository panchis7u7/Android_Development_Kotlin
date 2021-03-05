package com.app.layoutsejer1.ui.absolute

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AbsoluteViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is a Absolute Fragment"
    }
    val text: LiveData<String> = _text
}