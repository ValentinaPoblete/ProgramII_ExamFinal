package com.vpgutierrez.examfinal_medidor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.vpgutierrez.examfinal_medidor.data.MedidorBD

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            MedidorBD.AppDatabase::class.java, "medidor_bd"
        ).build()

        val dao = db.medidorDao()
        val viewModel = MedicionViewModel(dao)

        setContent {
            AppNav()
        }
    }
}