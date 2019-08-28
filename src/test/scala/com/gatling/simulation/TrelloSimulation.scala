package com.gatling.simulation

import com.gatling.scenario.TrelloScenario
import com.gatling.config.Config._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class TrelloSimulation extends Simulation {

  //setUp(TrelloScenario.trelloScenario.inject(atOnceUsers(1)))

  setUp(TrelloScenario.trelloScenario.inject(rampUsers(NUM_USERS) over(RAMP_UP_SEC)).throttle(
    reachRps(REQUEST_PER_SEC) in (REACH_REQUEST_PER_SEC),holdFor(HOLD_FOR)))
}