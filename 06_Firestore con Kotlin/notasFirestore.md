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

### Autenticación Anónima Firebase

La autenticación anónima nos permite crear cuentas temporales las cuales pueden acceder a datos protegidos por reglas de seguridad.

Vamos a implementar la autenticación anónima de Firebase Authentication para crear cuentas temporales que pueden acceder a datos protegidos por reglas de seguridad.

Para importar la librería de Firebase Authentication debes copiar y pegar el link de autenticación en la sección de dependencias del archivo `build.gradle` y sincronizar tu proyecto para descargar la librería para utilizarla en nuestro proyecto:

```gradle
dependencies: {
    ...
    implementation 'com.google.firebase:firebase-core:16.0.7'
    implementation 'com.google.firebase:firebase-auth:16.1.0'
    ...
}
```

### Conociendo el modelo de datos de Cloud Firestore

Cloud Firestore es una base de datos no relacional muy flexible.

Tenemos un modelo de datos basado en dos tipos de objetos: Los **Documentos** (diccionarios de datos que podemos guardar y trabajar en forma de llaves y valores) y **Colecciones** (conjuntos de documentos).

Los documentos pueden ser sencillos o complejos, es decir, con llaves y valores y modelos de datos más avanzados; listas y objetos con más documentos en forma de llaves y valores o, incluso, más listas de documentos.

También podemos trabajar con **referencias** para acceder a nuestros documentos con "atajos" y realizar operaciones.

Nos permiten interactuar con una colección o documento especifico para realizar actualizaciones o lecturas

Ej:

```Kotlin
val bitcoinDocumentRef = db.collection("cryptos").document("bitcoin")

val bitcoinDocumentRef = db.document("cryptos/bitcoin")

val cryptosCollectionRef = db.collection("cryptos")
```

Recuerda que entre menos complejo es el modelo de tu base de datos mejor será su desempeño.

### Gestión de Índices es Firestore

Los **índices** son la forma que Firebase y muchas otras bases de datos usan para realizar búsquedas y consultas de forma eficiente y escalable. Gracias a los índices nos ahorramos tiempo y trabajo al evitar buscar nuestra información dato por dato en toda nuestra base de datos, que resultaría  algo lento y poco escalable.

#### Tipos de índices

- **Campo único**: Almacenan el orden de todos los documentos en una colección de un sólo campo. Podemos realizar consultas con los comparadores `<`, `<=`, `==`, `>=` y `array_contains`.
- **Compuestos**: Almacenan el orden de todos los documentos en una colección que contiene *subcampos*. Usamos los mismos comparadores pero podemos hacer operaciones más complejas.

```kotlin
citiesRef.where("name","==", "Santiago")

citiesRef.where("population", "<", 100000)

citiesRef.where("regions", "array-contains", "Amazonas")
```

#### Índices compuestos

Almacenan un mapeo ordenado de todos los documentos en una colección.

```kotlin
citiesRef.where("country", "==", "Chile").orderBy("population", "asc")

citiesRef.where("country", "==", "Chile").where("population", "<", 3000)

citiesRef.where("country", "==", "Chile").orderBy("population", ">", 3000)


```

Los **modos** nos ayudan a organizar nuestros índices de forma ascendente, descendente o con el modo `array_contains` para comprobar la existencia de nuestros índices en una colección.

También es muy importante controlar la **auto indexación**, algunos índices que Firestore crea por defecto de la siguiente manera:

- **Campos simples**(no colecciones): Dos índices de campo único (ascendente y descendente).
- **Diccionarios**: Dos índices de campo único (ascendente y descendente) por cada uno de los subcampos.
- **Colecciones**: Un índice de tipo `array_contains`.

### Creación y gestión de datos en Firestore

#### Creación de Documentos

```Kotlin
val city = HashMap<String, Any>()
city["name"] = "Santiago"
city["region"] = "Region metropolitana"
city["country"] = "Chile"

db.collection("cities").document("CL")
    .set(city)
    .addOnSuccessListener {
        Log.d(TAG, "DocumentSnapshot creado exitosamente")
    }
    .addOnFailureListener { e ->
        Log.w(TAG, "Error escribiendo documento", e)
    }
```

Si el documento no existe será creado. Si el documento existe será sobrescrito.

#### Merge de Documentos

```kotlin
// Actualizar un campo, el documento "CL" es creando si no existe.
val data = HashMap<String, Any>()
data["capital"] = true

db.collection("cities").document("CL")
    .set(data, SetOptions.merge())
```

#### Tipos de Datos

```kotlin
val docData = HashMap<String, Any>()
docData["stringExample"] = "Hello world!"
docData["booleanExample"] = true
docData["numberExample"] = 3.14159265
docData["dateExample"] = Date()
docData["listExample"] = arrayLisOf(1, 2, 3)
docData["nullExample"] = null

val nestData = HashMap<String, Any>()
nestedData["a"] = 5
nestedData["b"] = true

docData["objectExample"] = nestedData
```

#### Agregar un Documento

Nuevo Documento con ID definido:

```kotlin
db.collection("cities")
    .document("new-city-id").set(data) //data es el objeto que queremos guardar en la db
```

Nuevo Documento con ID Autogenerado:

```kotlin
val data = HasMap<String, Any>()
data["name"] = "Santiago"
data["country"] = "Chile"

db.collection("cities")
    .add(data)
```

#### Actualizar un Documento

```kotlin
val bogotaRef = db.collection("cities").document("BOG")

// Actualizar el campo "isCapital" de la ciudad 'BOG'
bogotaRef
    .update("capital", true) // campo y valor
    .addOnSuccessListener {
        Log.d(TAG, "DocumentSnapshot successfully updated!")
    }
    .addOnFailureListener {
        e -> Log.w(TAG, "Error updating document", e)
    }
```

#### Actualizar Subdocumentos

```kotlin
// Asuma que el documento contiene:
// { name: "Frank",
//   favorites: {food: "Pizza", color: 
//   "Blue", subjetc: "recess"},
//   age: 12
// }

// Para actualizar el atributo age y favorite color:
db.collection("users").document("frank")
    .update(
        "age", 13,
        "favorites.color", "Red"
    )
```

#### Actualizar Listas

```kotlin
val bogotaRef = db.collection("cities").document("BOG")

// Agregar una nueva región al arreglo "regions".
colombiaRef.update("regions", FieldValue.arrayUnion("Amazonas"))

// Remover una región del arreglo "regions".
colombiaRef.update("regions", FieldValue.arrayRemove("Amazonas"))
```

### Creación de Datos en Firestore

Para agregar datos a firestore a través de nuestra pantalla de autenticacion de forma anónima:

LoginActivity.kt

```kotlin
fun onStartClicked(view: View) {
        view.isEnabled = false
        auth.signInAnonymously().addOnCompleteListener { task ->
            if (task.isSuccessful) {
            val username = username.texttoString()
            val user = User()
            user.username = username
            saveUserAndStartMainActivity(userview)
        } else {
            showErrorMessage(view)
            view.isEnabled = true
        }
    }
}

    private fun saveUserAndStartMainActivity(user: User, view: View) {
        firestoreService.setDocument(user, // create a new user
            USERS_COLLECTION_NAME, // "users"
            user.username, // username
            object : Callback<Void> {
                override fun onSuccess(result: Void?) {
                    startMainActivity(user.username)
                }

                override fun onFailed(exception: Exception) {
                    showErrorMessage(view)
                    Log.e(TAG, "error", exception)
                    view.isEnabled = true
                }
            })
    }
```

Asi nos podremos registrar con solo un nombre de usuario en la base de datos.

![auth](img/FB_auth.png)

Si al momento de compilar te da un error del tipo "`Cannot fit requested classes in a Single Dexfile(# methods: n > 65536)`" debes ir al archivo **build.gradle(Module)** y agregar en la parte de **defaultConfig{  }** "`multiDexEnabled true`", debería verse así:

```gradle
 defaultConfig {
        applicationId "com.platzi.android.firestore"
        minSdkVersion 16
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"

        multiDexEnabled true // <--
    }
```

Tambien en **dependencies{  }** debes agregar:

```gradle
implementation 'androidx.multidex:multidex:2.0.1'
```

Y sincronizar

### La explicación del problema:

Por default los proyectos en android tienen un limite de métodos que pueden ser invocados dentro de un mismo archivo de código(Dalvik Executable (DEX)), este número es precisamente 65536, esto debido a que una APK que es compatible con versiones inferiores a android 5(API 21), trabaja con Dalvik, y ese ejecutable esta limitado a 65536 métodos, esto incluye el framework de android, dependencias y nuestro código escrito dentro de nuestro proyecto.

Técnicamente hablando, el término “kilo”, y su símbolo, “k”, hacen referencia a 1,024, por lo tanto, 64 x 1,024 es igual a 65536, exacto, nuestro número clave en este error. Este límite es denominado “límite de referencia de 64k”.

*el post completo [aquí](https://frogames.es/solucion-a-error-con-el-dexfile-en-android-studionull-cannot-fit-requested-classes-in-a-single-dexfil).*

También debemos modificar las reglas de escritura de Firestore.

el código debería verse asi:

```firestore
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /{document=**} {
      allow read, write: if true;
    }
  }
}
```

Con esto ya deberiamos poder agregar la coleccion **user** con el **username** a nuestra base de datos.