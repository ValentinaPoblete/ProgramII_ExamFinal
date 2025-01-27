package com.vpgutierrez.examfinal_medidor.paginas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.vpgutierrez.examfinal_medidor.R
import com.vpgutierrez.examfinal_medidor.data.Medidor
import java.lang.reflect.Modifier

@Composable
fun paginaFormulario (
    onGuardarRegistro: (Medidor, Any?, Any?) -> Unit,
) {
    var valor by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var isAguaChecked by remember { mutableStateOf(false) }
    var isLuzChecked by remember { mutableStateOf(false) }
    var isGasChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = valor,
            onValueChange = { valor = it },
            label = { Text(stringResource(R.string.valor_registrado)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text(stringResource(R.string.fecha_registrada)) },
            modifier = Modifier.fillMaxWidth()
        )

// Checkbox para agua
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isAguaChecked,
                onCheckedChange = {
                    isAguaChecked = it
                    if (it) {
                        isLuzChecked = false
                        isGasChecked = false
                    }
                }
            )
            Text(stringResource(R.string.agua), modifier = Modifier.padding(start = 8.dp))
        }

// Checkbox para luz
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isLuzChecked,
                onCheckedChange = {
                    isLuzChecked = it
                    if (it) {
                        isAguaChecked = false
                        isGasChecked = false
                    }
                }
            )
            Text(stringResource(R.string.luz), modifier = Modifier.padding(start = 8.dp))
        }

// Checkbox para gas
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isGasChecked,
                onCheckedChange = {
                    isGasChecked = it
                    if (it) {
                        isAguaChecked = false
                        isLuzChecked = false
                    }
                }
            )
            Text(stringResource(R.string.gas), modifier = Modifier.padding(start = 8.dp))
        }

// Botón Guardar Registro
        Button(
            onClick = {
                val tipo = when {
                    isAguaChecked -> "agua"
                    isLuzChecked -> "luz"
                    isGasChecked -> "gas"
                    else -> ""
                }

                if (tipo.isNotEmpty()) {
                    onGuardarRegistro(
                        Medidor(
                            tipo = tipo,
                            precio = valor.toDouble(),
                            fecha = fecha
                        )
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = valor.isNotEmpty() && fecha.isNotEmpty() && (isAguaChecked || isLuzChecked || isGasChecked)
        ) {
            Text(stringResource(R.string.guardar_registro))
        }
    }
}