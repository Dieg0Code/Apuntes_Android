package intro_to_kotlin

fun main(args: Array<String>) {
    // es un código que no se ha ejecutado y que cuando lo ejecutas puedes obtener su valor
    val myLambda: (String) -> Int = { valor -> // it es el valor que estamos pasando a la lambda
        valor.length
    }   // devuelve un Int, el cual es el length del String que le pasemos
    val lambdaEjectutada: Int = myLambda("Hola Kbroz") // ejecuta la lambda
    println(lambdaEjectutada)

    val saludos = listOf("Hello", "Hola", "ni hao")
    val longitudDeSaludos = saludos.map(myLambda)
    println(longitudDeSaludos)
}