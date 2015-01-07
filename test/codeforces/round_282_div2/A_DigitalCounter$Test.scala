package codeforces.round_282_div2

import main.{UnitSpec, Utils}

class A_DigitalCounter$Test extends UnitSpec {

  val testable = A_DigitalCounter.parseSolveAndPrint _

  "test_1" should "print correct output on test" in {
    Utils.stdoutTest{
      "11"
    } {
      "49"
    } { testable }
  }

  "test_2" should "print correct output on test" in {
    Utils.stdoutTest {
      "89"
    } {
      "2"
    } { testable }
  }

  "test_3" should "print correct output on test" in {
    Utils.stdoutTest {
      "00"
    } {
      "4"
    } { testable }
  }

  "test_4" should "print correct output on test" in {
    Utils.stdoutTest {
      "73"
    } {
      "15"
    } { testable }
  }
}
