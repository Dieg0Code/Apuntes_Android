# Apuntes de Firebase Firestore con Kotlin

Firebase es una herramienta diseñada para desarrolladores móviles, la cual nos hace despreocuparnos completamente de la infraestructura, nos permite enfocarnos en el producto ofreciéndonos servicios que nos garantizan escalabilidad.

En este curso vamos a usar dos módulos de **Firebase, el modulo de Autenticación y el modulo de Cloud FireStore**.

## Modulo de Autenticación

Nos permite crear cuentas temporales las cuales pueden acceder a los datos que están protegidos con reglas de seguridad.

![firebase auth](img/FB_auth.png)

## Modulo de Cloud FireStore

Nos da una base de datos en tiempo real, sincronizada, no relacional y que es flexible a escalar a las diferentes configuraciones que queramos.

![firebase cloud firestore](img/FB_cloud_firestore.png)

## Proyecto

En este caso construiremos una aplicación de criptomonedas la cual actualizara en tiempo real un dashboard.

## Firebase

La premisa que nos ofrece es **"aplicaciones rápidas sin preocuparte de infraestructura"**, esto se puede configurar de manera muy sencilla, en el curso vamos a utilizar estos módulos y con muy pocas lineas de código vamos a poder acceder y empezar a interactuar con **Firebase**.

Adicionalmente vas a crear mejores aplicaciones, te vas a enfocar mas en tu producto y esto va a hacer que tu productividad aumente no teniendo que preocuparte por toda la complejidad que conlleva configurar un backend y hacer que este escale.

## Otros módulos de Firebase

![Other modules in Firebase](img/FB_other_modules.png)

### Apps de Mayor Calidad

Las mediciones son muy importantes cuando desarrollas un producto de software para esto nos ofrecen diferentes herramientas para que podamos medir cual es la interacción que los usuarios tienen con nuestra aplicación. Para eso tenemos:

**Crashlytics** para medir todo tipo de fallos en las aplicaciones y priorizarlos.

**Monitor de Desempeño** el cual recibe todo los datos del desempeño de la aplicación.

**Test Lab** para probar nuestra aplicación en dispositivos reales lo cual es muy importante.

![Firebase measurement tools](img/FB_measurement_tools.png)

### Crece tu Negocio

Aquí queremos mirar todo el comportamiento de la aplicación y cómo lo podemos ajustar.

![Firebase analitycs](img/FB_analitycs.png)

### Integrando Firebase al Proyecto

Para integrar Firebase al proyecto debemos ir a la pagina <https://firebase.google.com>, luego ir a la consola (el botón está en la esquina superior derecha), luego creamos un nuevo proyecto. En este caso el applicationId será **"com.platzi.android.firestore"**, en las configuraciones dejamos todo por defecto.

Luego elegimos un proyecto android, descargamos el archivo .json, lo arrastramos a la carpeta "app".

En el **build.gradle(Proyect)** agregamos en **dependencies**:

```gradle
classpath 'com.google.gms:google-services:4.3.8'
```

También debemos fijarnos que en **buildscript** esté google().

Luego en **build.gradle(Module)** agregamos en **dependencies**:

```gradle
// Import the Firebase BoM
implementation platform('com.google.firebase:firebase-bom:28.1.0')
// Add the dependency for the Firebase SDK for Google Analytics
implementation 'com.google.firebase:firebase-analytics-ktx'
```

Luego sincronizamos y listo, ya debería estar integrado Firebase a nuestro proyecto.

En caso de que te de un error del tipo:

```txt
Invoke-customs are only supported starting with android 0 --min-api 26
```

El cual fue mi caso, debes agregar en **build.gradle(Module)** en la sección **android{}** lo siguiente:

```gradle
compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
}
```

Te dejo el hilo de StackOverflow [aquí](https://stackoverflow.com/questions/49891730/invoke-customs-are-only-supported-starting-with-android-0-min-api-26) por si quieres mas info sobre el error.

Y ahora si que si debería estar todo ok 😄.