package intro_to_kotlin

fun main(args: Array<String>) {
    val listaDeNombres = listOf("Juan", "Enrique", "Camila")// esta lista no puede ser modificada
    println(listaDeNombres)

    val listaVacia = mutableListOf<String>() // esta lista si puede ser modificada
    println(listaVacia)

    listaVacia.add("Diego")
    println(listaVacia)

    // Para obtener un valor de una lista se puede hacer de dos formas

    val valorUsandoGet = listaVacia.get(0)
    println(valorUsandoGet)

    val valorUsandoOperador = listaVacia[0]
    println(valorUsandoOperador)

    // Existen muchas formas en Kotlin para obtener el valor de una lista

    val primerValor = listaDeNombres.first() // obtiene el primer valor y lo devuelve
    // también se puede pasar como parámetro una condición para obtener el primer elemento que cumpla con esa condición
    println(primerValor)
    // este operador hay que tenerlo en cuenta porque aunque imprima igual que los otros dos
    // puede que no encuentre el primer elemento de la lista y de una excepción.
    // En ese caso es mas recomendable usar el firstOrNull()

    val primerValorOrNull: String? = listaDeNombres.firstOrNull()
    println(primerValorOrNull)

    // busca el primer elemento y en caso de que la lista esté vacía devolverá un string nullable

    // Para eliminar elementos
    listaVacia.removeAt(0)
    println(listaVacia)

    listaVacia.add("Enrique")
    println(listaVacia)
    listaVacia.removeIf { carateres -> carateres.length > 3 } // remueve cuando la condición dentro de las llaves sea verdadera
    println(listaVacia)

    //Arrays
    val myArray = arrayOf(1, 2, 3, 4)
    println("Nuestro array $myArray")
    println("Array como lista ${myArray.toList()}") // convertimos el array a una lista para poder imprimirlo
}