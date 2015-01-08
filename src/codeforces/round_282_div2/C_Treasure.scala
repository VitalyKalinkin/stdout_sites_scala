package codeforces.round_282_div2

import java.io.InputStream
import java.io.PrintStream
import java.util.Scanner

import scala.annotation.tailrec

object C_Treasure {

  def main(args: Array[String]) {
    parseSolveAndPrint(System.in, System.out)
  }

  def parseSolveAndPrint(in: InputStream, out: PrintStream): Unit = {
    val scanner = new Scanner(in)
    val str = scanner.next()

    def balanceChecker (x: List[Char], level : Int) : List[Int] = {
      @tailrec
      def inner (x: List[Char], level : Int, acc : List[Int] = Nil) : List[Int] = {
        x match {
          case '(' :: tail => inner(tail, level + 1, level + 1 :: acc)
          case ')' :: tail => inner(tail, level - 1, level - 1 :: acc)
          case _ :: tail => inner(tail, level, level :: acc)
          case Nil => acc.reverse
        }
      }
      inner(x, level, Nil)
    }

    @tailrec def zeroFixer (l : List[Int], acc: Int, accList : List[Int] = Nil) : List[Int] = {
      l match {
        case x :: Nil => (acc + x :: accList).reverse
        case x :: tail => zeroFixer(tail, acc + x - 1, 1 :: accList)
        case Nil => accList.reverse
      }
    }

    @tailrec def stringFiller (hashes: List[Int], str: List[Char], acc : List[Char] = Nil) : List[Char] = {
      str match {
          case '#' :: tail => stringFiller(hashes.tail, tail, (")" * hashes.head).toCharArray.toList ::: acc)
          case x :: tail => stringFiller(hashes, tail, x :: acc)
          case Nil => acc.reverse
      }
    }

    val chars = str.toCharArray.toList
    val charRanks = balanceChecker(chars, 0)

    val hashRanks = chars.zip(charRanks).filter(_._1 == '#').map(_._2)
    val hashRankDiffButLast = hashRanks.zip(hashRanks.drop(1)).map(x => x._2 - x._1)
    val lastItem = charRanks.last - hashRankDiffButLast.sum

    if (hashRanks.last < charRanks.last) {
      out.println(-1)
      return
    }

    val hashRankDiffFixed = zeroFixer(hashRankDiffButLast :+ lastItem, 0)
    val strFilledValidation = balanceChecker(stringFiller(hashRankDiffFixed, chars), 0)


    /*println(chars)
    println(charRanks)
    println(hashRankDiffFixed)
    println(strFilledValidation)
    */

    if (hashRankDiffFixed.exists(_ <= 0) || strFilledValidation.last != 0 || strFilledValidation.exists(_ < 0)) {
      out.println(-1)
    } else for (x <- hashRankDiffFixed) {
      out.println(x)
    }
  }
}

