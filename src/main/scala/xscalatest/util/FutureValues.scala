package xscalatest.util

import org.scalatest.Suite

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

trait FutureValues {
  this: Suite =>
  val defaultAtMost = 10.seconds

  implicit class Rendezvous[A](future: Future[A]) {
    /**
     * @see [[Await.result]]
     */
    def rendezvous(atMost: Duration = defaultAtMost): A = Await.result(future, atMost)
  }
}
