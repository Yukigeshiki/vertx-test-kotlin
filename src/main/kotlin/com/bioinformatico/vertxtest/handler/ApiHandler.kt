package com.bioinformatico.vertxtest.handler

import com.bioinformatico.vertxtest.lib.exception.HttpResponseException
import com.bioinformatico.vertxtest.lib.response.Fail
import com.bioinformatico.vertxtest.lib.response.Success
import com.bioinformatico.vertxtest.model.Model
import com.bioinformatico.vertxtest.model.SimpleModel
import io.netty.handler.codec.http.HttpResponseStatus
import io.vertx.core.impl.logging.LoggerFactory
import io.vertx.core.json.Json
import io.vertx.ext.web.RoutingContext
import java.util.*

class ApiHandler {


    private val logger = LoggerFactory.getLogger(this::class.java)

    /**
     * Healthcheck handler function.
     */
    fun healthCheck(ctx: RoutingContext) {
        val payload = SimpleModel("It's alive!")
        val requestId = UUID.randomUUID()
        try {
            supplyJSONSuccessResponse(ctx, requestId, payload, HttpResponseStatus.OK)
        } catch (e: Throwable) {
            supplyErrorResponse(ctx, requestId, e)
        }
    }

    /**
     * Returns a success response.
     */
    private fun supplyJSONSuccessResponse(
        ctx: RoutingContext,
        requestId: UUID,
        payload: Model,
        statusCode: HttpResponseStatus
    ) =
        ctx.response()
            .setStatusCode(statusCode.code())
            .putHeader("Content-Type", "application/json")
            .end(
                Json.encode(
                    Success(requestId, payload).also { logger.info(it) }
                )
            )

    /**
     * Returns an error response.
     */
    private fun supplyErrorResponse(ctx: RoutingContext, requestId: UUID, e: Throwable) = ctx.response()
        .setStatusCode(
            if (e is HttpResponseException) e.statusCode else HttpResponseStatus.INTERNAL_SERVER_ERROR.code()
        )
        .putHeader("Content-Type", "application/json")
        .end(
            Json.encode(
                Fail(requestId, e.message ?: "Unknown error!").also { logger.info(it) }
            )
        )
}