package intro_to_kotlin

fun main(args: Array<String>) {
    val fraseAleatoria = "La frase mas bacán del multiverso".randomCase()
    imprimirFrase(fraseAleatoria)
}

// devuelve Unit
fun imprimirFrase(frase: String) {
    println("Tu frase es: $frase")
}

// Las funciones hay que declararlas fuera
fun String.randomCase(): String {
    val numeroAleatorio = 0..99
    val resultadoAleatorio = numeroAleatorio.random()
    return if (resultadoAleatorio.rem(2) == 0) {
        this.toUpperCase()
    } else {
        this.toLowerCase()
    }
}