package com.example.laboratorio01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.laboratorio01.model.Asistente
import com.example.laboratorio01.navigate.Routes
import com.example.laboratorio01.ui.theme.Laboratorio01Theme
import com.example.laboratorio01.views.ScreenCreateAsistente
import com.example.laboratorio01.views.ScreenEditAsistente
import com.example.laboratorio01.views.ScreenListAsistente

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio01Theme {
                // A surface container using the 'background' color from the theme
                val listAsistentes= remember { mutableStateListOf<Asistente>() }
                val navigationController = rememberNavController()
                NavHost(navController = navigationController, startDestination = Routes.ScreenListAsistente.route){

                    composable(Routes.ScreenListAsistente.route){
                        ScreenListAsistente(navigationController, listAsistentes)
                    }
                    composable(Routes.ScreenCreateAsistente.route){
                        ScreenCreateAsistente(navigationController, listAsistentes)
                    }
                    composable(
                        "${Routes.ScreenEditAsistente.route}/{index}",
                        arguments = listOf(navArgument("index") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val index = backStackEntry.arguments?.getInt("index") ?: 0
                        ScreenEditAsistente(
                            navController = navigationController,
                            listAsistente = listAsistentes,
                            index =index
                        )
                    }


                    }
            }
        }
    }
}

