package com.gatling.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.gatling.config.Config


object CreateBoard {

  var boardId=""

  val createBoard = exec(
    http("Creating Board").post(Config.httpUrl+"/boards/")
      .queryParam("key",Config.trelloKey)
      .queryParam("token",Config.trelloToken)
      .queryParam("name","Gatling")
      .check(status.is(200))
      .check(jsonPath("$.name").is("Gatling"))
      .check(jsonPath("$.id").saveAs("boardId"))
  ).exec(session => {
    boardId = session("boardId").as[String].trim
    session
  }.set("boardId",boardId))
}