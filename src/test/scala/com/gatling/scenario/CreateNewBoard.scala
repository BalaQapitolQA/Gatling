package com.gatling.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.gatling.config.Config

object CreateNewBoard {

  var newBoardId=""

  val createNewBoard = exec(
    http("Creating New Board").post(Config.httpUrl+"/boards/")
      .queryParam("key",Config.trelloKey)
      .queryParam("token",Config.trelloToken)
      .queryParam("name","Gatling New Board")
      .check(status.is(200))
      .check(jsonPath("$.name").is("Gatling New Board"))
      .check(jsonPath("$.id").saveAs("newBoardId"))
  ).exec(session => {
    newBoardId = session("newBoardId").as[String].trim
    println("%%%%%%%%%%% NEW BOARD ID =====>>>>>>>>>> " + newBoardId)
    session}
  )

}
