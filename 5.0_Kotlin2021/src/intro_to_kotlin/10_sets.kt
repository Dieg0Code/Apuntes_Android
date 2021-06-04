package intro_to_kotlin

fun main(args: Array<String>) {
    // los sets al igual que los ademas collections, también hay de tipo mutable e inmutable

    // inmutables
    val vocalesRepetidas = setOf("a", "e", "i", "o", "u", "a", "e", "i", "o", "u")
    println(vocalesRepetidas)
    // los sets solo tienen en consideración la primera variable si es que está repetida
    // se parecen mucho a las listas pero esta no permite dos elementos iguales
    // es muy util cuando quieres eliminar duplicados de una lista

    // mutables
    val numerosFavoritos = mutableSetOf(1, 2, 3, 4)
    println(numerosFavoritos)
    // para agregar elementos
    numerosFavoritos.add(5)
    println(numerosFavoritos)

    // para eliminar elementos
    // no tenemos un index ya que los sets no tienen un orden en especifico
    // esto hace que no los podamos obtener tan fácilmente como en las listas y en los hashmap
    println(numerosFavoritos)
    // en los sets se elimina el elemento dependiendo del valor, en las listas se elimina dependiendo de la posición
    numerosFavoritos.remove(5)
    println(numerosFavoritos)

    // para obtener el valor de un elemento en un set
    val valorDelSet = numerosFavoritos.firstOrNull { numero -> numero > 2 }
    println(valorDelSet)
}