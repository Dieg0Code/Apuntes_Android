package intro_to_kotlin

fun main(args: Array<String>) {
    val listaDeFrutas = listOf("Manzana", "Pera", "Frambuesa", "Durazno")
    for (fruta in listaDeFrutas) {
        println("Hoy voy a comerme una fruta llamada $fruta")
    }
}