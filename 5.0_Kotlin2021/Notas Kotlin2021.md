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

### Variables en Kotlin

Las variables sirven para almacenar datos temporales y utilizarlos a lo largo de nuestro código. Son información
almacenada en la memoria RAM.

### Tipos de variables

- **var**: Son variables de lectura y escritura, en estas variables el valor que contienen puede cambiar.
- **val**: Son variables de solo lectura, dichas variables una vez asignado el valor no puede ser cambiado
  posteriormente.
- **const**: Es una variable de solo lectura, estas se definen fuera de la función y se escriben con la palabra
  reservada `const` seguida de la palabra reservada `val`, este tipo de variables son usadas para valores que nunca
  cambian.

En Kotlin no se puede cambiar el tipo de dato con que se a definido una variable, si la variable se definió con el tipo
de dato String solo podremos actualizar dicho valor por otro String, por ejemplo no podemos pasar de un String a un
número.

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

Si un entero puede ser nulo, no se convertirá a primitivo. Pero un entero que no puede ser nulo, se convertirá a
primitivo.

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

### Estructuras de control: if

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

### Estructuras de control: when

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

## Conceptos básicos de Kotlin

### Bucles: While y Do While

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

### Ciclos:

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

### Null-Safety en Kotlin

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

### Valores nulos, Double bang y cómo solucionarlos

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

### Try Catch

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

Se usa cuando creemos que algo puede llegar a fallar, para luego ver que hacemos en ese caso.

### Elvis operator

Nos ayuda a devolver un valor cuando un elemento es nulo.

Podemos convertir un tipo nullable a un tipo no nullable usando el operador elvis para asignar un valor por defecto a
una variable en el caso de que el código que ejecutamos devuelva nulo.

````kotlin
fun main(args: Array<String>) {
    var nombre: String? = null
    // al lado derecho va el valor por defecto que se asignará en caso de que sea nulo
    var caracteresDeNombre: Int = nombre?.length ?: 0 // return 0 porque la variable nombre es nula
}
````

`?:` Se llama operador elvis porque parece un copete, como el del cantante Elvis.

## Collections en Kotlin

### Listas

Las listas pertenecen a la familia de las collections, se dividen en **dos tipos: listas mutables y listas inmutables**.
Las listas inmutables son aquellas que no pueden tener elementos modificados, esto quiere decir que una ves que asignes
los elementos a esta lista no vas a poder eliminarlos ni modificarlos.

````kotlin
fun main(args: Array<String>) {
    val listaDeNombres = listOf("Juan", "Enrique", "Camila")// esta lista no puede ser modificada
    println(listaDeNombres)

    val listaVacia = mutableListOf<String>() // esta lista si puede ser modificada
    println(listaVacia)

    listaVacia.add("Diego")
    println(listaVacia)

    // Para obtener un valor de una lista se puede hacer de dos formas

    val valorUsandoGet = listaVacia.get(0)
    println(valorUsandoGet)

    val valorUsandoOperador = listaVacia[0]
    println(valorUsandoOperador)

    // Existen muchas formas en Kotlin para obtener el valor de una lista

    val primerValor = listaDeNombres.first() // obtiene el primer valor y lo devuelve
    // también se puede pasar como parámetro una condición para obtener el primer elemento que cumpla con esa condición
    println(primerValor)
    // este operador hay que tenerlo en cuenta porque aunque imprima igual que los otros dos
    // puede que no encuentre el primer elemento de la lista y de una excepción.
    // En ese caso es mas recomendable usar el firstOrNull()

    val primerValorOrNull: String? = listaDeNombres.firstOrNull()
    println(primerValorOrNull)

    // busca el primer elemento y en caso de que la lista esté vacía devolverá un string nullable

    // Para eliminar elementos
    listaVacia.removeAt(0)
    println(listaVacia)

    listaVacia.add("Enrique")
    println(listaVacia)
    listaVacia.removeIf { carateres -> carateres.length > 3 } // remueve cuando la condición dentro de las llaves sea verdadera
    println(listaVacia)
}
fun main(args: Array<String>) {
    val listaDeNombres = listOf("Juan", "Enrique", "Camila")// esta lista no puede ser modificada
    println(listaDeNombres)

    val listaVacia = mutableListOf<String>() // esta lista si puede ser modificada
    println(listaVacia)

    listaVacia.add("Diego")
    println(listaVacia)

    // Para obtener un valor de una lista se puede hacer de dos formas

    val valorUsandoGet = listaVacia.get(0)
    println(valorUsandoGet)

    val valorUsandoOperador = listaVacia[0]
    println(valorUsandoOperador)
    // Kotlin es capaz de sobreescribir el operador de indexación para obtener este valor

    // Existen muchas formas en Kotlin para obtener el valor de una lista

    val primerValor = listaDeNombres.first() // obtiene el primer valor y lo devuelve
    // también se puede pasar como parámetro una condición para obtener el primer elemento que cumpla con esa condición
    println(primerValor)
    // este operador hay que tenerlo en cuenta porque aunque imprima igual que los otros dos
    // puede que no encuentre el primer elemento de la lista y de una excepción.
    // En ese caso es mas recomendable usar el firstOrNull()

    val primerValorOrNull: String? = listaDeNombres.firstOrNull()
    println(primerValorOrNull)

    // busca el primer elemento y en caso de que la lista esté vacía devolverá un string nullable

    // Para eliminar elementos
    listaVacia.removeAt(0)
    println(listaVacia)

    listaVacia.add("Enrique")
    println(listaVacia)
    listaVacia.removeIf { carateres -> carateres.length > 3 } // remueve cuando la condición dentro de las llaves sea verdadera
    println(listaVacia)
}
````

### Arrays

Los arrays son una estructura de datos que contiene una lista de elementos agrupados. En Kotlin el compilador es lo
suficientemente inteligente para adecuarlos dependiendo de las necesidades, es decir, que si tienes una lista de arrays
que son nullables puede que la mejor forma de utilizarlo sean las listas, además las arrays no cuentan con tantas
funciones como las listas.

Las arrays al ser una estructura de datos muy básica, a diferencia de las listas, no nos permite tener una
visualización, exacta si nó que devuelve el código en bytecode.

En Java es mejor usar arrays pero en Kotlin es mejor usar listas.

````kotlin
fun main(args: Array<String>) {
    //Arrays
    val myArray = arrayOf(1, 2, 3, 4)
    println("Nuestro array $myArray")
    println("Array como lista ${myArray.toList()}") // convertimos el array a una lista para poder imprimirlo
}
````

- Si está utilizando ARRAYS los datos se almacenarán de forma secuencial en el almacenamiento, es decir, se asignará un
  bloque continuo de almacenamiento para almacenar los datos. Pero si hablamos de LISTAS, entonces es una interfaz que
  puede tener diferentes implementaciones como ArrayList \<T>, LinkedList \<T>, etc. y la representación en memoria de
  estos List \<T> depende de la implementación, es decir, si es ArrayList \<T> o LinkedList \<T> o algo más.


- Supongamos en el futuro, si queremos cambiar un elemento por otro no podremos porque las List son de naturaleza
  inmutable. Por lo tanto, no puede actualizar los valores List \<T>. Para actualizar los valores, debe usar MutableList
  \<T>. En cambio los Arrays si pueden actualizar sus valores.


- ¿Qué pasa si en el futuro queremos agregar algunos elementos? En este caso, si estamos usando Arrays, entonces no
  podemos agregar ningún valor adicional a nuestra variable de cursos porque las matrices tienen un tamaño fijo y no
  podemos aumentar o disminuir el tamaño de una matriz.


- Pero si usamos MutableList \<T>, podemos agregar algunos valores usando el método add y eliminar algunos valores
  usando el método remove.


- Entonces, estas son algunas de las diferencias entre una lista y una matriz. Si tiene datos de tamaño fijo, se pueden
  utilizar matrices. Si bien el tamaño de los datos puede variar, se pueden usar listas mutables.

### Cómo ordenar listas con las funciones que tiene Kotlin

````kotlin
fun main(args: Array<String>) {
    val numerosDeLoteria = listOf(11, 22, 43, 56, 78, 66)
    println(numerosDeLoteria)

    // funciones para ordenar listas
    val numerosSorted = numerosDeLoteria.sorted()
    println(numerosSorted)

    val numerosDeLoteriaDescendientes = numerosDeLoteria.sortedDescending()
    println(numerosDeLoteriaDescendientes)

    val ordenarPorMultiplos =
        numerosDeLoteria.sortedBy { numero -> numero < 50 } // los numero que sean mayor a 50 van de primero y los que sean menores a 50 van de últimos

    val numerosAleatorios = numerosDeLoteria.shuffled() // ordena la lista aleatoriamente
    println(numerosAleatorios)

    val numeroEnReversa = numerosDeLoteria.reversed()
    println(numeroEnReversa)

    // funciones usadas en programación funcional
    // map: nos permite convertir un elemento de un tipo a otro tipo
    val mensajesDeNumeros = numerosDeLoteria.map { numero -> "Tu numero de lotería es $numero" }
    println(mensajesDeNumeros) // convertimos una lista de enteros a una lista de strings


    // filter: nos permite filtrar elementos dependiendo de la condición que le pasemos
    val numerosFiltrados = numerosDeLoteria.filter { numero -> numero > 50 }
    println(numerosFiltrados)
}
````

Vale la pena comentar que también podemos encadenar los métodos que nos dan las lista, como ejemplo:

````kotlin
val listaDeStringDeNumeros = numerosDeLoteria.filter { num -> num > 50 }.map { num -> "numero: $num" }
````

Lo que nos entrega una lista de Strings de números mayores de 50, por si quieren ahorrarse código.

### Maps

Los Maps no tienen que ver con la función map anterior, los Maps son elementos de clave valor que nos permiten ordenar
los elementos de una forma en la que tenemos una clave que tiene asignado un valor, además existen los Maps inmutables e
inmutables.

````kotlin
fun main(args: Array<String>) {
    // son una estructura de datos del tipo clave - valor
    // para cada clave existe un valor
    // un valor puede pertenecer a varias claves, pero solo puede existir una clave del mismo tipo

    // mapOf() crea mapas inmutables
    val edadDeSuperHeroes = mapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )
    println(edadDeSuperHeroes)

    // mutableMapOf() crea mapas mutables
    val edadDeSuperHeroesMutable = mutableMapOf(
        "IronMan" to 35,
        "SpiderMan" to 23,
        "Capitan America" to 99
    )
    println(edadDeSuperHeroesMutable)

    // para agregar un elemento
    edadDeSuperHeroesMutable.put("Wolverine", 45)
    println(edadDeSuperHeroesMutable)

    edadDeSuperHeroesMutable["Storm"] = 30
    println(edadDeSuperHeroesMutable)

    // para obtener un valor de un map
    // no modifica el valor del map por lo que se puede usar con mutables e inmutables

    val edadIronMan = edadDeSuperHeroesMutable["IronMan"]
    println(edadIronMan)

    // para eliminar un elemento de un map
    edadDeSuperHeroesMutable.remove("Wolverine")
    println(edadDeSuperHeroesMutable)

    // para ver las keys de un map
    println(edadDeSuperHeroesMutable.keys)

    // para ver los valores de un map
    println(edadDeSuperHeroesMutable.values)
}
````

### Sets

Los sets, a diferencia de las listas, no pueden tener elementos repetidos, esto quiere decir que todo elemento repetido
será eliminado, solamente se tendrá en cuenta el primero declarado.

````kotlin
fun main(args: Array<String>) {
    // los sets al igual que los ademas collections, también hay de tipo mutable e inmutable

    // inmutables
    val vocalesRepetidas = setOf("a", "e", "i", "o", "u", "a", "e", "i", "o", "u")
    println(vocalesRepetidas)
    // los sets solo tienen en consideración la primera variable si es que está repetida
    // se parecen mucho a las listas pero esta no permite dos elementos iguales
    // es muy util cuando quieres eliminar duplicados de una lista

    // mutables
    val numerosFavoritos = mutableSetOf(1, 2, 3, 4)
    println(numerosFavoritos)
    // para agregar elementos
    numerosFavoritos.add(5)
    println(numerosFavoritos)

    // para eliminar elementos
    // no tenemos un index ya que los sets no tienen un orden en especifico
    // esto hace que no los podamos obtener tan fácilmente como en las listas y en los hashmap
    println(numerosFavoritos)
    // en los sets se elimina el elemento dependiendo del valor, en las listas se elimina dependiendo de la posición
    numerosFavoritos.remove(5)
    println(numerosFavoritos)

    // para obtener el valor de un elemento en un set
    val valorDelSet = numerosFavoritos.firstOrNull { numero -> numero > 2 }
    println(valorDelSet)
}
````

## Libera el potencial de las funciones

### ¿Qué son las funciones?

Una función es un código que se ejecuta cada vez que lo llamamos. Las hemos venido utilizando anteriormente, pero ahora
vamos a profundizar. Es un código que una vez que le pasas unos parámetros ejecuta ese código una vez más y devuelve un
resultado.

### Sintaxis de una función

Las funciones más básicas se componen de 4 partes. Empecemos con el **nombre**.

Toda función empieza con la palabra reservada **fun** y luego el nombre de la función.

Luego tenemos los **parámetros**, que son las variables que le damos a la función para que las use en el código que
tiene dentro.

Sigue el tipo de retorno. Es decir el tipo que va a ejecutar una vez ejecutada la función.

Para terminar tenemos el código que vamos a ejecutar cuando llamemos la función.

- Palabra reservada **fun**.
- Nombre de la función.
- Parámetros: Son las variables que le daremos a la función para que las use en el código que ejecuta internamente.
- Tipo de retorno: Puede tener o no un valor de retorno.
- Código: Son las instrucciones que se van a ejecutar al llamar a la función.

````kotlin
fun suma(primerValor: Int, segundoValor: Int): Int {
    return primerValor + segundoValor
}
````

Cuando queremos devolver algo de nuestra función usamos la keyword **return**. Caso contario cuando no queremos devolver
nada de nuestra función. Kotlin regresaría **Unit**.

Ejemplo de función que no devuelve nada:

````kotlin
fun imprimir(nombre: String, apellidos: String) {
    print("Mi nombre es $nombre y mi apellido es $apellido")
}
````

### Funciones y funciones de extensión

````kotlin
fun main(args: Array<String>) {
    val fraseAleatoria = "La frase mas bacán del multiverso"
    imprimirFrase(randomCase(fraseAleatoria))
}

// devuelve Unit
fun imprimirFrase(frase: String) {
    println("Tu frase es: $frase")
}

// Las funciones hay que declararlas fuera
fun randomCase(frase: String): String {
    val numeroAleatorio = 0..99
    val resultadoAleatorio = numeroAleatorio.random()
    return if (resultadoAleatorio.rem(2) == 0) {
        frase.toUpperCase()
    } else {
        frase.toLowerCase()
    }
}
````

### Funciones de extensión

Las funciones de extensión nos permiten extender del comportamiento del tipo de la función y utilizarlas como si fuesen
frases directamente de ese tipo. Para ello tenemos que especificar el tipo al momento de crear una función

Mismo código pero con funciones de extensión:

````kotlin
fun main(args: Array<String>) {
    val fraseAleatoria = "La frase mas bacán del multiverso".randomCase()
    imprimirFrase(fraseAleatoria)
}

// devuelve Unit
fun imprimirFrase(frase: String) {
    println("Tu frase es: $frase")
}

// Las funciones hay que declararlas fuera
fun String.randomCase(): String {
    val numeroAleatorio = 0..99
    val resultadoAleatorio = numeroAleatorio.random()
    return if (resultadoAleatorio.rem(2) == 0) {
        this.toUpperCase()
    } else {
        this.toLowerCase()
    }
}
````

### Tipos de parámetros en la funciones

Dependiendo de la función que queramos podemos crear distintos tipos de parámetros, podeos crear parámetros nombrados o
parámetros por defecto.

### Parámetros nombrados

````kotlin
fun main(args: Array<String>) {
    // parámetros nombrados
    imprimirNombre(nombre = "Diego", apellido = "Obando") // con parámetros nombrados
    // Esto es de mucha ayuda y es una buena practica hacerlo cuando tienes una función que recibe como parámetro
    // dos parámetros del mismo tipo en este caso dos Strings
}

fun imprimirNombre(nombre: String, apellido: String) {
    println("Mi nombre es $nombre y mi apellido es $apellido")
}
````

### Parámetros por defecto

Estos nos ayudan a que nuestras funciones sean más legibles y no tengan demasiados parámetros que no vamos a utilizar.
Ayuda cuando tenemos funciones con muchos parámetros.

````kotlin
// parámetros por defecto
fun imprimirNombre(nombre: String, segundoNombre: String = "segundo nombre", apellido: String) {
    println("Mi nombre completo es $nombre $segundoNombre $apellido")
}
````

### Lambdas

Las conocemos en otros lenguajes como funciones anónimas o funciones literales.

````kotlin
fun main(args: Array<String>) {
    // es un código que no se ha ejecutado y que cuando lo ejecutas puedes obtener su valor
    val myLambda: (String) -> Int = { valor -> // it es el valor que estamos pasando a la lambda
        valor.length
    }   // devuelve un Int, el cual es el length del String que le pasemos
    val lambdaEjecutatada: Int = myLambda("Hola Kbroz") // ejecuta la lambda
    println(lambdaEjecutatada)

    val saludos = listOf("Hello", "Hola", "ni hao")
    val longitudDeSaludos = saludos.map(myLambda)
    println(longitudDeSaludos)
}
````

### High Order Functions

Son aquellas funciones que reciben otra función como parámetro.

````kotlin
fun main(args: Array<String>) {
    val largoDelValorInicial = superFuncion(valorInicial = "Hola!", block = { valor ->
        valor.length
    })
    println(largoDelValorInicial)
}

fun superFuncion(valorInicial: String, block: (String) -> Int): Int {
    return block(valorInicial)  //  para obtener el valor de una lambda debemos pasarle un parámetro
    // cuando se usan las lambdas como parámetro de una función se deben dejar en la ultima posición
    // porque esto nos permite sacar la lambda fuera de la función
}
````

````kotlin
fun main(args: Array<String>) {
    val largoDelValorInicial = superFuncion(valorInicial = "Hola!") { valor ->
        valor.length
    }
    println(largoDelValorInicial)

    val lambda: () -> String = funcionInception("Diego")
    val valorLambda: String = lambda()
    println(valorLambda)
}

// Kotlin recomienda que llamemos block a la lambda cuando es pasada como parametro
fun superFuncion(valorInicial: String, block: (String) -> Int): Int {
    return block(valorInicial)  //  para obtener el valor de una lambda debemos pasarle un parámetro
    // cuando se usan las lambdas como parámetro de una función se deben dejar en la ultima posición
    // porque esto nos permite sacar la lambda fuera de la función
}

fun funcionInception(nombre: String): () -> String { // esta función devuelve una lambda, que devuelve una String
    return {
        "Hola desde la lambda $nombre"
    }
}
````

## Scope Functions

Son unas funciones que tiene Kotlin que nos permite realizar ciertas operaciones de una forma más dinámica, con una
sintaxis más concisa. Por ejemplo vamos a trabajar con funciones que nos permiten modificar una variable, sin tener que
estar repitiendo el nombre de la variable, o como la función **let**:

### let

Nos permite combinado con el operador de **safe calls** ejecutar un código **solo cuando una variable nullable no es
nula**, y ejecutar ese código solo cuando la variable tenga un valor asignado, para evitar un NullPointerException.

````kotlin
fun main(args: Array<String>) {
    var nombre: String? = null
    // se ejecuta cuando la variable nullable no es nula
    nombre?.let { valor ->
        println("el nombre no es nulo, es $valor")
    }
    nombre = "Diego"
    nombre.let { valor ->
        println("El nombre no es nulo, es $valor")
    }
}
````

Esto nos ayuda a protegernos de los errores inesperados en nuestra aplicación.

### with

El **with** nos permite acceder directamente a las propiedades de una variable que le pasamos como parámetro, de esta
forma podemos evitar repertir llamar a la variable en varias líneas, sino que simplemente usamos **this** o utilizamos
directamente sus propiedades.

````kotlin
fun main(args: Array<String>) {
    val colores = listOf("Azul", "Amarillo", "Rojo")
    with(colores) {
        println("Nuestros colores son: $this")
        println("Esta lista tiene una cantidad de colores de $size")
    }
}
````

### Run

Hasta ahora hemos hablado solo de dos Scope Functions, **with** y **let**. Otra Scope function es **Run**. Run nos
ejecuta una serie de operaciones luego de declarar una variable.

````kotlin
fun main(args: Array<String>) {
    val moviles = mutableListOf("Google Pixel 2xl", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3")
        .run {
            removeIf { movil -> movil.contains("Google") }
            this
        }
    println(moviles)
}
````

### Apply

La función **Apply** nos permite realizar operaciones sobre una variable y luego devolver el valor, al contrario de la
función run en la que tuvimos que devolver el this al final, en este caso no hace falta ya que la función **apply** lo
devuelve automáticamente, también si la combinamos con un una función de safe cast se crea una función **apply segura**
esto a causa de que la variable nullable que teníamos no puede ejecutar ese cambio de propiedades a menos que se le haya
asignado un valor a la variable, esto nos permite evitar NullPointersExceptions.

````kotlin
fun main(args: Array<String>) {
    // lo mismo que la function run pero sin el this
    val moviles = mutableListOf("Google Pixel 2xl", "Google Pixel 4a", "Huawei Redmi 9", "Xiaomi mi a3").apply {
        removeIf { movil -> movil.contains("Google") }
    }
    println(moviles)
    // la función apply puede también funcionar como el with, solo que esta acepta nullables

    val colores: MutableList<String>? =
        mutableListOf("Amarillo", "Azul", "Rojo") // las listas pueden ser nulas completas o tener valores nulos dentro
    colores?.apply {
        println("Nuestros colores son $this")
        println("La cantidad colores es $size")
    }
}
````

Esto nos ayuda a evitar estar accediendo a propiedades o modificando variables en el caso de que sea nullable. Es
recomendable usar la función **apply** cada vez que puedas para convertir los tipos nullables a tipos no nullables.

Esta función se utiliza muchísimo, sobre todo con los safe cast, porque cuando trabajas con código de terceros o con
librerías en Java no sabes si te puedes encontrar con un nulo o no, y modificar esas propiedades solo cuando estas
seguro de que no va a ser nulo es una gran ayuda.