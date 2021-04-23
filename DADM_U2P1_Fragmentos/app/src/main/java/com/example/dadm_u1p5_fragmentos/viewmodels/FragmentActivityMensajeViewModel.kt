package com.example.dadm_u1p5_fragmentos.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FragmentActivityMensajeViewModel: ViewModel() {

    private val _messageUiState = MutableStateFlow<LatestMessageState>(LatestMessageState.Empty)
    val messageUiState: StateFlow<LatestMessageState> = _messageUiState

    fun setMessage(message: String) = viewModelScope.launch {
        _messageUiState.value = LatestMessageState.Success(message)
    }

    sealed class LatestMessageState {
        data class Success(val message: String) : LatestMessageState()
        object Empty: LatestMessageState()
    }
}