package deliveryteaminkotlin

import deliveryteaminkotlin.annotations.NoArg
import deliveryteaminkotlin.members.Member
import deliveryteaminkotlin.story.Story

@NoArg
data class Team(var members: List<Member>?, var stories: List<Story>?) {
  fun getMembers(memberTypeFilter: (Member) -> Boolean): List<Member> {
    return members!!.filter(memberTypeFilter)
  }

  constructor() : this(null, null)
}
