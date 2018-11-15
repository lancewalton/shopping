package hmrc.shopping

import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class PriceSpec extends FlatSpec with MustMatchers with GeneratorDrivenPropertyChecks {
  "*" must "multiply the price by the count" in {
    forAll (priceGen, itemCountGen) { (price, count) ⇒
      price * count must be(Price(price.pence * count))
    }
  }

  "+" must "add the two prices together" in {
    forAll (priceGen, priceGen) { (price1, price2) ⇒
      price1 + price2 must be(Price(price1.pence + price2.pence))
    }
  }
}
