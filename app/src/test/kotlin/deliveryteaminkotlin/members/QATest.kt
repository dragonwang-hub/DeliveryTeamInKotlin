package deliveryteaminkotlin.members

import deliveryteaminkotlin.Team
import deliveryteaminkotlin.story.Story
import deliveryteaminkotlin.story.StoryStatus
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QATest {

  @Test
  fun shouldMoveTwoCardFromTESTToDONEWhenQAWork() {
//    given QA with the team
    val qaOne = QA("qaOne")

    val teamTG = Team()
    val storyOne = Story("cardOne", StoryStatus.TEST)
    val storyTwo = Story("cardTwo", StoryStatus.TEST)
    val stories = listOf(storyOne, storyTwo)
    teamTG.stories = stories
    qaOne.team = teamTG

//    when qa work
    qaOne.work()
//    the first two cards will to be DONE
    val result = qaOne.team?.stories!!
    assertEquals(StoryStatus.DONE, result.find { it.card == "cardOne" }?.status)
    assertEquals(StoryStatus.DONE, result.find { it.card == "cardTwo" }?.status)
  }

  @Test
  fun shouldMoveOneCardFromTESTToDONEWhenQAWorkAndOnlyOneCardInTEST() {
//    given QA with the team
    val qaOne = QA("qaOne")

    val teamTG = Team()
    val storyOne = Story("cardOne", StoryStatus.TEST)
    val storyTwo = Story("cardTwo", StoryStatus.DEVELOP)
    val stories = listOf(storyOne, storyTwo)
    teamTG.stories = stories
    qaOne.team = teamTG

//    when qa work
    qaOne.work()
//    the only one cards will to be DONE
    val result = qaOne.team?.stories!!
    assertEquals(StoryStatus.DONE, result.find { it.card == "cardOne" }?.status)
    assertEquals(0, result.filter { it.status == StoryStatus.TEST }.size)
  }

  @Test
  fun shouldJusMoveTwoCardFromTESTToDONEWhenQAWorkAndEvenHave3CardInTEST() {
//    given QA with the team
    val qaOne = QA("qaOne")

    val teamTG = Team()
    val storyOne = Story("cardOne", StoryStatus.TEST)
    val storyTwo = Story("cardTwo", StoryStatus.TEST)
    val storyThr = Story("cardThr", StoryStatus.TEST)
    val stories = listOf(storyOne, storyTwo, storyThr)
    teamTG.stories = stories
    qaOne.team = teamTG

//    when qa work
    qaOne.work()
//    the only two cards will to be DONE
    val result = qaOne.team?.stories!!
    assertEquals(StoryStatus.DONE, result.find { it.card == "cardOne" }?.status)
    assertEquals(StoryStatus.DONE, result.find { it.card == "cardTwo" }?.status)
    assertEquals(StoryStatus.TEST, result.find { it.card == "cardThr" }?.status)
  }
}
