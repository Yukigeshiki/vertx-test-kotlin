package com.bioinformatico.vertxtest.lib.response

import com.bioinformatico.vertxtest.model.Model
import java.util.*

/**
 * Request success response.
 */
data class Success(
    val requestId: UUID,
    val payload: Model,
    val status: String = "success"
) {

    override fun toString(): String {
        return "{\"requestId\": $requestId, \"payload\": $payload, \"status\": \"$status\"}"
    }
}