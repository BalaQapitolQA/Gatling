package com.gatling.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.gatling.config.Config

object MovingList {

  val movingListToNewboard = exec(
    http("Moving List to New board").put(Config.httpUrl+"/lists/${listId}/idBoard")
      .queryParam("key",Config.trelloKey)
      .queryParam("token",Config.trelloToken)
      .queryParam("value","${newBoardId}")
      .check(status.is(200))
  )

}
