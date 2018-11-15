package hmrc.shopping

final case class Price(pence: Int) extends AnyVal

object Price {
  val zero = Price(0)
}
