import model.Camera
import model.Movie
import model.Shoe

//var n = 3//Variable global (esta fuera del metodo main), Colocar un var de tipo global es una mala practica.

//val n = 3// val no puede ser reasignado en tiempo de compilacion, pero si puede ser reasignado en tiempo de ejecucion

//const tiempo de compilacion
const val N = "NAME"

//Funciones Puras (hay que tratar que nada altere esta funcion, que un valor externo no la contamine)
fun main(args: Array<String>) {
    println("Hola Mundo")
    println(1 + 1)
    println(3 - 1)
    println(2 * 2)
    println(4 / 2)
    println(7 % 2)

    val a = 4
    val b = 2

    println()
    println()
    println(a.plus(b))
    println(a.minus(b))
    println(a.times(b))
    println(a.div(b))

    //Tiempo de ejecucion.
    val name = args[0]// val es mas usado en variables que estan declaradas de manera local.
    println(name)
    println(N)

    val nombre = "Diego"
    val apellido: String = "Obando" //Para declarar una variable con tipo estricto
    val x : Int = 4

    val nombreapellido = "Diego\nObando"
    println("Tu nombre es: $nombreapellido")

    println("Tu nombre es: $nombre $apellido")//Se puede usar en simbolo $ para concatenar varialbes con Strings

    // Raw String
    val parrafo = """
        ** aksjhdkajdkajbdakjbsdkabsdka
        ** aksdbakdnaksdbakdbaksdbaksdb
        ** aksjdakdnaksdjbakjdbakdbaskd
        ** alksdnlaksndaknsdalksndaksdn
        ** aksjdbakjsbdkasbdkabsdkjasbd.
    """.trimIndent()//.trimIdent() hace que se respeten los saltos de linea en el parrafo

    println(parrafo.trimMargin("** "))//Elimina del parrafo los argumentos que le pasemos

    //Rangos
    val oneToHundred = 1..5
    for (i in oneToHundred) {
        println(i)
    }

    //val aToC = 'A'..'C'
    for (letra in 'A'..'C') {
        println(letra)
    }

    //sentencia If, Operadores Lógios(booleanos true false)
    val numero = 2
    if (numero.equals(2)) { //true
        println("Sí son iguales")
    } else {
        println("No, no son iguales")
    }


    //when - switch
    when(numero) {
        in 1..5 -> println("Si está entre 1 y 5")
        in 1..3 -> print("Si está entre 1 y 3")
        !in 5..10 -> print("No, no está entre 5 y 10")
        else -> print("No esta en ninguno de los anteriores")
    }

    var i  = 1
    //while es usado para manejar contadores
    while (i <= 10) {//false or true
        println("mensaje: $i")
        i++
    }

    i = 1
    do {
        println("mensaje doWhile : $i")
        i++
    } while (i < 1)//en este caso se ejecuta la evaluacion despues


    /*
    try {
        var compute: String?
        compute = null
        var longitud: Int = compute!!.length

    } catch (e: NullPointerException) {
        println("No aceptamos valores nulos")
    }
     */

    //Llamada Segura
    var compute: String? = null
    var longitud: Int? = compute?.length//null
    println("Longitud: $longitud")

    //Operador Elvis
    var teclado: String? = null
    val longitudDeTeclado: Int = teclado?.length ?: 0
    println("Longitud Teclado: $longitudDeTeclado")

    //Lista con Nulls
    val listWithNulls: List<Int?> = listOf<Int?>(7,null,null,4)
    println("Lista con Null: ${listWithNulls}")

    //Filtro de Null's
    val listWithoutNulls: List<Int?> = listWithNulls.filterNotNull()
    println(listWithoutNulls)

    //Array
    val countries = arrayOf("India", "Mexico", "Colombia", "Argentina", "Chile", "Peru")
    //Las variables que sean Arrays por lo general van a ser en plural
    val days = arrayListOf<String>("Lunes", "Martes", "Miercoles")


    val numbers = intArrayOf(1, 2, 3, 4)
    for (num in numbers) {
        println("Numbers: $num")
    }
    



    var arrayObject = arrayOf(1,2,3)
    var intPrimitive : IntArray = arrayObject.toIntArray()

    //sumar
    val suma = arrayObject.sum()//toma todos los datos del array y los suma, luego los asigna a suma
    println("La suma del array es $suma")

    //añadir un elemento más al array
    arrayObject = arrayObject.plus(4)
    for (a in arrayObject) {
        println("Array: $a")
    }

    //Colocar al revés un array y asignarlo  a una variable
    arrayObject = arrayObject.reversedArray()
    for (a in arrayObject) {
        println("Array invertido: $a")
    }

    //Colocar al revés un array a si mismo
    arrayObject.reverse()
    for (a in arrayObject) {
        println("Array invertido 1: $a")
    }

    //Expresiones y valores
    var y = 5
    println("Y es igual a 5? ${y == 5}")//true
    var mensaje = "El valor de y es $y"
    y++
    println("${mensaje.replace("es", "fue")}, y ahora es igual a: $y")

    println("Raiz cuadrada de: ${Math.sqrt(4.0)}")

    val numbers1 = intArrayOf(6,6,23,9,2,3,2)
    println("El promedio de los numeros es: ${averageNumbers(numbers1, 2)}")

    println("${evaluate('+', 2)}")


    //Lambdas
    val saludo = {println("Hola mundo lambda")}
    saludo()

    //var suma = { instrucciones -> sentencias}
    val plus = {a: Int, b: Int, c: Int -> a+b+c}
    val result = plus(3,4,5)
    println(result)
    println(plus(1,2,3))
    println({a: Int, b: Int, c: Int -> a+b+c}(7,8,9))

    val calculateNumber = { n: Int ->
        when(n) {
            in 1..3 -> println("Tu numero esta entre 1 y 3")
            in 4..7 -> println("Tu numero esta entre 4 y 7")
            in 8..10 -> println("Tu numero esta entre 8 y 10")
        }
    }

  calculateNumber(6)


    val camera = Camera()
    camera.turnOn()
    camera.turnOff()
    println(camera.getCameraStatus())

    camera.setResolution(640)
    println("Camera Resolution: ${camera.getResolution()}")


    var shoe = Shoe("shoe", "Blue shoes", 12345, "Praga")
    println("Shoe: ${shoe}")
    shoe.create()





    /*
    shoe.size = 33
    println(shoe.size)
    shoe.model = "Zapatos de Tacón"
    println(shoe.model)

    println(shoe.mark)
    */
    //Data Class Movie
    val movie = Movie("Coco", "Pixar", 120)


    var resultado: Int = calculadora(1,2,3, ::multiplicar)
    println("La calculadora opero una multiplicacion: $resultado")

    println("La resta fue: ${calculadora(4,5,6,::restar)}")
    println("La suma fue: ${calculadora(4,5,6,::sumar)}")

}

fun calculadora(a: Int, b: Int, c: Int, operacion:(Int, Int, Int)  -> Int): Int {
    return operacion(a, b, c)
}

fun sumar(a: Int, b: Int, c: Int) = a + b + c
fun restar(a: Int, b: Int, c: Int) = a - b - c
fun multiplicar(a: Int, b: Int, c: Int) = a * b * c


fun evaluate(character : Char = '=', number : Int = 2): String {
    return "${number} es ${character}"
}


fun averageNumbers(numbers: IntArray, n : Int): Int {
    //Promedio de lo numeros

    var sum = 0
    for (num in numbers) {
        sum += num
    }

    return (sum / numbers.size) + n
}


/*
fun averageNumbers(numbers:IntArray):Int{
    val sumas = numbers.sum()
    return sumas.div(numbers.size)
}

println("\nEl promedio de los números es: ${averageNumbers(intArrayOf(1,2,5,3,2,1))}")
 */