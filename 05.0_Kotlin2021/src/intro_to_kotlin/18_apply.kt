package intro_to_kotlin

fun main(args: Array<String>) {
    // lo mismo que la function run pero sin el this
    val moviles = mutableListOf("Google Pixel 2xl", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3").apply {
        removeIf { movil -> movil.contains("Google") }
    }
    println(moviles)
    // la función apply puede también funcionar como el with, solo que esta acepta nullables

    val colores: MutableList<String>? = mutableListOf("Amarillo", "Azul", "Rojo") // las listas pueden ser nulas completas o tener valores nulos dentro
    colores?.apply {
        println("Nuestros colores son $this")
        println("La cantidad colores es $size")
    }
}