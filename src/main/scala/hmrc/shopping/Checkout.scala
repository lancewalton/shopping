package hmrc.shopping

import hmrc.shopping.Item.{Apple, Orange}

object Checkout {
  val applePrice = Price(60)
  val orangePrice = Price(25)

  def calculatePrice(items: List[Item]): Price = items.groupBy(identity).mapValues(_.size).foldLeft(Price.zero) { case (total, (item, number)) ⇒
    val itemPrice = item match {
      case Apple => applePrice * (number / 2 + number % 2)
      case Orange => orangePrice * number
    }

    total + itemPrice
  }
}


