package deliveryteaminkotlin.members

import deliveryteaminkotlin.story.Story
import deliveryteaminkotlin.story.StoryStatus

data class DEV(override val name: String) : Member() {

  var story: Story? = null

  override fun work() {
    story?.let {
      it.status = StoryStatus.TEST
    }
  }
}
