package com.example.vg19i04001.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PuntuacionEntity")
class PuntuacionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "nick") private var nick: String,
    @ColumnInfo(name = "puntaje") private var puntaje: String,){

    fun getNick(): String = this.nick
    fun getPuntaje(): String = this.puntaje
}