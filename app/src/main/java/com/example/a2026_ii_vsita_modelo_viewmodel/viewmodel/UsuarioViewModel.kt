package com.example.a2026_ii_vsita_modelo_viewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a2026_ii_vsita_modelo_viewmodel.model.Usuario
import com.example.a2026_ii_vsita_modelo_viewmodel.model.UsuarioRepository

class UsuarioViewModel: ViewModel() {
    private val _usuario = MutableLiveData<Usuario> (
        UsuarioRepository.getUsuario(1)?:
        Usuario(
            id = 0,
            nombre = "Sin nombre",
            apellidos = "",
            correo = "",
            genero = ""
        )
    )
    val usuario: LiveData<Usuario> get() = _usuario


    fun siguienteUsuario()
    {
        _usuario.value = UsuarioRepository.siguiente()
    }
    fun previoUsuario()
    {
        _usuario.value = UsuarioRepository.previo()
    }

    fun agregar( nuevoUsuario: Usuario){
        UsuarioRepository.agregar(nuevoUsuario)
        _usuario.value = nuevoUsuario
    }

}