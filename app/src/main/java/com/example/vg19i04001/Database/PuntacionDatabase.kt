package com.example.vg19i04001.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vg19i04001.Interfaces.PuntuacionDao
import com.example.vg19i04001.Models.PuntuacionEntity

@Database(entities = [PuntuacionEntity::class], version = 1)
abstract class PuntacionDatabase: RoomDatabase() {
    abstract fun getPuntuacionDao(): PuntuacionDao
}