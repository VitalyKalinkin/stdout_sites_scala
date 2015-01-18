package codeforces.round_286_div2

import test.utils.{StdoutTester, UnitSpec}

class A_Mr_Kitayutas_Gift$Test extends UnitSpec {
  val testable = A_Mr_Kitayutas_Gift.parseSolveAndPrint _

  "test_1" should "print correct output on test" in {
      StdoutTester {
          "revive"
      } {
          "reviver"
      } { testable }
  }

  "test_11" should "print correct output on test" in {
    StdoutTester {
      "eviver"
    } {
      "reviver"
    } { testable }
  }

  "test_111" should "print correct output on test" in {
    StdoutTester {
      "rviver"
    } {
      "reviver"
    } { testable }
  }

  "test_1111" should "print correct output on test" in {
    StdoutTester {
      "revivr"
    } {
      "reviver"
    } { testable }
  }

  "test_2" should "print correct output on test" in {
      StdoutTester {
          "ee"
      } {
          "eae"
      } { testable }
  }

  "test_21" should "print correct output on test" in {
    StdoutTester {
      "eae"
    } {
      "eaae"
    } { testable }
  }

  "test_3" should "print correct output on test" in {
      StdoutTester {
          "kitayuta"
      } {
          "NA"
      } { testable }
  }

  "test_4" should "print correct output on test" in {
      StdoutTester {
          "b"
      } {
          "bb"
      } { testable }
  }

  "test_5" should "print correct output on test" in {
      StdoutTester {
          "level"
      } {
          "levvel"
      } { testable }
  }
}
