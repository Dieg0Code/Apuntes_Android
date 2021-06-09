fun main() {
    init()
}

fun init() {
    println(
            """|:: Welcome to Recipe Market ::
           |Selecciona la opcion deseada
           |1. Hacer una receta
           |2. Ver mis recetas
           |3. Salir """.trimMargin()
    )
    val response: String? = readLine()
    option(response)

}

fun option(response: String?) {
    when (response) {
        "1" -> {
            println(makeRecipe())
            val makeResponse: String? = readLine()
            if (makeResponse != null) category(makeResponse)

        }
        "2" -> {
            println(viewRecipe())
            val backResponse: String? = readLine()
            if (backResponse == "1") init() else {
                println("Opcion invalida")
            }
        }
        "3" -> {
            println("Cerrando")
        }
        else -> {
            println("Elija una opcion valida")
            val invalidateResponse: String? = readLine()
            option(invalidateResponse)
        }
    }
}

fun category(category: String?) {
    when (category) {
        "1" -> println("Seleccionado Aguar")
        "2" -> println("Seleccionado Leche")
        "3" -> println("Seleccionado Carne")
        "4" -> println("Seleccionado Verduras")
        "5" -> println(
                """
    1. Fresa
    2. Plátano
    3. Uvas
    4. Manzana
    5. Naranja
    6. Pera
    7. Cereza
""".trimMargin()
        )
        "6" -> println(
                """
    1. Avena
    2. Trigo
    3. Arroz
    4. Maiz
""".trimMargin()
        )
        "7" -> println("Seleccionado Huevos")
        "8" -> println("Seleccionado Aceite")
        else -> {
            println("Elija una opcion valida")
            val categoryResponse: String? = readLine()
            category(categoryResponse)
        }
    }
}

fun makeRecipe(): List<String> {
    return listOf(
            """Hacer receta
         Selecciona por categoría del ingrediente que buscas
        1. Agua
        2. Leche
        3. Carne
        4. Verduras
        5. Frutas
        6. Cereal
        7. Huevos
        8. Aceites""".trimMargin()
    )
}

fun viewRecipe(): String = """
    Estas mirando las recetas
    
    1. Volver
""".trimIndent()