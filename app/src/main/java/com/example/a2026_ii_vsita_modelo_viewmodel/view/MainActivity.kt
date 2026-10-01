package com.example.a2026_ii_vsita_modelo_viewmodel.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.a2026_ii_vsita_modelo_viewmodel.R
import com.example.a2026_ii_vsita_modelo_viewmodel.databinding.ActivityMainBinding
import com.example.a2026_ii_vsita_modelo_viewmodel.model.Usuario
import com.example.a2026_ii_vsita_modelo_viewmodel.model.UsuarioRepository
import com.example.a2026_ii_vsita_modelo_viewmodel.viewmodel.UsuarioViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
   val viewModel: UsuarioViewModel by viewModels<UsuarioViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioObserver = Observer<Usuario>{ nuevoUsuario ->
            binding.tvId.text = nuevoUsuario.id.toString();
            binding.tvNombre.text = nuevoUsuario.nombre;
            binding.tvApellidos.text = nuevoUsuario.apellidos;
            binding.tvCorreo.text = nuevoUsuario.correo;
            binding.tvGenero.text = nuevoUsuario.genero;
        }

        viewModel.usuario.observe(this, usuarioObserver)


        binding.btnSiguiete.setOnClickListener {
            viewModel.siguienteUsuario()
        }

        binding.btnPrevio.setOnClickListener {
            viewModel.previoUsuario()

        }

    }


}