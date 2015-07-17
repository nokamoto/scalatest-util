package xscalatest.util

import org.scalatest.FunSpec

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._

class FutureValuesSpec extends FunSpec with FutureValues {
  def sleep() = blocking(Thread.sleep(10.seconds.toMillis))

  val shortTimeout = 1.seconds

  describe("FutureValues") {
    it("rendezvous for serial execution") {
      val future = Future(100)
      assert(future.rendezvous() === 100)
    }

    it("rendezvous timeout if exceeds at most duration") {
      val future = Future {
        sleep()
        100
      }
      intercept[TimeoutException](future.rendezvous(shortTimeout))
    }
  }
}
