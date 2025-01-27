package com.vpgutierrez.examfinal_medidor.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Medidor::class], version = 1)
abstract class MedidorBD{
    abstract class AppDatabase : RoomDatabase() {
        abstract fun medidorDao(): MedidorDAO
    }
}