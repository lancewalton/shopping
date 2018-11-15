package hmrc.shopping

import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class CheckoutSpec extends FlatSpec with MustMatchers with GeneratorDrivenPropertyChecks {
  "calculatePrice" must "return zero for an empty shopping list" in {
    Checkout.calculatePrice(Nil) must be(Price.zero)
  }

  it must "correctly calculate the price of a basket with a mixture of apples and oranges" in {
    forAll (itemListGen(Item.Apple), itemListGen(Item.Orange)) { (apples, oranges) ⇒
      Checkout.calculatePrice(apples ::: oranges) must be(Checkout.applePrice * apples.size + Checkout.orangePrice * oranges.size)
    }
  }
}
