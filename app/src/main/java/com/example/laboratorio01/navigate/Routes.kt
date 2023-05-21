package com.example.laboratorio01.navigate

sealed class Routes( val route: String){
    object ScreenCreateAsistente:Routes("screenCreate")
    object ScreenEditAsistente:Routes("screenEdit")
    object ScreenListAsistente:Routes("screenList")
}
