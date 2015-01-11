package codeforces.round_282_div2

import java.io.{InputStream, PrintStream}
import java.util.Scanner

object A_DigitalCounter {
  val mapping = Map(
    0 -> Seq(0, 8),
    1 -> Seq(0, 1, 3, 4, 7, 8, 9),
    2 -> Seq(2, 8),
    3 -> Seq(3, 8, 9),
    4 -> Seq(4, 8, 9),
    5 -> Seq(5, 6, 8, 9),
    6 -> Seq(5, 6),
    7 -> Seq(0, 3, 7, 8, 9),
    8 -> Seq(8),
    9 -> Seq(8, 9)
  )

  def main(args: Array[String]) {
    parseSolveAndPrint(System.in, System.out)
  }

  def parseSolveAndPrint(in : InputStream, out : PrintStream) : Unit = {
    val scanner = new Scanner(in)
    val n = scanner.next()

    val result = n.toCharArray.toList.map(_.toString.toInt).map(mapping(_).size).reduce(_ * _)

    out.println(result)
  }
}

