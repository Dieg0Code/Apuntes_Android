const val PI = 3.1416
fun main(args: Array<String>) {
    var dinero: Int = 10
    // con var las variables pueden ser reasignadas
    println(dinero) // 10
    dinero = 5
    println(dinero) // 5

    // variables de solo lectura
    val nombre = "Maria"
    // nombre = "Vanesa"  Error!
    println(nombre)
    println(PI)

    //Booleanos
    val boolean: Boolean = true // o false
    //Long a diferencia de Int soporta una enorme cantidad de números
    val numeroLargo: Long = 3L
    //valores de punto flotante
    val double: Double = 2.7182
    val float: Float = 1.1f

    val primerValor = 20

    //Cadenas de texto
    val apellido = "Obando"
    val miNombre = "Diego"
    //val nombreCompleto = miNombre + apellido
    // println(nombreCompleto) // DiegoObando
    val nombreCompleto = "$miNombre $apellido"
    println(nombreCompleto) // Diego Obando
    val saludo = "Hola!, mi nombre es $miNombre"
    println(saludo)
}