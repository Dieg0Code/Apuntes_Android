package intro_to_kotlin

fun main(args: Array<String>) {
    var nombre: String? = null
    // al lado derecho va el valor por defecto que se asignará en caso de que sea nulo
    var caracteresDeNombre: Int = nombre?.length ?: 0 // return 0 porque la variable nombre es nula
}