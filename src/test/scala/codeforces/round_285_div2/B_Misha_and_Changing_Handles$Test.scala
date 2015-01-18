package codeforces.round_285_div2

import test.utils.{StdoutTester, UnitSpec}

class B_Misha_and_Changing_Handles$Test extends UnitSpec {
  val testable = B_Misha_and_Changing_Handles.parseSolveAndPrint _

  "test_1" should "print correct output on test" in {
      StdoutTester {
          "5\nMisha ILoveCodeforces\nVasya Petrov\nPetrov VasyaPetrov123\nILoveCodeforces MikeMirzayanov\nPetya Ivanov"
      } {
          "3\nMisha MikeMirzayanov\nPetya Ivanov\nVasya VasyaPetrov123"
      } { testable }
  }
}
