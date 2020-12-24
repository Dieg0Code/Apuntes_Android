fun main (args: Array<String>) {

    fun makeRecipe() = {
        println("""
            Selecciona por categoría el ingrediente que buscas
            1. Agua
            2. Leche
            3. Carne
            4. Verduras
            5. Frutas
            6. Cereal
            7. Huevos
            8. Aceites""".trimIndent()
        )
    }

    fun viewRecipe() = println("Ver mis recetas")

    val bienvenida = "Bienvenido a Recipe Maker"
    val menu = """
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
    """.trimIndent()

    val listaDeIngredientes =
            listOf("Agua","Leche","Carne","Verduras","Frutas","Cereal","Huevos","Aceite")

    /*for(ingrediente in listaDeIngredientes){
        println(ingrediente)
    }*/

    /*for((index,ingrediente) in listaDeIngredientes.withIndex()){
        println("$index: $ingrediente")
    }*/

    val response: String? = readLine()

    fun menuPrincipal() {
        println("¿Qué quieres hacer hoy? \n$menu")
        when (response) {
            "1" -> {makeRecipe()}
            "2" -> {viewRecipe()}
            "3" -> println("¡Nos vemos pronto!")
            else -> println("elegiste una opción inválida")
        }
    }

    println(bienvenida)
    menuPrincipal()

}