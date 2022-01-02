package intro_to_kotlin

fun main(args: Array<String>) {
    val largoDelValorInicial = superFuncion(valorInicial = "Hola!") { valor ->
        valor.length
    }
    println(largoDelValorInicial)

    val lambda: () -> String = funcionInception("Diego")
    val valorLambda: String = lambda()
    println(valorLambda)
}

// Kotlin recomienda que llamemos block a la lambda cuando es pasada como parametro
fun superFuncion(valorInicial: String, block: (String) -> Int): Int {
    return block(valorInicial)  //  para obtener el valor de una lambda debemos pasarle un parámetro
    // cuando se usan las lambdas como parámetro de una función se deben dejar en la ultima posición
    // porque esto nos permite sacar la lambda fuera de la función
}

fun funcionInception(nombre: String): () -> String { // esta función devuelve una lambda, que devuelve una String
    return {
        "Hola desde la lambda $nombre"
    }
}