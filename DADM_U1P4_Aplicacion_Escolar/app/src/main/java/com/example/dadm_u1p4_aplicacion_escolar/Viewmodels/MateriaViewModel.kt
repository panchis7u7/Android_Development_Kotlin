package com.example.dadm_u1p4_aplicacion_escolar.Viewmodels

import android.widget.TableRow
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dadm_u1p4_aplicacion_escolar.Models.Materia

class MateriaViewModel: ViewModel() {
    private var _materia: MutableLiveData<Pair<Materia, TableRow>> = MutableLiveData<Pair<Materia, TableRow>>()
    val materia: LiveData<Pair<Materia, TableRow>> get() = _materia

    fun setMateria(materia: Pair<Materia, TableRow>){
        _materia.value = materia
    }
}