package intro_to_kotlin

fun main(args: Array<String>) {
    val moviles = mutableListOf("Google Pixel 2xl", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .run {
            removeIf { movil -> movil.contains("Google") }
            this
        }
    println(moviles)
}