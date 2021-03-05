package com.app.layoutsejer1.ui.frame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FrameViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is a frane Fragment"
    }
    val text: LiveData<String> = _text
}