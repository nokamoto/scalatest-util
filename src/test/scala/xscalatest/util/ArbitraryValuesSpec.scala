package xscalatest.util

import org.scalacheck.{Gen, Arbitrary}
import org.scalatest.FunSpec

class ArbitraryValuesSpec extends FunSpec with ArbitraryValues {
  case class A(a: Int, b: String, c: Boolean)

  implicit val arbitrary: Arbitrary[A] = Arbitrary(Gen.resultOf(A.apply _))

  describe("ArbitraryValues") {
    it("sample returns arbitrary values") {
      assert(List.fill(1000)(sample[A]).toSet.size > 1)
    }

    it("unique returns unique values") {
      val uq = unique[A]
      val size = 1000
      assert(List.fill(size)(uq.next()).toSet.size === size)
    }
  }
}
