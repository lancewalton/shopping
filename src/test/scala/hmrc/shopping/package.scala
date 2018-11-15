package hmrc

import org.scalacheck.Gen

package object shopping {
  def itemListGen(item: Item): Gen[List[Item]] = Gen.nonEmptyListOf(item)
  def itemCountGen: Gen[Int] = Gen.posNum[Int]
  def priceGen: Gen[Price] = Gen.posNum[Int].map(Price(_))
}
