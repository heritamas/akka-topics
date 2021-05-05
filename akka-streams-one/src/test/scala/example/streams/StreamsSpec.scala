import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

import akka.actor.testkit.typed.scaladsl.ScalaTestWithActorTestKit

import akka.stream.scaladsl.{
  Flow,
  Keep,
  RunnableGraph,
  Sink,
  Source
}

import akka.{ Done, NotUsed }

import scala.concurrent.{ Await, Future }
import scala.concurrent.duration._

class StreamsSpec
    extends ScalaTestWithActorTestKit
    with AnyWordSpecLike
    with Matchers {

  "a producer of fixed elements 1,2,3 and a function" should {
    "allow a consumer to receive only even numbers" in {
      val producer: Source[Int, NotUsed] = Source(List(1, 2, 3))
      val processor: Flow[Int, Int, NotUsed] =
        Flow[Int].filter(_ % 2 == 0)
      val consumer: Sink[Int, Future[Seq[Int]]] = Sink.seq

      val future =
        producer.via(processor).toMat(consumer)(Keep.right).run

      val sequence = Await.result(future, 3.seconds)
      assert(sequence == List(2))
    }
  }

  "a producer of fixed elements 1,2,3 and a function" should {
    "allow when consumed see the side effects | simplestest version" in {
      var sideffect = 0

      val future = Source(List(1, 2, 3))
        .filter(_ % 2 == 0)
        .runForeach(i => sideffect += i)

      Await.result(future, 1.seconds)
      assert(sideffect == 2)
    }
  }

  "a producer of fixed elements 1,2,3 and a function" should {
    "allow when consumed see the side effects | simplest version" in {
      var sideffect = 0

      val producer = Source(List(1, 2, 3))
      val processor = Flow[Int].filter(_ % 2 == 0)

      val future =
        producer.via(processor).runForeach(i => sideffect += i)

      Await.result(future, 1.seconds)
      assert(sideffect == 2)
    }
  }

  "a producer of fixed elements 1,2,3 and a function" should {
    "allow when consumed see the side effects" in {
      var sideffect = 0

      val producer: Source[Int, NotUsed] = Source(List(1, 2, 3))
      val processor: Flow[Int, Int, NotUsed] =
        Flow[Int].filter(_ % 2 == 0)
      val consumer: Sink[Int, Future[Done]] =
        Sink.foreach(i => sideffect += i)

      // val composed: Source[Int, NotUsed] = producer.via(processor)

      // val future = composed.to(consumer).run // => this is a Keep.left so
      // it returns a Sink[Int, NotUsed] that comes from Source[Int, NotUsed]
      // the question would be; CAN I CHANGE [X, NotUsed] ? it forces you to have NotUsed actually.
      val blueprint
          : RunnableGraph[scala.concurrent.Future[akka.Done]] =
        producer.via(processor).toMat(consumer)(Keep.right)

      val future: Future[Done] = blueprint.run
      Await.result(future, 1.seconds)
      assert(sideffect == 2)
    }
  }

  // "a infinite producer"
  // "alpakka?"

}
