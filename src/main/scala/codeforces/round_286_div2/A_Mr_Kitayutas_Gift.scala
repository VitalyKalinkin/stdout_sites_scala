package codeforces.round_286_div2

import java.io.InputStream
import java.io.PrintStream
import java.util.Scanner

object A_Mr_Kitayutas_Gift {

  def main(args: Array[String]) {
    parseSolveAndPrint(System.in, System.out)
  }

  def parseSolveAndPrint(in: InputStream, out: PrintStream): Unit = {
    val scanner = new Scanner(in)
    val str = scanner.next()

    def findInsertionPoints(str : String, lo : Int, hi: Int, acc : Seq[(Int, Char)] = Nil) : Seq[(Int, Char)] = {
      (lo, hi) match {
        case (l, h) if l > h => acc
        case (l, h) =>
          if (str.charAt(l) == str.charAt(h))
            findInsertionPoints(str, l + 1, h - 1, acc)
          else {
            val loResult = findInsertionPoints(str, l, h - 1, acc :+ (l, str.charAt(h)))
            val hiResult = findInsertionPoints(str, l + 1, h, acc :+ (h + 1, str.charAt(l)))

            if (loResult.size < hiResult.size)
              loResult
            else
              hiResult
          }
      }
    }

    val insertionPoints = findInsertionPoints(str, 0, str.length - 1)

    if (insertionPoints.size == 1) {
      val point = insertionPoints.head
      val newStr = str.substring(0, point._1) + point._2 + str.substring(point._1)
      out.println(newStr)
    } else if (insertionPoints.size == 0) {
      if (str.size % 2 == 0) {
        val newStr = str.substring(0, str.size / 2) + 'a' + str.substring(str.size / 2)
        out.println(newStr)
      } else {
        val newStr = str.substring(0, str.size / 2) + str.charAt(str.size / 2) + str.charAt(str.size / 2) + str.substring(str.size / 2 + 1)
        out.println(newStr)
      }
    } else {
      out.println("NA")
    }
  }
}

