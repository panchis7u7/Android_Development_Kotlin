package com.example.dadm_u1p4_aplicacion_escolar.Viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia

class MateriaViewModel: ViewModel() {
    private var _materia: MutableLiveData<Materia> = MutableLiveData<Materia>()
    val materia: LiveData<Materia> get() = _materia

    fun setMateria(materia: Materia){
        _materia.value = materia
    }
}