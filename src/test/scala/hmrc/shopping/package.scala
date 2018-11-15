package hmrc

import org.scalacheck.Gen

package object shopping {
  def itemListGen(item: Item): Gen[List[Item]] = Gen.listOf(item)
  def itemCountGen: Gen[Int] = Gen.chooseNum(0, 100)
  def priceGen: Gen[Price] = Gen.chooseNum(0, 100).map(Price(_))

  def nForMDiscountItemCountGen(n: Int, m: Int, item: Item): Gen[NForMDiscountItems] =
    for {
      multiples ← Gen.chooseNum(0, 100)
      additional ← Gen.chooseNum(0, n - 1)
    } yield NForMDiscountItems(multiples, additional, List.empty[Item].padTo(multiples * n + additional, item))
}
