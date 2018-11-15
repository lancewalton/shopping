package hmrc.shopping

import hmrc.shopping.Item.{Apple, Orange}

object Checkout {
  val applePrice = Price(60)
  val orangePrice = Price(25)

  def calculatePrice(items: List[Item]): Price = items.foldLeft(Price.zero) { (total, item) ⇒
    val itemPrice = item match {
      case Apple => applePrice
      case Orange => orangePrice
    }

    total + itemPrice
  }
}


