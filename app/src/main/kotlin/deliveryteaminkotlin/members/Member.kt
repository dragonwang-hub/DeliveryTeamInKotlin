package deliveryteaminkotlin.members

abstract class Member {
  open val name: String = "Anonymous"
  abstract fun work() : Unit
}
