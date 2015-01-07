package main

import java.io.{PrintStream, ByteArrayOutputStream}

class OutputGrabber {
  val byteArray : ByteArrayOutputStream = new ByteArrayOutputStream

  def writer() : PrintStream = {
    new PrintStream(byteArray)
  }

  def content() : String = {
    new String(byteArray.toByteArray)
  }
}
