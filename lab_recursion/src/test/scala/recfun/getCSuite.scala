package recfun

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class getCSuite extends AnyFunSuite {
  import Main.getC
  test("getC: out of D(f)") {
    assert(getC(-3) === None)
  }
  test("getC: from 1 to 2") {
    assert(getC(1.2) === 1.2)
  }
  test("getC: >2") {
    assert(getC(4.3) === 335.4)
  }
}
