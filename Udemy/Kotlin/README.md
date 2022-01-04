# Kotlin

[Documentación de Kotlin](https://kotlinlang.org/docs/home.html)

## Variables y tipos de Datos

Hay dos formas básicas de declarar variables en Kotlin, una es con el operador `var` y la otra con el operador `val`.

```kotlin
var age = 25;
val name = "Diego";
```

Estas dos formas de declarar una variable no son los mismo, `var` es una variable mutable y `val` es una variable inmutable.

Kotlin es un lenguaje tipado, sin embargo podemos declarar variables sin tipo de dato ya que Kotlin puede inferirlo, se puede hacer, pero si un lenguaje tiene tipos hay que usarlos.

La forma correcta de declarar una variable es:

```kotlin
var age: Int = 25;
val name: String = "Diego";
```

Lo mismo con `Boolean`, `Double`, `Float`, `Long` y `Short`.

```kotlin
val isMarried: Boolean = false;
val weight: Double = 75.5;
val height: Float = 1.75f; // f es para indicar que es un float
val age: Int = 25;
val age: Long = 3000000000 // Long puede almacenar desde -2^63 y hasta un valor de 2^63-1, es para números grandes
val oneLong = 1L // tipo Long
```

También están los tipos `Byte` y `Short`.

```kotlin
val oneByte: Byte = 1; // tipo Byte, desde -128 hasta 127
val oneShort: Short = 1; // tipo Short, desde -32768 hasta 32767
```

Las variables que son declaradas con `val` no pueden ser reasignadas con otro valor diferente al que ya tenía. En Kotlin siempre debemos preferir `val` sobre `var` siempre que sea posible.

`val` > `var`

Al igual que en Java siempre debemos evitar usar `Float` y mejor usar `Double` por la mayor precisión que este tipo tiene, ya que usar `Float` puede causar errores al momento de comparar ciertos valores.

## Null Safety en Kotlin

Esta es una de las mayores diferencias cuando comparamos Kotlin con Java.

En Kotlin por defecto todos los tipos no pueden ser `null`, es decir no podemos asignarle `null` a una variable de tipo `Int`, por ejemplo.

```kotlin
val age: Int = null; // Error
```

A diferencia de Java en donde se puede hacer esto sin problemas. Esto está hecho así para evitar los `NullPointerException` los cuales son muy comunes en Java.

Aunque también hay una forma de declarar variables que pueden ser `null` en Kotlin pero esto debe hacerse de forma explícita con el operador `?`.

```kotlin
val str: String? = null;
val age: Int? = null;
val height: Double? = null;
val isMarried: Boolean? = null;
```

El problema con los valores null es que no podemos saber si en el tiempo de ejecución del programa va a haber alguna variable que no fue inicializada, por lo que podríamos tratar de usar algún método del tipo de dato que se supone que tendría que tener por ejemplo:

```kotlin
val str: String? = null;
str?.length; // Error
```

No podemos obtener la longitud de un String si esta variable en realidad es `null`.

Esto no puede parecer muy importante, pero en un programa real, con cientos de variables se hace muy difícil seguir el rastro de cada una de ellas y ver si es que están inicializadas o no.

En Java no podemos saber esto ya que el lenguaje no fue diseñado para tomar en cuenta estos posibles errores, sin embargo Kotlin nos advertirá de esto al momento de compilar el programa.

Kotlin de todas maneras, nos provee formas de seguir usando las variables que son `null` sin problemas con el operador `!!`, el cual es como decir, "confiá en mi, este valor no es `null`!!".

```kotlin
val str: String? = null;
str!!.length; // No hay problema
```

Lo cual nos daría un `Kotlin.KotlinNullPointerException` en este caso.

Hacer esto no es recomendable, pero es posible.

El operador `!!` es llamado "Unsafe call operator".

Existe lo opuesto a este operador, el operador `?` que es llamado "Safe call operator".

```kotlin
val str: String? = null;
str?.length; // No hay problema
```

De esta forma el programa no crashea sino que nos devuelve `null`.

```kotlin
val name: String? = "Diego";
name?.length;
```

Si la variable llegase a tener un valor que no es `null` nos devolvería sin problemas la longitud de la variable.

Usar el operador `?` de esta forma es similar a un `if`, "si la variable no es `null` entonces ejecuta la acción".

### Elvis Operator

Kotlin tiene un operador llamado "Elvis Operator" `?:` que es un operador que nos permite saber si una variable es `null` o no, de ser null le asignamos el valor que definamos.

```kotlin
val name: String? = "Diego";
val length = name?.length ?: -1;
```

Es como decir "verifica si la variables es null, de ser así entonces devuelve el valor -1, de lo contrario devuelve la longitud de la variable".

Kotlin es interoperable con Java, es decir podemos mesclar Kotlin con Java y viceversa, este tipo de operadores fueron creados pensando en esto.

## Condicionales: expresión if

Una condicional `if` nos permite evaluar una condición y ejecutar una acción dependiendo de si es verdadero o falso.

Por ejemplo:

```kotlin
val age: Int = 25;

if (age > 18) {
    println("Eres mayor de edad")
} else {
    println("Eres menor de edad")
}
```

También podemos concatenar varios `if`s, pero solo podemos usar un `else` en la última condición.

```kotlin
val age: Int = 25;

if (age > 18) {
    println("Eres mayor de edad")
} else if (age == 18) {
    println("Eres igual a 18")
} else {
    println("Eres menor de edad")
}
```

`else if` es una condición más, sirve para concatenar varias condiciones de ser necesario.

En Kotlin las condiciones if son expresiones, esto quiere decir que el resultado que resuelvan puede ser asignado a una variable.

```kotlin
val age: Int = 25;

val res = if (age > 18) {
    "Eres mayor de edad"
} else {
    "Eres menor de edad"
}

println(res); // Eres mayor de edad
```

El valor que tome la variable `res` será el que se resuelva en la expresión.

El valor que tome la variable debe ser un tipo de dato que pueda ser asignado a la variable, por ejemplo si la expresión fuera la siguiente:

```kotlin
val age: Int = 25;

val res = if (age > 18) {
    println("Eres mayor de edad")
} else {
    println("Eres menor de edad")
}
```

La variable no podría tomar el valor de la expresión que resulte del if. Para solucionarlo podemos hacer lo siguiente:

```kotlin
val age: Int = 25;

val res = if (age > 18) {
    println("Eres mayor de edad")
    "Eres mayor de edad"
} else {
    println("Eres menor de edad")
    "Eres menor de edad"
}
```

De esta forma la variable toma el valor del string que se resuelva en la expresión.

Como dato, en Kotlin las expresiones que no retornan nada en realidad están retornando el valor `Unit` que es un tipo de dato que no tiene ningún valor, es como decir una expresión vacía.

## Condicionales: expresión when

La expresión `when` es el equivalente a un `switch` en otros lenguajes, nos permite evaluar una condición y ejecutar una serie de acciones dependiendo de la condición.

```kotlin
val price = 29

when (price) {
    0 -> println("El precio es 0")
    in 1..10 -> println("El precio está entre 1 y 10")
    else -> println("El precio es mayor a 10")
}
```

Es mucho más conciso que usar una serie de `else if`'s para evaluar una condición, también nos permite evaluar entre rangos de valores usando `in`, por ejemplo:

```kotlin
val price = 29

when (price) {
    in 1..10 -> println("El precio está entre 1 y 10")
    in 11..20 -> println("El precio está entre 11 y 20")
    in 21..30 -> println("El precio está entre 21 y 30")
    else -> println("El precio es mayor a 30")
}
```

También cabe mencionar que tenemos el `else` que es una condición que se ejecuta cuando ninguna de las condiciones anteriores se cumple, similar a como funciona en un `if`.

También podemos hacer operaciones dentro de las condiciones, por ejemplo:

```kotlin
val price = 29

when (price) {
    in 1..10 -> println("El precio está entre 1 y 10")
    in 11..20 -> println("El precio está entre 11 y 20")
    in 21..30 -> println("El precio está entre 21 y 30")
    10 + 20 -> println("El precio es mayor a 30")
    else -> {
        println("El precio es mayor a 30")
        println("El precio es $price")
    }
}
```

También podemos ver si la condición no esta dentro de un rango negando con el operador `!` al igual que con las expresiones lógicas.

```kotlin
val price = 29

when (price) {
    !in 1..10 -> println("El precio no está entre 1 y 10")
    !in 11..20 -> println("El precio no está entre 11 y 20")
    !in 21..30 -> println("El precio no está entre 21 y 30")
    else -> println("El precio está entre 1 y 10")
}
```

A diferencia de `switch` en otros lenguajes, el `when` no necesita que pongamos un `break` después de cada condición, simplemente ejecuta la primera condición que se cumpla.

También podemos usar la expresión `when` sin ninguna variable a evaluar, si hacemos esto lo que pongamos a la izquierda de `->` debe resultar en un valor booleano.

```kotlin
val price 

when {
    price > 10 -> println("El precio es mayor a 10")
    price < 10 -> println("El precio es menor a 10")
    else -> println("El precio es igual a 10")
}
```

Al igual que `if`, `when` también es una expresión, por lo que podemos asignar el valor que resulte de la expresión a una variable.

```kotlin
val price = 29

val res = when (price) {
    in 1..10 -> "El precio está entre 1 y 10"
    in 11..20 -> "El precio está entre 11 y 20"
    in 21..30 -> "El precio está entre 21 y 30"
    else -> "El precio es mayor a 30"
}

println(res) // El precio está entre 21 y 30
```

```kotlin
val price = 39

val x = when {
    price <= 19 -> "Vendido"
    price <= 29 -> "En venta"
    else -> "No vendido"
}

println(x) // No vendido
```

## Collections

Las colecciones en Kotlin están construidas sobre las colecciones de Java, por lo que podemos usar las mismas funciones que las de Java.

Otra peculiaridad de Kotlin es que hay una clara distinción entre las colecciones mutables y las colecciones inmutables, lo cual está alineado con el principio de preferir la inmutabilidad por sobre la mutabilidad.

Por ejemplo tenemos las colecciones inmutables:

```kotlin
List<Int>
Set<Int>
Map<Int, String>
```

Las colecciones inmutables solo nos proveen métodos para leer los valores de la colección, no para modificarlos.

Para las colecciones mutables tenemos:

```kotlin
MutableList<Int>
MutableSet<Int>
MutableMap<Int, String>
```

Estas colecciones mutables proveen métodos para leer y modificar los valores de la colección.

Kotlin nos provee de funciones que nos ayudan a crear cualquier tipo de colección, por ejemplo:

```kotlin
val array = arrayOf(1, 2, 3)
array.joinToString() // 1, 2, 3
// nos devuelve una cadena con los valores de la colección separados por comas
```

También podemos crear un array con un tipo en específico:

```kotlin
val arrayInt = intArrayOf(1, 2, 3)
val arrayDouble = doubleArrayOf(1.0, 2.0, 3.0)
```

Los mismo con las Listas:

```kotlin
val list = listOf(1, 1, 2, 3, 5, 8, 13)
val mutableList = mutableListOf(1, 2, 3)
```

Para modificar la lista mutable:

```kotlin
mutableList[0] = 99
println(mutableList) // [99, 2, 3]
```

Esto no podríamos hacerlo con una lista inmutable:

```kotlin
list[0] = 99 // Error
```

Lo mismo con lo Set:

```kotlin
val set = setOf(1, 1, 2, 3)
println(set) // [1, 2, 3]
```

Los `set` tienen la peculiaridad de que no aceptan valores duplicados.

```kotlin
val mutableSet = mutableSetOf(1, 2, 3)
mutableSet.add(4)
println(mutableSet) // [1, 2, 3, 4]
```

Están también los `map`, que son una colección de pares de clave y valor.

```kotlin
val map: Map<Int, String> = mapOf(1 to "uno", 2 to "dos", 3 to "tres")
val mutableMap: MutableMap<Int, String> = mutableMapOf(1 to "uno", 2 to "dos", 3 to "tres")
```

Cabe recalcar que existe una marcada diferencia entre las colecciones mutables y las inmutables, en donde siempre deberíamos preferir usar las colecciones inmutables, a menos que sea necesario usar una colección mutable.

## Loops: For

Los loops o ciclos en Kotlin son muy parecidos a los loops de Java, pero con algunas diferencias.

```kotlin
for (i in 1..10) {
    println(i)
}
```

Como podemos ver son mucho mas sencillos que en Java, en donde el iterados, itera por cada uno de los elementos de la colección.

Es por eso que podemos hacer lo siguiente por ejemplo:

```kotlin
for (c in "Kotlin") {
    println(c) 
}

// Devuelve: K o t l i n
```

Pasa por cada uno de los elementos, incluso si lo que se está iterando es un String.


También podemos hacerlo con una colección:

```kotlin
val languages = listOf("Kotlin", "Java", "C++")

for (lang in languages) {
    println("$lang is great!") 
}

// devuelve: Kotlin is great! Java is great! C++ is great!
```

También podemos iterar al revés de la siguiente manera:

```kotlin
for (i in 10 downTo 1) {
    println(i)
}

// devuelve: 10 9 8 7 6 5 4 3 2 1
```

También podemos saltarnos elementos:

```kotlin
for (i in 10 downTo 1 step 2) {
    println(i)
}

// devuelve: 10 8 6 4 2
```

De esta forma iteramos de 2 en 2, en este caso desde el 10 hasta el 1.

Todo lo que podemos hacer con un for loop en Java, también podemos hacerlo en Kotlin, solo que con una sintaxis distinta.

## Loops: While

Los loops `while` y `do-while` funcionan de la misma manera que los loops de Java.

```kotlin
val i = 1

while(i <= 10) {
    println("$i")
    i++
}

// devuelve : 1 2 3 4 5 6 7 8 9 10
```

```kotlin
do {
    println(i)
} while (i <= 20)
```