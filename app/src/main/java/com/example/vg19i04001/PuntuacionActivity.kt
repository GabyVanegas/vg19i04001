package com.example.vg19i04001

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vg19i04001.Adapters.PuntuacionAdapter
import com.example.vg19i04001.Database.PuntacionDatabase
import com.example.vg19i04001.Interfaces.IOnClickListener
import com.example.vg19i04001.Models.PuntuacionEntity
import com.example.vg19i04001.databinding.ActivityPuntuacionBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class PuntuacionActivity : AppCompatActivity(), IOnClickListener {
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
    private fun getPuntuaciones(){
        doAsync {
            val puntuacion = PuntuacionApplication.database.getPuntuacionDao().getAllPuntaje()
            uiThread {
                puntuacionAdapter.setPuntuacion(puntuacion as MutableList<PuntuacionEntity>)
            }
        }
    }
    // Método que configura el recyclerview
    fun configRecyclerView(){

        puntuacionAdapter = PuntuacionAdapter(lstPuntuacion =  mutableListOf(), this)

        getPuntuaciones()

            binding.rcPuntuaciones.setHasFixedSize(true)
            binding.rcPuntuaciones.layoutManager = linearLayoutManager
            binding.rcPuntuaciones.adapter = puntuacionAdapter

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

    override fun onDeletePuntuacion(puntuacion: PuntuacionEntity, position: Int) {
        AlertDialog.Builder(this)
            .setTitle(this.resources.getString(R.string.titulo_eliminar))
            .setMessage(this.resources.getString(R.string.msg_eliminar))
            .setPositiveButton(android.R.string.ok) { _, _ ->
                doAsync {
                    PuntuacionApplication.database.getPuntuacionDao().delete(puntuacion)
                    uiThread {
                        puntuacionAdapter.deletePuntuacion(puntuacion)
                    }
                }
            }.show()
    }
}