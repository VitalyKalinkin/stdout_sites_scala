package codeforces.round_281_div2

import java.io.InputStream
import java.io.PrintStream
import java.util.Scanner

object C_VasyaAndBasketball {

  def main(args: Array[String]) {
    parseSolveAndPrint(System.in, System.out)
  }

  def parseSolveAndPrint(in: InputStream, out: PrintStream): Unit = {
    val scanner = new Scanner(in)
    val n = scanner.nextLong()

    val firstTeam = (for (i <- 1l to n) yield {
      scanner.nextLong()
    }).sorted

    val m = scanner.nextLong()

    val secondTeam = (for (i <- 1l to m) yield {
      scanner.nextLong()
    }).sorted


    out.println("put_result_here")
  }
}

