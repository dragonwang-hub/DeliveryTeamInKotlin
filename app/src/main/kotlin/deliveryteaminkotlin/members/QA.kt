package deliveryteaminkotlin.members

import deliveryteaminkotlin.story.Story
import deliveryteaminkotlin.story.StoryStatus

data class QA(override val name: String) : Member() {
  override fun work() {
    team!!.stories?.let {
      val shouldBeDoneCard = it.filter { story -> story.status == StoryStatus.TEST }
          .take(2)
          .map(Story::card)

      it.forEach { story ->
        if (shouldBeDoneCard.contains(story.card)) {
          story.status = StoryStatus.DONE
        }
      }
      it
    }
  }

}
