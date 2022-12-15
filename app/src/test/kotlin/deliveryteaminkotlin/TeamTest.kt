package deliveryteaminkotlin

import deliveryteaminkotlin.members.BA
import deliveryteaminkotlin.members.DEV
import deliveryteaminkotlin.members.Member
import deliveryteaminkotlin.members.QA
import deliveryteaminkotlin.story.Story
import deliveryteaminkotlin.story.StoryStatus
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TeamTest {

  @Test
  fun shouldAssignMembersAndStoriesToOneTeam() {
//    given init team and members, story
    val team = Team::class.java.getDeclaredConstructor().newInstance()

    val memberBA = BA("baOne")
    val memberDEV = DEV("devOne")
    val memberQA = QA("qaOne")
    val members = listOf(memberBA, memberDEV, memberQA)

    val storyOne = Story("cardOne")
    val storyTwo = Story("cardTwo")
    val stories = listOf(storyOne, storyTwo)

//    when assign member and story to team
    team.members = members
    team.stories = stories

//    then team has three member and two story
    assertAll(
        { assertEquals(3, team.members.size) },
        { assertEquals(2, team.stories.size) },
        { assertEquals(StoryStatus.READY, team.stories.get(0).status) }
    )
  }
}
