package com.example.vg19i04001.Interfaces

import androidx.room.Dao
import androidx.room.Insert
import com.example.vg19i04001.Models.PuntuacionEntity

@Dao
interface PuntuacionDao {
    @Insert
    fun addPuntuacion(puntuacionEntity: PuntuacionEntity)
}