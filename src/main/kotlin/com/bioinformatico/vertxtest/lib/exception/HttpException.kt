package com.bioinformatico.vertxtest.lib.exception

/**
 * Custom response exception for HTTP errors.
 */
class HttpResponseException(val statusCode: Int, override val message: String) : Throwable()