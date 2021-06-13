package com.platzi.android.firestore.network

import java.lang.Exception

// recibe un tipo generico de dato para poder mapear cualquier resultado
interface Callback<T> {

    fun onSuccess(result: T?)

    fun onFailed(exception: Exception)
}