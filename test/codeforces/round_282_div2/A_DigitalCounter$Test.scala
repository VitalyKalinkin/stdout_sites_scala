package codeforces.round_282_div2

import main.{UnitSpec, StdoutTester}

class A_DigitalCounter$Test extends UnitSpec {

  val testable = A_DigitalCounter.parseSolveAndPrint _

  "test_1" should "print correct output on test" in {
    StdoutTester{
      "11"
    } {
      "49"
    } { testable }
  }

  "test_2" should "print correct output on test" in {
    StdoutTester {
      "89"
    } {
      "2"
    } { testable }
  }

  "test_3" should "print correct output on test" in {
    StdoutTester {
      "00"
    } {
      "4"
    } { testable }
  }

  "test_4" should "print correct output on test" in {
    StdoutTester {
      "73"
    } {
      "15"
    } { testable }
  }
}
