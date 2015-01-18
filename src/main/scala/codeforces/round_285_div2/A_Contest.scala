package codeforces.round_285_div2

import java.io.InputStream
import java.io.PrintStream
import java.util.Scanner

object A_Contest {

  def main(args: Array[String]) {
    parseSolveAndPrint(System.in, System.out)
  }

  def parseSolveAndPrint(in: InputStream, out: PrintStream): Unit = {
    val scanner = new Scanner(in)
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()
    val d = scanner.nextInt()

    def getPoints(p : Int, t : Int) =
      Math.max(3 * p / 10, p - p / 250 * t)

    val pointsM = getPoints(a, c)
    val pointsV = getPoints(b, d)

    out.println(if (pointsM > pointsV) "Misha" else if (pointsM < pointsV) "Vasya" else "Tie")
  }
}

