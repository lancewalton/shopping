package hmrc.shopping

sealed trait Item extends Product with Serializable

object Item {
  case object Apple extends Item
}