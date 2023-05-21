package com.example.laboratorio01.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.laboratorio01.model.Asistente

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenEditAsistente(navController: NavHostController, listAsistente: MutableList<Asistente>, index: Int)
{
    val asistente= listAsistente[index]

    val nombre = remember { mutableStateOf(asistente.nombre) }
    val apellido = remember { mutableStateOf(asistente.apellido) }
    val fechaInscripcion = remember { mutableStateOf(asistente.fechaInscripcion) }
    val tipoSangre = remember { mutableStateOf(asistente.tipoSangre) }
    val telefono = remember { mutableStateOf(asistente.telefono) }
    val correo = remember { mutableStateOf(asistente.correo) }
    val montoPagado = remember { mutableStateOf(asistente.montoPagado.toString()) }
    val focusManager = LocalFocusManager.current

    Box(modifier = Modifier.fillMaxSize()){
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),
            color = Color.White,) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Text(text = "Registrar Asistente")

                TextField(label={ Text(text = "Nombre") },value = nombre.value, onValueChange ={nombre.value=it} )
                TextField(label={ Text(text = "Apellido") }, value = apellido.value, onValueChange = {apellido.value=it})
                TextField(label={ Text(text = "Fecha inscripción") }, value = fechaInscripcion.value, onValueChange = {fechaInscripcion.value=it})
                TextField(label={ Text(text = "Tipo de sangre") }, value = tipoSangre.value, onValueChange = {tipoSangre.value=it})
                TextField(label={ Text(text = "Teléfono") }, value = telefono.value, onValueChange = {telefono.value=it})
                TextField(label={ Text(text = "Correo") }, value = correo.value, onValueChange = {correo.value=it})
                TextField(label={ Text(text = "Monto pagado") }, value = montoPagado.value, onValueChange = {montoPagado.value=it})

                Button(onClick = { navController.popBackStack()}) {
                    Text(text = "Cancelar")
                }
                Button(onClick = {
                    var asistente= Asistente(nombre.value,apellido.value,fechaInscripcion.value,tipoSangre.value,telefono.value,correo.value,montoPagado.value.toDouble())
                    listAsistente[index]= asistente
                    navController.popBackStack()
                }) {
                    Text(text = "Agregar")
                }

            }

        }
    }
}