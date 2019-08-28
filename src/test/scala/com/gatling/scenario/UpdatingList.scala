package com.gatling.scenario

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import com.gatling.config.Config

object UpdatingList {

  val updatinglist = exec(
    http("Updating List").put(Config.httpUrl+"/lists/${listId}")
      .queryParam("key",Config.trelloKey)
      .queryParam("token",Config.trelloToken)
      .queryParam("name", "Updated List")
      .check(status.is(200))
      .check(jsonPath("$.name").is("Updated List"))
  )

}
