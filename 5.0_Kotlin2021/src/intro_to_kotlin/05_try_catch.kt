package intro_to_kotlin

fun main(args: Array<String>) {
    var nombre: String? = null
    try {
        throw NullPointerException("Referencia nula")
    } catch (exception: NullPointerException) {
        println("Ha ocurrido un error")
    } finally {
        println("Finalmente ha ocurrido un error... Cerrando aplicación")
    }

    val primerValor = 10
    val segundoValor = 0

    //  Podemos asignar un try-catch a un variable
    val resultado: Int = try { primerValor / segundoValor } catch (exception: Exception) { 0 }
    println(resultado)
}