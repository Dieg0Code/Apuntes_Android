package proyect


// Declaramos los valores de nuestras respuestas
const val RESPUESTA_AFIRMATIVA = "✅"
const val RESPUESTA_NEGATIVA = "❌"
const val RESPUESTA_DUDOSA = "?"

// unimos las respuestas con los valores
val respuestas = mapOf(
    "Sí" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "sin duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_NEGATIVA,
)

fun main(args: Array<String>) {

    while (true) {
        println(
            """
        "Hello, I'm the Kotlin 8 ball. What do you want to do?"
        1. Ask something
        2. Check answers
        3. Exit
    """.trimIndent()
        )
        val input = readLine()

        /*
        * Al usar los 3 pares de " y la función trimIndent() podemos escribir de manera un poco mas natural con los saltos
        *  de linea, y evitamos ejecutar println() cada vez.
        * */

        when (input) {
            "1" -> askSomething()
            "2" -> showAnswers()
            "3" -> {
                exit()
                break
            }
            else -> showError()
        }
        println()
    }
}

fun showError() {
    println("Vaya parece que has elegido una opción no valida, intenta de nuevo")
}

fun exit() {
    println("Hasta luego!")
}

fun showAnswers() {
    println(
        """
        Selecciona una opción
        1. Revisar todas las respuestas
        2. Revisar solo las respuestas afirmativas
        3. Revisar solo las respuestas dudosas
        4. Revisar solo las respuestas negativas
    """.trimIndent()
    )

    val input = readLine()
    when (input) {
        "1" -> showAnswersByType()
        "2" -> showAnswersByType(answerType = RESPUESTA_AFIRMATIVA)
        "3" -> showAnswersByType(answerType = RESPUESTA_DUDOSA)
        "4" -> showAnswersByType(answerType = RESPUESTA_NEGATIVA)
        else -> println("Respuesta no valida. Adios.")
    }
}

fun showAnswersByType(answerType: String = "TODOS") {

    val printAnswers: (Map<String, String>) -> Unit = {
        it.keys.forEach { answer -> println(answer) }
    }

    when (answerType) {
        "TODOS" -> respuestas.keys.forEach { respuesta -> println(respuesta) }

        RESPUESTA_AFIRMATIVA -> respuestas.filterValues { values -> values == RESPUESTA_AFIRMATIVA }
            .also { printAnswers(it) }

        RESPUESTA_NEGATIVA -> respuestas.filterValues { values -> values == RESPUESTA_NEGATIVA }
            .also { printAnswers(it) }

        RESPUESTA_DUDOSA -> respuestas.filterValues { values -> values == RESPUESTA_DUDOSA }
            .also { printAnswers(it) }
    }
}

fun askSomething() {
    println("Que pregunta deseas realizar?")
    readLine()
    println("Asi que esa era  tu pregunta... La respuesta a eso es:")
    val generatedResponse = respuestas.keys.random()
    println(generatedResponse)
}