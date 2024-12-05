package com.bioinformatico.vertxtest.router

import com.bioinformatico.vertxtest.handler.ApiHandler
import com.bioinformatico.vertxtest.lib.extension.coroutineHandler
import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler
import io.vertx.ext.web.handler.CorsHandler
import io.vertx.ext.web.handler.LoggerHandler
import io.vertx.ext.web.handler.ResponseTimeHandler

/**
 * Returns an application router.
 */
fun supplyRouter(
    vertx: Vertx,
    apiHandler: ApiHandler
): Router = Router.router(vertx).apply {

    setGlobalSettings()

    get("/healthcheck").coroutineHandler { ctx -> apiHandler.healthCheck(ctx) }
}

/**
 * Adds global routing settings to the application.
 */
fun Router.setGlobalSettings() {

    // Log requests
    route("/*").handler(LoggerHandler.create())
    route("/*").handler(ResponseTimeHandler.create())

    // Accept body in POST, PUT requests
    route(HttpMethod.POST, "/*").handler(BodyHandler.create())
    route(HttpMethod.PUT, "/*").handler(BodyHandler.create())

    // Configure CORS
    route().handler(
        CorsHandler.create()
            .allowedMethods(
                setOf(
                    HttpMethod.GET,
                    HttpMethod.POST,
                    HttpMethod.PUT,
                    HttpMethod.DELETE
                )
            )
            .allowedHeaders(
                setOf(
                    "Authorization",
                    "Content-Type",
                    "Access-Control-Allow-Headers",
                    "Access-Control-Allow-Origin",
                    "Access-Control-Request-Method"
                )
            )
    )
}