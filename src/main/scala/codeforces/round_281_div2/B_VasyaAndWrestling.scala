package codeforces.round_281_div2

import java.io.InputStream
import java.io.PrintStream
import java.util.Scanner

object B_VasyaAndWrestling {

  def main(args: Array[String]) {
    parseSolveAndPrint(System.in, System.out)
  }

  def parseSolveAndPrint(in: InputStream, out: PrintStream): Unit = {
    val scanner = new Scanner(in)
    val n = scanner.nextInt()

    val input = for (i <- 1 to n) yield {
      scanner.nextLong()
    }

    val firstPoints = input.filter(_ > 0)
    val secondPoints = input.filter(_ < 0).map(-_)

    if (firstPoints.sum != secondPoints.sum) {
      out.println(if (firstPoints.sum > secondPoints.sum) "first" else "second")
    } else {
      val firstNotNull = firstPoints.zip(secondPoints).map(x => x._1 - x._2).find(_ != 0)
      firstNotNull match {
        case Some(x) =>
          out.println(if (x > 0) "first" else "second")
        case None =>
          out.println(if (input.last > 0) "first" else "second")
      }
    }
  }
}

