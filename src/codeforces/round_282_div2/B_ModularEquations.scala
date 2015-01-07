package codeforces.round_282_div2

import java.io.InputStream
import java.io.PrintStream
import java.util.Scanner

object B_ModularEquations {

  def main(args: Array[String]) {
    parseSolveAndPrint(System.in, System.out)
  }

  def parseSolveAndPrint(in: InputStream, out: PrintStream): Unit = {
    val scanner = new Scanner(in)
    val a = scanner.nextLong()
    val b = scanner.nextLong()

    if (a == b) {
      out.println("infinity")
    } else if (a < b ) {
      out.println("0")
    } else {
      val diff = a - b

      val candidates = for (x <- 1l to Math.sqrt(diff).floor.toLong if diff % x == 0) yield x
      val answerPart1 = for (x <- candidates if x > b) yield x
      val answerPart2 = for (x <- candidates if diff / x > b && x * x != diff) yield diff / x

      val answers = answerPart1 ++ answerPart2

      out.println(answers.size)
    }
  }
}

