package com.example.dadm_u1p4_aplicacion_escolar.Stateflows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MateriasStateFlow: ViewModel() {
    private val _materias = MutableStateFlow<LatestMateriaState>(LatestMateriaState.Empty)
    val materiaStateFlow: StateFlow<LatestMateriaState> = _materias

    fun setMaterias(materias: List<Materia>) = viewModelScope.launch {
        _materias.value = LatestMateriaState.Success(materias)
    }

    sealed class LatestMateriaState {
        data class Success(val materias: List<Materia>): LatestMateriaState()
        object Empty: LatestMateriaState()
    }
}