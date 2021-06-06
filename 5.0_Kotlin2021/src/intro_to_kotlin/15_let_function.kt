package intro_to_kotlin

fun main(args: Array<String>) {
    var nombre: String? = null
    // se ejecuta cuando la variable nullable no es nula
    nombre?.let { valor ->
        println("el nombre no es nulo, es $valor")
    }
    nombre = "Diego"
    nombre.let { valor ->
        println("El nombre no es nulo, es $valor")
    }
}