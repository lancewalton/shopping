package hmrc.shopping

import hmrc.shopping.Item.{Apple, Orange}

object Checkout {
  val applePrice = Price(60)
  val orangePrice = Price(25)

  def calculatePrice(items: List[Item]): Price = items.groupBy(identity).mapValues(_.size).foldLeft(Price.zero) { case (total, (item, number)) ⇒
    val itemPrice = item match {
      case Apple => nForMDiscountPrice(applePrice, number, 2, 1)
      case Orange => nForMDiscountPrice(orangePrice, number, 3, 2)
    }

    total + itemPrice
  }

  private def nForMDiscountPrice(unitPrice: Price, number: Int, n: Int, m: Int): Price = unitPrice * (number / n * m + number % n)
}


