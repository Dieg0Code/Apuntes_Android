package intro_to_kotlin

fun main(args: Array<String>) {
    val nombreColor = "Carmesi"

    when (nombreColor) {
        "Amarillo" -> println("El amarillo es el color de la alegría")
        "Rojo", "Carmesi" -> println("Este color simboliza el calor")
        else -> println("Error no tengo información del color $nombreColor")
    }

    val code = 200
    when (code) {
        in 200..299 -> println("Código entre 200 y 299")
        in 400..500 -> println("Código entre 400 y 500")
        else -> println("Código desconocido, algo ha fallado")
    }

    val tallaDeZapatos = 41
    val mensaje: String = when (tallaDeZapatos) {
        41,43 -> "Tenemos disponible"
        42,44 -> "Casi no quedan"
        45 -> "Lo siento no tenemos disponible"
        else -> "No hay de esa talla"
    }
    println(mensaje)
}