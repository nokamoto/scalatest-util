package xscalatest.util

import org.scalacheck.Arbitrary

trait ArbitraryValues {
  def sample[A](implicit a: Arbitrary[A]): A = Stream.continually(a.arbitrary.sample).flatten.head

  class Unique[A](implicit arb: Arbitrary[A]) {
    private[this] var set: Set[A] = Set.empty[A]
    
    def next(): A = synchronized {
      val a = Stream.continually(sample[A]).filter(s => !set.contains(s)).head
      set = set + a
      a
    }
  }

  def unique[A](implicit a: Arbitrary[A]): Unique[A] = new Unique[A]()
}
