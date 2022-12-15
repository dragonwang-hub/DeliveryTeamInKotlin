package deliveryteaminkotlin.story

data class Story(val card: String, val status: StoryStatus) {
  constructor(card: String) : this(card, status = StoryStatus.READY)
}
