package com.example.a2026_ii_vsita_modelo_viewmodel.model

import kotlinx.coroutines.delay

class UsuarioRepository {

    companion object {
        var cursor = 0;
        val listaUsuario = mutableListOf<Usuario>(
            Usuario(
                id = 1,
                nombre = "Juan",
                apellidos = "López",
                correo = "juan@uacm.edu.mx",
                genero = "masculino"
            ),
            Usuario(
                id = 2,
                nombre = "Juan2",
                apellidos = "López2",
                correo = "juan2@uacm.edu.mx",
                genero = "masculino"
            ),
            Usuario(
                id = 3,
                nombre = "Juan3",
                apellidos = "López3",
                correo = "juan3@uacm.edu.mx",
                genero = "masculino"
            )
        )

        fun siguiente(): Usuario {



            cursor = (cursor + 1) % listaUsuario.size
            val usuario = listaUsuario[cursor]
            return usuario
        }

        fun agregar(usuario: Usuario) {
            listaUsuario.add(usuario)
        }

        fun getUsuario(id: Int): Usuario? {
            return listaUsuario.find({ user ->
                user.id == id
            })
        }

        fun previo(): Usuario {

            cursor = (cursor - 1) % listaUsuario.size
            if (cursor < 0){
                cursor = listaUsuario.size + cursor
            }
            val usuario = listaUsuario[cursor]
            return usuario

        }
    }
}