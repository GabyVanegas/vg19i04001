package com.example.vg19i04001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vg19i04001.Adapters.PuntuacionAdapter
import com.example.vg19i04001.databinding.ActivityPuntuacionBinding

class PuntuacionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPuntuacionBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var puntuacionAdapter: PuntuacionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configuracion de viewBinding
        binding = ActivityPuntuacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Habilitar action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        title = "Lista de puntuaciones"

        configRecyclerView()
    }

    // Método que configura el recyclerview
    fun configRecyclerView(){
        recyclerView = binding.rcPuntuaciones
        puntuacionAdapter = PuntuacionAdapter(mutableListOf(), this)
        linearLayoutManager = LinearLayoutManager(this)

        recyclerView.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = linearLayoutManager
            recyclerView.adapter = puntuacionAdapter
        }
    }

    //Método que configura el action bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                // Finaliza la actividad
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}