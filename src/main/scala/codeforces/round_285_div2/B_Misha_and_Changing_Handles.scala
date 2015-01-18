package codeforces.round_285_div2

import java.io.InputStream
import java.io.PrintStream
import java.util.Scanner

object B_Misha_and_Changing_Handles {

  def main(args: Array[String]) {
    parseSolveAndPrint(System.in, System.out)
  }

  def parseSolveAndPrint(in: InputStream, out: PrintStream): Unit = {
    val scanner = new Scanner(in)
    val n = scanner.nextInt()

    val requests = for (i <- 1 to n) yield {
      (scanner.next(), scanner.next())
    }

    def processRequest (requests : List[(String, String)], acc: Map[String, Item] = Map()) : Map[String, Item] = {
      requests match {
        case (old_name, new_name) :: tail if acc contains old_name =>  {
          val old_item = acc(old_name)
          val new_item = new Item(old_item.initial, new_name)
          processRequest(tail, acc - old_name + (new_name -> new_item))
        }
        case (old_name, new_name) :: tail => {
          val new_item = new Item(old_name, new_name)
          processRequest(tail, acc + (new_name -> new_item))
        }
        case Nil => acc
      }
    }

    val map = processRequest(requests.toList)

    out.println(map.size)
    for (res <- map.toSeq.sortBy(x => x._2.initial)) {
      out.println(s"${res._2.initial} ${res._2.current}")
    }
  }

  case class Item(initial : String, current : String) {
  }
}

