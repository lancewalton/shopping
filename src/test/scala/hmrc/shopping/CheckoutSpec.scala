package hmrc.shopping

import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class CheckoutSpec extends FlatSpec with MustMatchers with GeneratorDrivenPropertyChecks {
  "calculatePrice" must "return zero for an empty shopping list" in {
    Checkout.calculatePrice(Nil) must be(Price.zero)
  }

  it must "correctly calculate the price of a basket full of apples" in {
    forAll (itemListGen(Item.Apple)) { (apples) ⇒
      Checkout.calculatePrice(apples) must be(Checkout.applePrice * apples.size)
    }
  }
}
