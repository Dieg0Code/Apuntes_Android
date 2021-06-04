package intro_to_kotlin

fun main(args: Array<String>) {
    // parámetros nombrados
    imprimirNombre(nombre = "Diego", apellido = "Obando") // con parámetros nombrados
    // Esto es de mucha ayuda y es una buena practica hacerlo cuando tienes una función que recibe como parámetro
    // dos parámetros del mismo tipo en este caso dos Strings
}

// parámetros por defecto
fun imprimirNombre(nombre: String, segundoNombre: String = "segundo nombre", apellido: String) {
    println("Mi nombre completo es $nombre $segundoNombre $apellido")
}