package intro_to_kotlin

fun main(args: Array<String>) {
    // son una estructura de datos del tipo clave - valor
    // para cada clave existe un valor
    // un valor puede pertenecer a varias claves, pero solo puede existir una clave del mismo tipo

    // mapOf() crea mapas inmutables
    val edadDeSuperHeroes = mapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )
    println(edadDeSuperHeroes)

    // mutableMapOf() crea mapas mutables
    val edadDeSuperHeroesMutable = mutableMapOf(
        "IronMan" to 35,
        "SpiderMan" to 23,
        "Capitan America" to 99
    )
    println(edadDeSuperHeroesMutable)

    // para agregar un elemento
    edadDeSuperHeroesMutable.put("Wolverine", 45)
    println(edadDeSuperHeroesMutable)

    edadDeSuperHeroesMutable["Storm"] = 30
    println(edadDeSuperHeroesMutable)

    // para obtener un valor de un map
    // no modifica el valor del map por lo que se puede usar con mutables e inmutables

    val edadIronMan = edadDeSuperHeroesMutable["IronMan"]
    println(edadIronMan)

    // para eliminar un elemento de un map
    edadDeSuperHeroesMutable.remove("Wolverine")
    println(edadDeSuperHeroesMutable)

    // para ver las keys de un map
    println(edadDeSuperHeroesMutable.keys)

    // para ver los valores de un map
    println(edadDeSuperHeroesMutable.values)
}