package codeforces.round_285_div2

import test.utils.{StdoutTester, UnitSpec}

class A_Contest$Test extends UnitSpec {
  val testable = A_Contest.parseSolveAndPrint _

  "test_1" should "print correct output on test" in {
      StdoutTester {
          "500 1000 20 30"
      } {
          "Vasya"
      } { testable }
  }

  "test_2" should "print correct output on test" in {
      StdoutTester {
          "1000 1000 1 1"
      } {
          "Tie"
      } { testable }
  }

  "test_3" should "print correct output on test" in {
      StdoutTester {
          "1500 1000 176 177"
      } {
          "Misha"
      } { testable }
  }
}
