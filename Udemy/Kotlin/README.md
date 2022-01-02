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

Aunque también hay una forma de declarar variables que pueden ser `null` en Kotlin pero esto debe hacerse de forma explícit con el operador `?`.

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

Esto no puede parecer muy importante, pero en un programa real, con cientos de variables se hace muy difícil seguir el rastro de todas las variables y ver si es que están inicializadas o no.

En Java no podemos saber esto ya que el lenguaje no fue diseñado para tomar en cuanta estos posibles errores, sin embargo Kotlin nos advertirá de esto al momento de compilar el programa.

Kotlin sin embargo nos provee formas de seguir usando las variables que son `null` sin problemas con el operador `!!`, el cual es como decir, "confiá en mi, este valor no es `null`!!".

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

Kotlin tiene un operador llamado "Elvis Operator" que es un operador que nos permite saber si una variable es `null` o no.

```kotlin
val name: String? = "Diego";
val length = name?.length ?: -1;
```

Es como decir "verifica si la variables es null, de ser así entonces devuelve el valor -1, de lo contrario devuelve la longitud de la variable".

Kotlin es interoperable con Java, es decir podemos mesclar Kotlin con Java y viceversa, este tipo de operadores fueron creados pensando en esto.