# Notas del lenguaje Kotlin

## Qué es Kotlin

Kotlin es desarrollado por Jetbrains, Jetbrains es una compañía que crea entornos de desarrollo com Intelij idea por
ejemplo, siendo este el que se utiliza como base para android studio.

Kotlin nació en el 2010 sin embargo, es bastante maduro y la base del desarrollo en Android hoy en dia.

### No solo se utiliza en Android

Se utiliza también en:

- Backend development.

Con frameworks como Spring, Micronaut o Ktor.

- De forma nativa.

Puede correr en Windows y otras plataformas de forma nativa.

### Kotlin surge de la necesidad de Java.

Era necesario una alternativa a Java. Con sintaxis moderna, nuevas funcionalidades y capaz de ser interoperable con
Java. Podemos ir migrando poco a poco de Java a Kotlin hasta que nuestro proyecto sea completamente de Kotlin.

### La adopción en Android

Es el lenguaje recomendado para desarrollar app de Android y esto se debe a las limitantes que tiene Java.

## ¿Que es la Java Virtual Machine?

Una virtual machine es una virtualización o simulación de un sistema operativo o de los procesos que ocurren dentro de
este. En nuestro caso, la Java Virtual Machine pertenece al segundo tipo y se encarga de simular los procesos que
ocurren dentro de un sistema operativo. A este tipo de máquinas virtuales se les llama Process Vitual Machines.

### ¿Que ventajas nos da?

Nos ayuda a manejar los punteros y las referencias de memoria que en otros tipos de lenguaje como c o c++ hay que
manejar manualmente. Para esto se utiliza un proceso llamado garbage collection. Este proceso se encarga de revisar qué
referencia de memoria no se está utilizando para eliminarla y así reducir la cantidad de memoria que puede consumir un
programa.

### ¿Como funciona la JVM?

La JVM funciona como un punto medio entre el código que nosotros escribimos y lo que entiende el sistema operativo del
ordenador. Dependiendo del sistema operativo que uses puede variar. La JVM nos ayuda a que nuestro código se ejecute en
Linux, Windows y MacOs. Nuestro código es convertido por la JVM a un leguaje que puede entender el sistema operativo
llamado Java Bytecode.

En palabras más simples, nosotros ingresamos código de Kotlin y se transforma en Bytecode. Este proceso puede ocurrir
con otros lenguajes como Java, esto hace que nuestro código de Kotlin pueda ser utilizado desde Java y el código de Java
pueda ser utilizado en Kotlin.

### Bytecode vs lenguaje ensamblador

Bytecode es similar a lenguaje ensamblador en que no es un lenguaje de alto nivel, pero todavía es algo legible, a
diferencia del lenguaje de máquina. Ambos pueden considerarse “lenguajes intermedios” que se encuentran entre el código
fuente y el código de máquina. La principal diferencia entre los dos es que el código de bytes se genera para una
máquina virtual (programa.), mientras que el lenguaje ensamblador se crea para un CPU (hardware).

## Hola Mundo con Kotlin

```kotlin
fun main(args: Array<String>) {
    println("Hello World!")
}
```

Como en cualquier lenguaje la **función main** es el punto de entrada del proyecto.

## Variables en Kotlin

Las variables sirven para almacenar datos temporales y utilizarlos a lo largo de nuestro código. Son información
almacenada en la memoria RAM.

### Tipos de variables

- **var**: Son variables de lectura y escritura, en estas variables el valor que contienen puede cambiar.
- **val**: Son variables de solo lectura, dichas variables una vez asignado el valor no puede ser cambiado
  posteriormente.
- **const**: Es una variable de solo lectura, estas se definen fuera de la función y se escriben con la palabra
  reservada `const` seguida de la palabra reservada `val`, este tipo de variables son usadas para valores que nunca
  cambian.

En Kotlin no se pude cambiar el tipo de dato con que se a definido una variable, si la variable se definió con el tipo
de dato String solo podremos actualizar dicho valor por otro String, por ejemplo no podemos pasar de un String a un
numero.

```kotlin
// Constantes, de solo lectura
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
}
```

La variable de solo lectura **const** a diferencia de **val**, se generan antes de compilar la aplicación, esto quiere
decir que Kotlin antes de que le demos al botón verde ya sabe que esa variable no va a cambiar a diferencia de **val**
en donde espera a que el código se vaya ejecutando y luego le asigna un valor y lo imprime, eso se llama declarar en
tiempo de compilación, a diferencia de **val** que esta declarada en tiempo de ejecución.

Otros tipos de datos en Kotlin:

```kotlin
// Constantes, de solo lectura
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
```

### Modificadores y tipos de datos en Kotlin

#### ¿Que es un tipo de dato?

Los enteros, las cadenas de texto, los booleanos. El tipo de valor que van a tener nuestras variables

#### ¿Que es un objeto?

Un objeto es una combinación de variables, funciones y otros objetos

### En Kotlin todo es un objeto

Kotlin trae por defecto objetos, que parecen primitivos, pero no lo son.

String, Int, Boolean.

#### Ventajas de tratar como objetos

Posibilidad de crear funciones específicas para ese tipo de objeto.

Poder sobreescribir operadores como la suma para sumar dos objetos del mismo tipo.

Extender del lenguaje para crear nuevas funciones que permitan a tu equipo evitar repetir código y mantener una base de
código saludable.

#### Retrocompatibilidad con Java

Debido a que Kotlin tiene que compilar el código que nosotros escribimos y hacerlo interoperable con Java. Debe seguir
algunas reglas.

Un entero puede ser nulo, no se convertirá a primitivo. Pero un entero que no puede ser nulo, se convertirá a primitivo.

## Operaciones con los tipos de datos en Kotlin

En Kotlin las operaciones son traducidas a funciones interiormente por el compilador. La
operación `val tercerValor = primerValor + segundoValor` es lo mismo que
decir `tercerValor = primerValor.plus(segundoValor)`.

En la siguiente tabla te voy a dejar las operaciones que vas a poder realizar con los distintos tipos de datos y si te
encuentras con alguno que no permita relizar esa operación puedes crearla por tu cuenta. Recuerda que Kotlin te permite
extender el lenguaje para aprovechar estas funcionalidades.

### Operaciones mas utilizadas

| Expresión | Función | Operator Fun |
| :-------: | :-----: | :----------: |
| a + b     | c = a - b | public operator fun plus(other: Int): Int |
| a - b     | c = a - b | public operator fun minus(other: Int): Int |
| a * b     | c = a * b | public operator fun times(other: Int): Int |
| a / b     | a = a / b | public operator fun div(other: Int): Int |
| a % b     | c = a % b     | public operator fun rem(other: Int): Int |
| a++       | c = a++ | public operator fun inc(): Int |
| a–        | c = a– | public operator fun dec(): Int |
| a > b     | c = a > b | public override operator fun compareTo(other: Int): Int |
| a < b     | c = a < b | public override operator fun compareTo(other: Int): Int |
| a >= b    | c = a >= b | public override operator fun compareTo(other: Int): Int |
| a <= b    | c = a <= b | public override operator fun compareTo(other: Int): Int |
| a != b    | c = a != b | public open operator fun equals(other: Any?): Boolean |

Dependiendo del tipo de dato que tengas podrás utilizar todos o solamente algunas de estas operaciones, por ejemplo si
tienes una variable del tipo de dato **String** no vas a poder dividirla, a menos que tú crees esa función. Sin embargo,
sí vas a poder sumar dos variables del tipo de dato **String** para obtener el valor de dicha suma.

Con esto espero que hayas obtenido una idea sobre cómo funcionan las operaciones, queda de parte de ti si prefieres
utilizar la verión larga del **operador fun** o el operador directamente.

Ten en cuenta que si las **operator fun** se inventaron para que puedas reducir ti código a operaciones con símbolos
¿por algo será, no?

## Kotlin y la programación funcional

### Paradigmas de programación

Existen varias formas de escribir código y estas formas son llamadas **paradigmas**

#### Paradigma imperativo

Este paradigma se basa en modificar el estado de tu programa modificando estados dentro del mismo. Se centra en
describir cómo funciona un programa

#### Programación funcional

- Es un paradigma de programación declarativo.
- Expresa la lógica de un programa sin describir lo que hace.
- Se enfoca en lo que el programa debe hacer no en cómo se hace.

Koltin no es un lenguaje de programación funcional 100% como Haskell o Scala. Pero tiene varios conceptos que nos
ayudarán a sacarle mayor provecho a Kotlin

#### Nunca mutable siempre inmutable

Un elemento es mutable cuando puede cambiar, inmutable cuando no. Es recomendable usar variables de solo lectura y
estructuras de datos no mutables.

#### Las funciones son objetos

Las funciones pueden almacenarse en variables, pasarse como parámetros y tratarse como cualquier otro objeto.

#### Usa funciones puras

Recibe siempre los mismos parámetros y devuelve siempre el mismo resultado.

No puede verse afectada por elementos fuera de su entorno.

## Estructuras de control: if

Las estructuras de control nos permiten ejecutar código dependiendo de una condición.

```kotlin
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
    } else if (nombre.isEmpty()) {
        "nombre esta vacío"
    } else {
        "Tienes un nombre corto"
    }
    println(mensaje)
}
```

## Estructuras de control: when

when nos ayuda a en lugar de tener varios if para comparar varias condiciones comparar con una sola condición y ejecutar
varios códigos dependiendo del resultado de esa condición.

```kotlin
fun main(args: Array<String>) {
    val nombreColor = "Carmesi"

    when (nombreColor) {
        "Amarillo" -> println("El amarillo es el color de la alegría")
        "Rojo", "Carmesi" -> println("Este color simboliza el calor")
        else -> println("Error no tengo información del color $nombreColor")
    }

    val code = 200
    when (code) {
        in 200..299 -> println("Código entre 200 y 299")
        in 400..500 -> println("Código entre 400 y 500")
        else -> println("Código desconocido, algo ha fallado")
    }

    val tallaDeZapatos = 41
    val mensaje: String = when (tallaDeZapatos) {
        41, 43 -> "Tenemos disponible"
        42, 44 -> "Casi no quedan"
        45 -> "Lo siento no tenemos disponible"
        else -> "No hay de esa talla"
    }
    println(mensaje)
}
```

## Bucles: While y Do While

El ciclo **while**, se ejecutará mientras se cumpla la condición especificada

```kotlin
fun main(args: Array<String>) {
    var contador = 10
    while (contador > 0) {
        println("El valor de contador es $contador")
        contador--  //  Valor actual menos 1
    }
}
```

Mientras que el ciclo **do-while** se ejecuta primero y luego verifica la condición

```kotlin
fun main(args: Array<String>) {
    do {
        println("Generando un numero aleatorio...")
        val numeroAleatorio = (0..100).random()
        println("El numero generado es $numeroAleatorio")
    } while (numeroAleatorio > 50)
}
```

## Ciclos

### Ciclo for

El ciclo **for** nos permite ejecutar un código para cada elemento de la lista que creamos.

A diferencia de java el ciclo **for** en kotlin puede ser mucho más sencillo.

```kotlin
fun main(args: Array<String>) {
    val listaDeFrutas = listOf("Manzana", "Pera", "Frambuesa", "Durazno")
    for (fruta in listaDeFrutas) {
        println("Hoy voy a comerme una fruta llamada $fruta")
    }
}
```

También podemos eliminar las llaves y dejar todo el ciclo en una sola línea.

```kotlin
fun main(args: Array<String>) {
    val listaDeFrutas = listOf("Manzana", "Pera", "Frambuesa", "Durazno")
    for (fruta in listaDeFrutas) println("Hoy voy a comerme una fruta llamada $fruta")
}
```

Asi se ve mas elegante.

### forEach

Es un ciclo que se va a ejecutar N cantidad de veces, mientras exista un elemento en la lista

```kotlin
listaDeFrutas.forEach { fruta -> println("Hoy voy a comerme una fruta nueva, se llama $fruta") }
```

### map

Para no tener que estar creando un **for** y estar agregando elementos constantemente a una nueva lista, podemos
convertir la lista de frutas directamente a una lista de enteros que contenga el largo de caracteres de cada fruta
utilizando la función **map**.

```kotlin
val caracteresDeFruta: List<Int> = listaDeFrutas.map { fruta -> fruta.length }
```

### filter

Nos permite filtrar los elementos que cumplan con una condición

```kotlin
val listaFiltrada = caracteresDeFruta.filter { largoDeFruta -> largoDeFruta > 5 }
```

## Null-Safety en Kotlin

El null-safety es uno de los valores primordiales de kotlin que hay que tener mucho en cuenta.

### Tipos

Si tenemos un boolean, tenemos dos posibles valores, **true** o **false**. Pero qué ocurre si te digo que puede existir
un **tercer valor** el **null**.

### La nada o el null

Existe un elemento llamado **null** que indica que el contenido de nuestra variable no existe, que está apuntando a una
referencia de memoria que no existe.

Esto es un problema común en java porque existe algo que se llama referencia nula, esto quiere decir que hay una
variable que no se le ha asignado ningún valor y por ende está apuntando a un sitio que no tiene ningún valor.

### El origen del boolean de tres valores

Un booleano puede tener solo dos valores true o false. Pero un boolean nullable, aquel que puede ser nulo, tiene
tres, **true**, **false** o **null**.

Esto suele pasar en Java, en la respuesta de servidores y en código escrito con malas prácticas.

### El origen de la nada

La referencia nula o null pointer. Fue creada por **Sir Tony Hoare** en 1965.

En 2009 contó en una charla que fue un error haber creado el **null** y que fue una solución rápida que no evolucionó
muy bien.

### ¿Cómo nos ayuda Kotlin?

Kotlin da herramientas para detectar cuando una variable es nula, agregando el tipo nullable. Con esto el compilador es
capaz de advertirnos que parte puede fallar debido a una referencia nula.

Por defecto, todas las variables en Kotlin son non-nullable. De este modo, si intentamos asignar un valor null a
cualquier variable, el compilador lanzará un error:

```kotlin
var saludoNullable: String? = "Hola"
saludoNullable = null // Compila
```

Si queremos permitir que una variable pueda ser null, tendremos que definirla añadiendo "?" a su tipo de dato.

## Valores nulos, Double bang y cómo solucionarlos

### Los null no son malos, son incomprendidos

Como toda herramienta puede ser mal utilizada o bien utilizada.

### Como declaramos un tipo que puede ser nulo

Para esto debemos utilizar el símbolo de interrogación después del tipo de dato que queremos utilizar.

Ej:

````kotlin
var segundoNombre: String? = "Matías"
````

### El compilador es tu amigo no tu enemigo

El compilador es capaz de interpretar estos tipos. Y advertirnos de lo que puede ocurrir al correr nuestro programa.

### Crea código para otros

Crea código como si tuvieras que trabajar en ello dentro de un año. Esto te ayudará a pensar en una solución a futuro y
no solo en complacer al compilador.

### La regla de los Boy Scout

Deja siempre el código mejor que lo encontraste.

### Safe calls

Las safe calls son una herramienta del lenguaje que nos ayuda a ejecutar un código cuando una variable del tipo nullable
no es nula.

````kotlin
println(segundoNombre?.length()) // imprime solo cuando la variable sea no nula
````

### Double bang

Este operador se indica con dos símbolos de exclamación !!.

Con esto le dices al compilador que sabes que en este punto la variable no puede ser nula.

La recomendación es que se utilice lo menos posible porque son considerados malas prácticas.

Cuando pienses que algo no puede ser nulo, probablemente lo sea (ley de murphy).

### Gran poder, gran responsabilidad

No está bien usarlo siempre para que tu código compile y ya. Úsalo solo cuando sea necesario y sepas que esta variable
no será nula en este punto.

### Interoperabilidad con Java

Al ejecutar código escrito por otras personas en Java desde Kotlin. Puede que te encuentres con estos tipos de
variable: **Integer!**. Esto significa que el tipo de dato no puede ser verificado por Kotlin para que te diga si puede
ser nullable o no, es una especie de advertencia para que tengas cuidado y para que conviertas eso a un nullable, porque
Kotlin no puede decirte si va a ser nullable o no, ya que depende de Java y en Java no tenemos ese null-safety.

Los tipos **Integer!** son la forma que tiene Kotlin de avisarte que no puede asegurarse de que ese código **no**
devuelve null. Como recomendación siempre trátalos como nullables.

## Try Catch

El try-catch es usado para capturar posibles errores en el código

````kotlin
fun main(args: Array<String>) {
    var nombre: String? = null
    try {
        throw NullPointerException("Referencia nula")
    } catch (exception: NullPointerException) {
        println("Ha ocurrido un error")
    } finally {
        println("Finalmente ha ocurrido un error... Cerrando aplicación")
    }

    val primerValor = 10
    val segundoValor = 0

    //  Podemos asignar un try-catch a un variable
    val resultado: Int = try {
        primerValor / segundoValor
    } catch (exception: Exception) {
        0
    }
    println(resultado)
}
````

Se usa cuando creemos que algo puede llegar a fallar para luego ver que hacemos en ese caso.