package codeforces.round_282_div2

import main.{Utils, UnitSpec}

class B_ModularEquations$Test extends UnitSpec {
  val testable = B_ModularEquations.parseSolveAndPrint _

  "test_1" should "print correct output on test" in {
    Utils.stdoutTest {
      "21 5"
    } {
      "2"
    } {
      testable
    }
  }

  "test_2" should "print correct output on test" in {
    Utils.stdoutTest {
      "9435152 272"
    } {
      "282"
    } {
      testable
    }
  }

  "test_3" should "print correct output on test" in {
    Utils.stdoutTest {
      "10 10"
    } {
      "infinity"
    } {
      testable
    }
  }

  "test_4" should "print correct output on test" in {
    Utils.stdoutTest {
      "772930485 686893955"
    } {
      "0"
    } {
      testable
    }
  }

  "test_5" should "print correct output on test" in {
    Utils.stdoutTest {
      "11 2"
    } {
      "2"
    } {
      testable
    }
  }
}
