package hmrc.shopping

import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class CheckoutSpec extends FlatSpec with MustMatchers with GeneratorDrivenPropertyChecks {
  "calculatePrice" must "return zero for an empty shopping list" in {
    Checkout.calculatePrice(Nil) must be(Price.zero)
  }

  it must "correctly discount apples" in {
    forAll (nForMDiscountItemCountGen(2, 1, Item.Apple)) {
      case NForMDiscountItems(multiples, additional, apples) ⇒
        Checkout.calculatePrice(apples) must be(Checkout.applePrice * multiples + Checkout.applePrice * additional)
    }
  }

  it must "correctly discount oranges" in {
    forAll (nForMDiscountItemCountGen(3, 2, Item.Orange)) {
      case NForMDiscountItems(multiples, additional, oranges) ⇒
        Checkout.calculatePrice(oranges) must be(Checkout.orangePrice * multiples * 2 + Checkout.orangePrice * additional)
    }
  }

  it must "correctly calculate the price of a basket with a mixture of apples and oranges" in {
    forAll (itemListGen(Item.Apple), itemListGen(Item.Orange)) { (apples, oranges) ⇒
      Checkout.calculatePrice(apples ::: oranges) must be(Checkout.calculatePrice(apples) + Checkout.calculatePrice(oranges))
    }
  }
}
