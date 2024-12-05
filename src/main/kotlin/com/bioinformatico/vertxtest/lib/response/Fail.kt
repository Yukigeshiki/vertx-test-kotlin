package com.bioinformatico.vertxtest.lib.response

import java.util.*

/**
 * Request failed response.
 */
data class Fail(
    val requestId: UUID,
    val error: String,
    val status: String = "failed"
) {

    override fun toString(): String {
        return "{\"requestId\": $requestId, \"error\": \"$error\", \"status\": \"$status\"}"
    }
}