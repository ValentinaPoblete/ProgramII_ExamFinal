package com.vpgutierrez.examfinal_medidor.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MedidorDAO {
    @Query("SELECT * FROM medidor")
    suspend fun getAllMediciones(): List<Medidor>

    @Insert
    suspend fun insertMedicion(medicion: Medidor)
}