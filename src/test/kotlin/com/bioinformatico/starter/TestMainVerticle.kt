package com.bioinformatico.starter

import io.vertx.ext.unit.junit.RunTestOnContext
import io.vertx.ext.unit.junit.VertxUnitRunner
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(VertxUnitRunner::class)
class TestMainVerticle {

    @Rule
    @JvmField
    val rule = RunTestOnContext()

//  @Before
//  fun deploy_verticle(testContext: TestContext) {
//    val vertx = rule.vertx()
//    vertx.deployVerticle(CoroutineVerticle()).onComplete(testContext.asyncAssertSuccess())
//  }
//
//  @Test
//  fun verticle_deployed(testContext: TestContext) {
//    val async = testContext.async()
//    async.complete()
//  }
}
