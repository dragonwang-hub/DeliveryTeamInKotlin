package deliveryteaminkotlin.members

import deliveryteaminkotlin.Team
import deliveryteaminkotlin.story.Story
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
}
