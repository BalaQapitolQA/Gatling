package com.gatling.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.gatling.config.Config

object DeleteBoard {

  val deleteBoard = exec(
    http("Deleting board").delete(Config.httpUrl+"/boards/${boardId}/")
      .queryParam("key",Config.trelloKey)
      .queryParam("token",Config.trelloToken)
      .check(status.is(200))
  )

}
