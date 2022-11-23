package com.example.vg19i04001

import android.app.Application
import androidx.room.Room
import com.example.vg19i04001.Database.PuntacionDatabase

class PuntuacionApplication : Application() {
    companion object {
        lateinit var database: PuntacionDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, PuntacionDatabase::class.java,
            "PuntuacionDB")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    }
}