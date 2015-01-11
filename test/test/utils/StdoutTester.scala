package test.utils

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, InputStream, PrintStream}
import java.nio.charset.Charset

object StdoutTester extends UnitSpec {
   private def toStream(str : String) : InputStream = {
     new ByteArrayInputStream(str.getBytes(Charset.forName("utf-8")))
   }

  private def test(input : String, testable : (InputStream, PrintStream) => Unit) : String = {
    val outputGrabber = new OutputGrabber
    testable(toStream(input + "\n"), outputGrabber.writer())
    outputGrabber.content()
  }

  def apply(input : String)(expected : String)(testable : (InputStream, PrintStream) => Unit) : Unit = {
    test(input + "\n", testable) shouldBe expected + "\n"
  }

  private class OutputGrabber {
    val byteArray : ByteArrayOutputStream = new ByteArrayOutputStream

    def writer() : PrintStream = {
      new PrintStream(byteArray)
    }

    def content() : String = {
      new String(byteArray.toByteArray)
    }
  }
}
