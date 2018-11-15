package hmrc

import org.scalacheck.Gen

package object shopping {
  def itemListGen(item: Item): Gen[List[Item]] = Gen.listOf(item)
  def itemCountGen: Gen[Int] = Gen.chooseNum(0, 100)
  def priceGen: Gen[Price] = Gen.chooseNum(0, 100).map(Price(_))
}
