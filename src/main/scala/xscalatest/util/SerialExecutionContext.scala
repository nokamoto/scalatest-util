package xscalatest.util

import scala.concurrent.ExecutionContext

/**
 * A `SerialExecutionContext` executes program logic synchronously rather than asynchronously so that execution of
 * `Future` can be serial in test cases.
 */
class SerialExecutionContext extends ExecutionContext {
  override def execute(runnable: Runnable): Unit = runnable.run()

  override def reportFailure(cause: Throwable): Unit = ExecutionContext.defaultReporter(cause)
}

object SerialExecutionContext {
  object Implicits {
    implicit val global = new SerialExecutionContext
  }

  val global = Implicits.global
}
