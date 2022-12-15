package deliveryteaminkotlin.members

import deliveryteaminkotlin.story.Story
import kotlin.random.Random

data class BA(override val name: String) : Member() {
  override fun work() {
    val nextInt = Random.nextInt(1, 4)
    val stories = team!!.stories!!.toMutableList()
    IntRange(1, nextInt).forEach { stories.add(Story("randomCard${it}")) }
    team!!.stories = stories
  }
}
