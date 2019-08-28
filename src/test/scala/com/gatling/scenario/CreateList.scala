package com.gatling.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.gatling.config.Config


object CreateList {

  var listId=""

val createList =  exec(
    http("Creating List").post(Config.httpUrl+"/lists")
      .queryParam("key",Config.trelloKey)
      .queryParam("token",Config.trelloToken)
      .queryParam("name","GatlingList")
      .queryParam("idBoard", "${boardId}")
      .check(status.is(200))
      .check(jsonPath("$.name").is("GatlingList"))
      .check(jsonPath("$.name").saveAs("listname"))
      .check(jsonPath("$.id").saveAs("listId"))
  ).exec(session => {
    listId = session("listId").as[String].trim
    println("%%%%%%%%%%% LIST ID    =====>>>>>>>>>> " + listId)
    session}
  )

}
