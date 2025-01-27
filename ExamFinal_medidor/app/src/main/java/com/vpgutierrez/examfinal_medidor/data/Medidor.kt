package com.vpgutierrez.examfinal_medidor.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medidor(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tipo: String,
    val precio: Any?,
    val fecha: String
)