package com.example.vg19i04001.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vg19i04001.Models.PuntuacionEntity
import com.example.vg19i04001.R
import com.example.vg19i04001.databinding.ItemPuntuacionListaBinding

class PuntuacionAdapter(private var lstPuntuacion: MutableList<PuntuacionEntity>,
private var context: Context): RecyclerView.Adapter<PuntuacionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val layout = LayoutInflater.from(parent.context)
        return ViewHolder(layout.inflate(R.layout.item_puntuacion_lista, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = lstPuntuacion[position]
        // Uso de funcion de alcance para agregar acciones al objeto en un mismo bloque
        with(holder){

            binding.tvxNick.text = item.getNick()
            binding.tvxPuntacion.text = item.getPuntaje()

        }
    }
    override fun getItemCount(): Int = lstPuntuacion.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemPuntuacionListaBinding.bind(view)
    }
}