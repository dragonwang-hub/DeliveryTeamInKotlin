package deliveryteaminkotlin

import deliveryteaminkotlin.annotations.NoArg
import deliveryteaminkotlin.members.Member
import deliveryteaminkotlin.story.Story

@NoArg
data class Team(val members: List<Member>, val stories: List<Story>)
