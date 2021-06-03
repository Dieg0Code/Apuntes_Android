package intro_to_kotlin

fun main(args: Array<String>) {
    val numerosDeLoteria = listOf(11, 22, 43, 56, 78, 66)
    println(numerosDeLoteria)

    // funciones para ordenar listas
    val numerosSorted = numerosDeLoteria.sorted()
    println(numerosSorted)

    val numerosDeLoteriaDescendientes = numerosDeLoteria.sortedDescending()
    println(numerosDeLoteriaDescendientes)

    val ordenarPorMultiplos =
        numerosDeLoteria.sortedBy { numero -> numero < 50 } // los numero que sean mayor a 50 van de primero y los que sean menores a 50 van de últimos

    val numerosAleatorios = numerosDeLoteria.shuffled() // ordena la lista aleatoriamente
    println(numerosAleatorios)

    val numeroEnReversa = numerosDeLoteria.reversed()
    println(numeroEnReversa)

    // funciones usadas en programación funcional
    // map: nos permite convertir un elemento de un tipo a otro tipo
    val mensajesDeNumeros = numerosDeLoteria.map { numero -> "Tu numero de lotería es $numero" }
    println(mensajesDeNumeros) // convertimos una lista de enteros a una lista de strings


    // filter: nos permite filtrar elementos dependiendo de la condición que le pasemos
    val numerosFiltrados = numerosDeLoteria.filter { numero -> numero > 50 }
    println(numerosFiltrados)
}