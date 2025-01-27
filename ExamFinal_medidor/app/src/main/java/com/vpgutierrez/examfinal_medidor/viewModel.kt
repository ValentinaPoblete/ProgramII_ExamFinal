package com.vpgutierrez.examfinal_medidor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vpgutierrez.examfinal_medidor.data.Medidor
import com.vpgutierrez.examfinal_medidor.data.MedidorDAO
import kotlinx.coroutines.launch

class MedicionViewModel(private val dao: MedidorDAO) : ViewModel() {
    val mediciones = mutableListOf<Medidor>()

    fun getMediciones() {
        viewModelScope.launch {
            mediciones.clear()
            mediciones.addAll(dao.getAllMediciones())
        }
    }

    fun agregarMedicion(tipo: String, precio: Any?, fecha: String) {
        viewModelScope.launch {
            dao.insertMedicion(Medidor(tipo = tipo, precio = precio, fecha = fecha))
            getMediciones()
        }
    }
}