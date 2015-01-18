package codeforces.round_281_div2

import test.utils.{StdoutTester, UnitSpec}

class C_VasyaAndBasketball$Test extends UnitSpec {
  val testable = C_VasyaAndBasketball.parseSolveAndPrint _

  "test_1" should "print correct output on test" in {
      StdoutTester {
        "3\n1 2 3\n2\n5 6"
      } {
        "9:6"
      } { testable }
  }

  "test_2" should "print correct output on test" in {
      StdoutTester {
        "5\n6 7 8 9 10\n5\n1 2 3 4 5"
      } {
        "15:10"
      } { testable }
  }

  "test_3" should "print correct output on test" in {
      StdoutTester {
          "8\n1 3 5 7 9 11 13 15\n8\n2 4 6 8 10 12 14 16"
      } {
          "24:24"
      } { testable }
  }
}
