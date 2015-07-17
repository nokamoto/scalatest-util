package xscalatest.util

import org.scalatest.FunSpec

import scala.concurrent._
import scala.concurrent.duration._

class SerialExecutionContextSpec extends FunSpec {
  describe("SerialExecutionContext") {
    it("executes synchronously") {
      import xscalatest.util.SerialExecutionContext.Implicits.global
      var x = 0
      val future = Future {
        x = x + 1
        blocking(Thread.sleep(2.seconds.toMillis))
        x = x + 1
        x
      }
      assert(x == 2)
      assert(Await.result(future, 1.seconds) == 2)
    }
  }
}
