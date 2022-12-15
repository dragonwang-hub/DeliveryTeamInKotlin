package deliveryteaminkotlin

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TeamTest {

  @BeforeEach
  fun setUp() {
  }

  @AfterEach
  fun tearDown() {
  }

  @Test
  fun shouldAssignMembersAndStoriesToOneTeam() {
    val team = Team::class.java.getDeclaredConstructor().newInstance()
  }
}
