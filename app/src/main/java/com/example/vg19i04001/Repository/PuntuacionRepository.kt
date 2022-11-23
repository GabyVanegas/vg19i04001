package com.example.vg19i04001.Repository

import com.example.vg19i04001.Models.PuntuacionEntity

class PuntuacionRepository(var lstPuntajes: MutableList<PuntuacionEntity> = mutableListOf()){
    fun add(puntuacionEntity: PuntuacionEntity){
        lstPuntajes.add(puntuacionEntity)
    }

    fun get(): MutableList<PuntuacionEntity> = lstPuntajes
}