package hmrc.shopping

final case class Price(pence: Int) extends AnyVal {
  def *(count: Int): Price = Price(pence * count)
}

object Price {
  val zero = Price(0)
}
