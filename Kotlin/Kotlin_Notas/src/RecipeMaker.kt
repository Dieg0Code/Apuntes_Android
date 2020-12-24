fun main() {
    println("************/  :: BIENVENIDO A RECIPE MAKER ::   /***********")
    println("************/   Selecciona la opcion deseada   /***********")
    println("""
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
    """.trimIndent())
    print("¿Que deseas hacer hoy?: ")
    val option: String? = readLine().toString()

    when (option){
        "1" -> println("Vamos a cocinar")
        "2" -> println("Vamos a ver mis recetas")
        "3" -> println("Vuelve pronto")
        else -> println("Esa opcion no existe!! intenta de nuevo.")
    }
}