package com.vpgutierrez.examfinal_medidor.paginas

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vpgutierrez.examfinal_medidor.R
import com.vpgutierrez.examfinal_medidor.data.Medidor
import java.lang.reflect.Modifier

@Composable
fun paginaListado(
    registros: List<Medidor>,
    navToFormulario: () -> Unit

) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToFormulario) {
                Icon(Icons.Default.Add, contentDescription = "Agregar Registro")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(registros) { medicion ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Mostrar el ícono según el tipo de medidor
                    Icon(
                        painter = painterResource(
                            tipo = when (registros.tipo) {
                                "agua" -> R.drawable.ic_agua
                                "luz" -> R.drawable.ic_luz
                                "gas" -> R.drawable.ic_gas
                                else -> ""
                            }
                        ),
                        contentDescription = medicion.tipo,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = registros.tipo, modifier = Modifier.weight(1f))
                    Text(text = "${registros.precio}", modifier = Modifier.weight(1f))
                    Text(text = registros.fecha, modifier = Modifier.weight(1f))
                }
                Divider()
            }
        }
    }
}