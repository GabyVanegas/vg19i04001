package com.example.vg19i04001.Interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.vg19i04001.Models.PuntuacionEntity

@Dao
interface PuntuacionDao {
    @Insert
    fun addPuntuacion(puntuacionEntity: PuntuacionEntity)
    @Query("SELECT * FROM PuntuacionEntity ORDER BY puntaje ASC LIMIT 3")
    fun getAllPuntaje(): List<PuntuacionEntity>
    @Delete
    fun delete(puntuacionEntity: PuntuacionEntity)
}