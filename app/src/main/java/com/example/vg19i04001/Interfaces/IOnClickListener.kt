package com.example.vg19i04001.Interfaces

import com.example.vg19i04001.Models.PuntuacionEntity

interface IOnClickListener {
    fun onDeletePuntuacion(puntuacionEntity:PuntuacionEntity, position: Int)
}