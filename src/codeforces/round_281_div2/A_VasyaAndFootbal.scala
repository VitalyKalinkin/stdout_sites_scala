package codeforces.round_281_div2

import java.io.InputStream
import java.io.PrintStream
import java.util.Scanner

import scala.annotation.tailrec

object A_VasyaAndFootbal {

  def main(args: Array[String]) {
    parseSolveAndPrint(System.in, System.out)
  }

  def parseSolveAndPrint(in: InputStream, out: PrintStream): Unit = {
    val scanner = new Scanner(in)
    val homeTeam = scanner.next()
    val awayTeam = scanner.next()

    val n = scanner.nextInt()

    val input = for (i <- 1 to n) yield {
      val time = scanner.nextInt()
      val teamId = scanner.next()
      val playerId = scanner.nextInt()
      val cardType = scanner.next()

      val teamName = teamId match {
        case "a" => awayTeam
        case "h" => homeTeam
      }

      (time, teamName, playerId, cardType)
    }

    //result (team, playerId, time, cardsCount)
    @tailrec def process (l : List[(Int, String, Int, String)], acc : Map[String, (String, Int, Int, Int)] = Map.empty) : Map[String, (String, Int, Int, Int)] = {
      l match {
        case x :: tail => {
          val playerId = x._2 + "_" + x._3
          val cardPoints = x._4 match {
            case "y" => 1
            case "r" => 2
            case _ => 0
          }

          val cardsCount = if (acc.contains(playerId)) acc(playerId)._4 else 0

          if (cardsCount >= 2) {
            process(tail, acc)
          } else {
            process(tail, acc + (playerId -> (x._2, x._3, x._1, cardsCount + cardPoints)))
          }
        }
        case Nil => acc
      }
    }


    val result = process(input.toList).filter(x => x._2._4 >= 2).toList.map(_._2).sortBy(x => x._3)

    for (x <- result) {
      out.println(s"${x._1} ${x._2} ${x._3}")
    }
  }
}

