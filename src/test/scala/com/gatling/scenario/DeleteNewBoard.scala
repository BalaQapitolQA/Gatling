package com.gatling.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.gatling.config.Config


object DeleteNewBoard {

  val deleteNewBoard = exec(
    http("Deleting New Board").delete(Config.httpUrl+"/boards/${newBoardId}/")
      .queryParam("key",Config.trelloKey)
      .queryParam("token",Config.trelloToken)
      .check(status.is(200))
  )
}
