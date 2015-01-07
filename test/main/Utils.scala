package main

import java.io.{PrintStream, InputStream, ByteArrayInputStream}
import java.nio.charset.Charset

object Utils extends UnitSpec {
   def toStream(str : String) : InputStream = {
     new ByteArrayInputStream(str.getBytes(Charset.forName("utf-8")))
   }

  def test(input : String, testable : (InputStream, PrintStream) => Unit) : String = {
    val outputGrabber = new OutputGrabber
    testable(toStream(input + "\n"), outputGrabber.writer())
    outputGrabber.content()
  }

  def stdoutTest(input : String)(expected : String)(testable : (InputStream, PrintStream) => Unit) : Unit = {
    assertResult(expected + "\n") {
      test(input + "\n", testable)
    }
  }
}
