package com.gatling.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.gatling.config.Config

object CreateCard {

  var cardId=""

val createCard = exec(
    http("Creating Card").post(Config.httpUrl+"/cards")
      .queryParam("key",Config.trelloKey)
      .queryParam("token",Config.trelloToken)
      .queryParam("name","GatlingCard")
      .queryParam("idList", "${listId}")
      .check(status.is(200))
      .check(jsonPath("$.name").is("GatlingCard"))
      .check(jsonPath("$.name").saveAs("cardname"))
      .check(jsonPath("$.id").saveAs("cardId"))
  ).exec(session => {
  cardId = session("cardId").as[String].trim
  println("%%%%%%%%%%% CARD ID     =====>>>>>>>>>> " + cardId)
  session}
)
}
