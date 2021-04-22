package com.example.dadm_u1p5_fragmentos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityFragmentViewModel : ViewModel() {
    private var _mText: MutableLiveData<CharSequence> = MutableLiveData<CharSequence>("")
    val mText: LiveData<CharSequence> get() = _mText

    fun setText(input: CharSequence){
        _mText.value = input
    }
}