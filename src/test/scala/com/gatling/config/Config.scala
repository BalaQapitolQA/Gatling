package com.gatling.config

object Config {

  val httpUrl="https://api.trello.com/1"

  var trelloKey = "fbeb4ddaf008c8e45d3ff347552da4b1"

  var trelloToken = "da22230110365f4e334aef80c10c33cc4340ee43a70b49523093cb275d003ba2"

  val NUM_USERS = System.getProperty("numberOfUsersMax", "10").toInt

  val DEFAULT_RAMP_UP = 1
  val RAMP_UP_SEC = Integer.getInteger("rampUp", DEFAULT_RAMP_UP).toInt * 60

  val REQUEST_PER_SEC = System.getProperty("requestPerSec", "10").toInt

  val REACH_REQUEST_PER_SEC = System.getProperty("reachRps", "10").toInt * 60

  val HOLD_FOR = System.getProperty("holdFor", "10").toInt * 60
}
