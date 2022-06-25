package com.example.domainmodule.common

sealed class Result<out E, out R> where R : Any? {
    data class Error<out E>(val errorVal: E) : Result<E, Nothing>()
    data class Success<out R>(val successVal: R) : Result<Nothing, R>()

    fun result(error: (E) -> Any, result: (R) -> Any): Any {
        return when (this) {
            is Error -> error.invoke(errorVal)
            is Success -> result.invoke(successVal)
        }
    }

    //For UT
    fun errorValue() = if (this is Error) errorVal else null
    fun successValue() = if (this is Success) successVal else null
}