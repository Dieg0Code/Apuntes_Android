package intro_to_kotlin

fun main(args: Array<String>) {
    var contador = 10
    while (contador > 0) {
        println("El valor de contador es $contador")
        contador--  //  Valor actual menos 1
    }

    do {
        println("Generando un numero aleatorio...")
        val numeroAleatorio = (0..100).random()
        println("El numero generado es $numeroAleatorio")
    } while (numeroAleatorio > 50)
}