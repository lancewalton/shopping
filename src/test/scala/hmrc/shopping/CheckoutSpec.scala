package hmrc.shopping

import org.scalatest._

class CheckoutSpec extends FlatSpec with MustMatchers {
  "calculatePrice" must "return zero for an empty shopping list" in {
    Checkout.calculatePrice(Nil) must be(Price.zero)
  }
}
