package com.bioinformatico.vertxtest

import com.bioinformatico.vertxtest.handler.ApiHandler
import com.bioinformatico.vertxtest.router.supplyRouter
import io.vertx.kotlin.coroutines.CoroutineVerticle
import io.vertx.kotlin.coroutines.coAwait

class MainVerticle : CoroutineVerticle() {

    override suspend fun start() {

        // Start the server
        vertx.createHttpServer()
            .requestHandler(
                supplyRouter(
                    vertx,
                    ApiHandler()
                )
            )
            .listen(config.getInteger("http.port", 8080))
            .coAwait()
    }
}