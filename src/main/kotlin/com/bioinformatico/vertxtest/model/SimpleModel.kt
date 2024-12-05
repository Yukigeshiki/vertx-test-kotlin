package com.bioinformatico.vertxtest.model

data class SimpleModel(val msg: String) : Model {

    override fun toString(): String {
        return "{\"msg\": \"$msg\"}"
    }
}