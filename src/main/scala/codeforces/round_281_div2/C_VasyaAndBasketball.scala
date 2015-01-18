package codeforces.round_281_div2

import java.io.InputStream
import java.io.PrintStream
import java.util.Scanner

import scala.annotation.tailrec

object C_VasyaAndBasketball {

  def main(args: Array[String]) {
    parseSolveAndPrint(System.in, System.out)
  }

  def parseSolveAndPrint(in: InputStream, out: PrintStream): Unit = {
    val scanner = new Scanner(in)
    val n = scanner.nextLong()

    val firstTeam = (for (i <- 1l to n) yield {
      scanner.nextLong()
    }).sorted.toList

    val m = scanner.nextLong()

    val secondTeam = (for (i <- 1l to m) yield {
      scanner.nextLong()
    }).sorted.toList

    val throws = firstTeam.map(x => (x, 1)) ::: secondTeam.map(y => (y, 2))
    val sortedThrows = throws.sortBy(x => x._1)

    val startPoints = (sortedThrows.count(x => x._2 == 1) * 3, sortedThrows.count(x => x._2 == 2) * 3)

    @tailrec def evalPoints(startPoints : (Int, Int), throws : List[(Long, Int)], acc : List[(Int, Int)] = Nil) : List[(Int, Int)] = {
      throws match {
        case (x, 1) :: tail => evalPoints((startPoints._1 - 1, startPoints._2), tail, (startPoints._1 - 1, startPoints._2) :: acc)
        case (x, 2) :: tail => evalPoints((startPoints._1, startPoints._2 - 1), tail, (startPoints._1, startPoints._2 - 1) :: acc)
        case Nil => acc.reverse
      }
    }

    val points = startPoints :: evalPoints(startPoints, sortedThrows)
    val maxPoint = points.maxBy(x => x._1 - x._2)

    out.println(s"${maxPoint._1}:${maxPoint._2}")
  }
}

