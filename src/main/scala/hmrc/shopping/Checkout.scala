package hmrc.shopping

object Checkout {
  val applePrice = Price(60)

  def calculatePrice(items: List[Item]): Price = applePrice * items.size
}


