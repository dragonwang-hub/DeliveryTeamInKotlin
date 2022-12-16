package deliveryteaminkotlin.members

import deliveryteaminkotlin.story.Story
import deliveryteaminkotlin.story.StoryStatus
import java.util.LinkedList
import kotlin.random.Random

@Suppress("UNCHECKED_CAST")
data class BA(override val name: String) : Member() {
  override fun work() {
    val nextInt = Random.nextInt(1, 4)
    val stories = team!!.stories!!.toMutableList()
    IntRange(1, nextInt).forEach { stories.add(Story("randomCard${it}")) }
    team!!.stories = stories
  }

  fun assignReadyCards() {
    val readyCards = team?.stories?.filter { it.status == StoryStatus.READY }.orEmpty()
    val freeDEVs: List<DEV> = team?.getMembers { member: Member -> member is DEV && member.story == null }
        .orEmpty() as List<DEV>

    val canBeAssignedCount = readyCards.size.coerceAtMost(freeDEVs.size)
    val canBeAssignedCards = LinkedList(readyCards.take(canBeAssignedCount))

    freeDEVs.take(canBeAssignedCount).forEach {
      val card = canBeAssignedCards.poll()
      assignCardToDEV(card, it)
    }
  }

  fun assignCardToDEV(card: Story, dev: DEV) {
    if (dev.story != null) {
      throw RuntimeException("can't assign card to busy dev")
    }
    dev.story = card
    card.status = StoryStatus.DEVELOP
  }
}
