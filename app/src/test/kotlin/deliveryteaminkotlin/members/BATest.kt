package deliveryteaminkotlin.members

import deliveryteaminkotlin.Team
import deliveryteaminkotlin.story.Story
import deliveryteaminkotlin.story.StoryStatus
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BATest {

  @Test
  fun shouldGenerate1To3CardsWhenWork() {
//    given ba with the team(0cards)
    val baOne = BA("baOne")

    val teamTG = Team()
    val storyOne = Story("cardOne")
    val stories = listOf(storyOne)
    teamTG.stories = stories
    baOne.team = teamTG
//    when ba work
    baOne.work()

//    team has 1~3 cards
    val storiesSize = baOne.team?.stories!!.size
    assertTrue(storiesSize in 2..4)
  }

  @Test
  fun shouldAssignCardsToAllFreeDEV() {
//    given
    val baOne = BA("baOne")
    val devOne = DEV("devOne")
    val devTwo = DEV("devTwo")
    val devThr = DEV("devOne")
    devThr.story = Story("card", StoryStatus.DEVELOP)

    val teamTG = Team()
    val storyOne = Story("cardOne")
    val storyTwo = Story("cardTwo")
    val storyThr = Story("cardThr")
    val stories = listOf(storyOne, storyTwo, storyThr)
    val members = listOf(baOne, devOne, devTwo, devThr)
    teamTG.stories = stories
    teamTG.members = members
    baOne.team = teamTG
//    when
    baOne.assignReadyCards()

//    then
    assertNotNull((teamTG.getMembers { member: Member -> member is DEV }.all { (it as DEV).story != null }))
    assertNotNull((teamTG.members?.find { it.name == "devOne" } as DEV).story)
    assertNotNull((teamTG.members?.find { it.name == "devTwo" } as DEV).story)
    assertEquals(StoryStatus.DEVELOP, teamTG.stories?.find { it.card == "cardOne" }?.status)
    assertEquals(StoryStatus.DEVELOP, teamTG.stories?.find { it.card == "cardTwo" }?.status)
  }

  @Test
  fun shouldAssignAllReadyCardsToFreeDEVWhenCardsLessThanFreeDEVs() {
//    given
    val baOne = BA("baOne")
    val devOne = DEV("devOne")
    val devTwo = DEV("devTwo")
    val devThr = DEV("devOne")

    val teamTG = Team()
    val storyOne = Story("cardOne")
    val storyTwo = Story("cardTwo")
    val stories = listOf(storyOne, storyTwo)
    val members = listOf(baOne, devOne, devTwo, devThr)
    teamTG.stories = stories
    teamTG.members = members
    baOne.team = teamTG
//    when
    baOne.assignReadyCards()

//    then
    assertNotNull((teamTG.getMembers { member: Member -> member is DEV }.all { (it as DEV).story != null }))
    assertNotNull((teamTG.members?.find { it.name == "devOne" } as DEV).story)
    assertNotNull((teamTG.members?.find { it.name == "devTwo" } as DEV).story)
    assertEquals(StoryStatus.DEVELOP, teamTG.stories?.find { it.card == "cardOne" }?.status)
    assertEquals(StoryStatus.DEVELOP, teamTG.stories?.find { it.card == "cardTwo" }?.status)
  }
}
