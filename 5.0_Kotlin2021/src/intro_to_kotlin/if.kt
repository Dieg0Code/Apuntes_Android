package intro_to_kotlin

fun main(array: Array<String>) {
    val nombre = "Diego"

    // isNotEmpty es una función para todas las Strings, devuelve un booleano
    if (nombre.isNotEmpty()) {
        println("El largo de nuestra variable nombre es ${nombre.length}")
    } else {
        println("Error, la variable esta vacía")
    }

    val mensaje: String = if (nombre.length > 4) {
        "Tu nombre es largo"
    } else if(nombre.isEmpty()) {
      "nombre esta vacío"
    } else {
        "Tienes un nombre corto"
    }
    println(mensaje)
}