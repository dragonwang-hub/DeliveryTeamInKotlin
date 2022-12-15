package deliveryteaminkotlin.members

import deliveryteaminkotlin.Team

abstract class Member {
  open var team: Team? = null
  open val name: String = "Anonymous"
  abstract fun work(): Unit
}
