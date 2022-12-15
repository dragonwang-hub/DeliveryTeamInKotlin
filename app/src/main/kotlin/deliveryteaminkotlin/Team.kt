package deliveryteaminkotlin

import deliveryteaminkotlin.members.Member
import deliveryteaminkotlin.story.Story

data class Team(val members: List<Member>, val stories: List<Story>)
