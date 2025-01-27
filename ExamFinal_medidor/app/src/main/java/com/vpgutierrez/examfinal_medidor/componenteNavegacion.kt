package com.vpgutierrez.examfinal_medidor

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vpgutierrez.examfinal_medidor.paginas.paginaFormulario
import com.vpgutierrez.examfinal_medidor.paginas.paginaListado

@Composable
fun AppNav() {
    val navController = rememberNavController()
    val viewModel: MedicionViewModel = viewModel()

    NavHost(navController, startDestination = "listado") {
        composable("listado") {
            paginaListado(
                navToFormulario = { navController.navigate("formulario") },
                registros = viewModel.mediciones,
            )
        }
        composable("formulario") {
            paginaFormulario(
                onGuardarRegistro = { tipo, precio, fecha ->
                    viewModel.agregarMedicion(tipo.toString(), precio, fecha.toString())
                    navController.popBackStack()
                }
            )
        }
    }
}