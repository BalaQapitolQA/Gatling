package com.gatling.scenario

import com.gatling.scenario.{CreateCard,UpdatingList,CreateNewBoard,MovingList,DeleteBoard,DeleteNewBoard}
import com.gatling.scenario.CreateBoard
import com.gatling.scenario.CreateList
import io.gatling.core.Predef._
import io.gatling.http.Predef._


object TrelloScenario {

  val trelloScenario = scenario("trello APi scenario")
    .exec(CreateBoard.createBoard)
    .exec(CreateList.createList)
    .exec(CreateCard.createCard)
    .exec(UpdatingList.updatinglist)
    .exec(CreateNewBoard.createNewBoard)
    .exec(MovingList.movingListToNewboard)
    .exec(DeleteBoard.deleteBoard)
    .exec(DeleteNewBoard.deleteNewBoard)
}