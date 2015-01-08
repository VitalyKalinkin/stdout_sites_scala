package codeforces.round_281_div2

import main.{Utils, UnitSpec}

class B_VasyaAndWrestling$Test extends UnitSpec {
  val testable = B_VasyaAndWrestling.parseSolveAndPrint _

  "test_1" should "print correct output on test" in {
    Utils.stdoutTest {
      "5\n1\n2\n-3\n-4\n3"
    } {
      "second"
    } {
      testable
    }
  }

  "test_2" should "print correct output on test" in {
    Utils.stdoutTest {
      "3\n-1\n-2\n3"
    } {
      "first"
    } {
      testable
    }
  }

  "test_3" should "print correct output on test" in {
    Utils.stdoutTest {
      "2\n4\n-4"
    } {
      "second"
    } {
      testable
    }
  }

  "test_4" should "print correct output on test" in {
    Utils.stdoutTest {
      "6\n-3\n-1\n-2\n3\n1\n2\n"
    } {
      "first"
    } {
      testable
    }
  }
}
