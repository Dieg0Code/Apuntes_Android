# Notas del lenguaje Kotlin

## Qué es Kotlin

Kotlin es desarrollado por Jetbrains, Jetbrains es una compañía que crea entornos de desarrollo com Intelij idea por ejemplo, siendo este el que se utiliza como base para android studio.

Kotlin nació en el 2010 sin embargo, es bastante maduro y la base del desarrollo en Android hoy en dia.

### No solo se utiliza en Android

Se utiliza también en:

- Backend development.

Con frameworks como Spring, Micronaut o Ktor.

- De forma nativa.

Puede correr en Windows y otras plataformas de forma nativa.

### Kotlin surge de la necesidad de Java.

Era necesario una alternativa a Java. Con sintaxis moderna, nuevas funcionalidades y capaz de ser interoperable con Java. Podemos ir migrando poco a poco de Java a Kotlin hasta que nuestro proyecto sea completamente de Kotlin.

### La adopción en Android

Es el lenguaje recomendado para desarrollar app de Android y esto se debe a las limitantes que tiene Java.

## ¿Que es la Java Virtual Machine?

Una virtual machine es una virtualización o simulación de un sistema operativo o de los procesos que ocurren dentro de este. En nuestro caso, la Java Virtual Machine pertenece al segundo tipo y se encarga de simular los procesos que ocurren dentro de un sistema operativo. A este tipo de máquinas virtuales se les llama Process Vitual Machines.

### ¿Que ventajas nos da?

Nos ayuda a manejar los punteros y las referencias de memoria que en otros tipos de lenguaje como c o c++ hay que manejar manualmente. Para esto se utiliza un proceso llamado garbage collection. Este proceso se encarga de revisar qué referencia de memoria no se está utilizando para eliminarla y así reducir la cantidad de memoria que puede consumir un programa.

### ¿Como funciona la JVM?

La JVM funciona como un punto medio entre el código que nosotros escribimos y lo que entiende el sistema operativo del ordenador. Dependiendo del sistema operativo que uses puede variar. La JVM nos ayuda a que nuestro código se ejecute en Linux, Windows y MacOs. Nuestro código es convertido por la JVM a un leguaje que puede entender el sistema operativo llamado Java Bytecode.

En palabras más simples, nosotros ingresamos código de Kotlin y se transforma en Bytecode. Este proceso puede ocurrir con otros lenguajes como Java, esto hace que nuestro código de Kotlin pueda ser utilizado desde Java y el código de Java pueda ser utilizado en Kotlin.

### Bytecode vs lenguaje ensamblador

Bytecode es similar a lenguaje ensamblador en que no es un lenguaje de alto nivel, pero todavía es algo legible, a diferencia del lenguaje de máquina. Ambos pueden considerarse “lenguajes intermedios” que se encuentran entre el código fuente y el código de máquina. La principal diferencia entre los dos es que el código de bytes se genera para una máquina virtual (programa.), mientras que el lenguaje ensamblador se crea para un CPU (hardware).