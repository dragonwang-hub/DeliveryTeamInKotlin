package deliveryteaminkotlin.members

import deliveryteaminkotlin.story.Story
import deliveryteaminkotlin.story.StoryStatus
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DEVTest {

  @Test
  fun shouldFinishedDevelopWorkWhenDEVWork() {
//    given a dev with story
    val storyOne = Story("cardOne", StoryStatus.DEVELOP)
    val devOne = DEV("devOne")
    devOne.story = storyOne

//    when dev work
    devOne.work()

//    the card assigned to dev will to be TEST
    assertEquals(StoryStatus.TEST, devOne.story?.status)
  }

  @Test
  fun shouldDoNothingWhenDEVDoNotHaveCard() {
//    given a dev with no story
    val devOne = DEV("devOne")

//    when dev work
    devOne.work()

//    the card assigned to dev will to be null and will not have exception
    assertEquals(null, devOne.story?.status)
  }
}
