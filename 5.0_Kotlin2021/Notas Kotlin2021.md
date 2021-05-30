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