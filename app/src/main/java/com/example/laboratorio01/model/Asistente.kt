package com.example.laboratorio01.model

data class Asistente(
    var nombre: String="",
    var apellido:String = "",
    var fechaInscripcion: String = "",
    var tipoSangre: String = "",
    var telefono: String = "",
    var correo: String = "",
    var montoPagado: Double = 0.0
)
