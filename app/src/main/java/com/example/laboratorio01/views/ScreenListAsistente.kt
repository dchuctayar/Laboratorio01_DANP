package com.example.laboratorio01.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.laboratorio01.model.Asistente
import com.example.laboratorio01.navigate.Routes

@Composable
fun ScreenListAsistente(navController:NavHostController,listaAsistente: MutableList<Asistente>)
{
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lista de asistentes", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        LazyColumn(){
            itemsIndexed(listaAsistente){
                index,asistente->
                Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically) {
                    Text(text = asistente.nombre + " " + asistente.apellido, modifier = Modifier.weight(1f))

                    IconButton(
                        onClick = {

                            navController.navigate("${Routes.ScreenEditAsistente.route}/$index")
                        },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Icon(Icons.Default.Edit, contentDescription = "Editar")
                    }

                    IconButton(
                        onClick = { listaAsistente.remove(asistente) },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                    }
                }

            }
        }
        Button(
            onClick = { navController.navigate(Routes.ScreenCreateAsistente.route) },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Registrar asistente")
        }
    }
}