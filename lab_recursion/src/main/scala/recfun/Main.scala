package recfun

import java.util.Spliterator.OfPrimitive
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println("CountChange")
    print(countChange(301, List(5,10,20,50,100,200,500)))
    println()
    println("GetC for -2")
    print(getC(-2))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || (c == r)) 1
      else
        pascal(c-1, r-1) + pascal(c, r - 1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      @tailrec
      def innerBalance(chars: List[Char], openBrackets: Int): Boolean = {
        if (chars.isEmpty) openBrackets == 0
        else
          if (chars.head == '(') innerBalance(chars.tail, openBrackets + 1)
          else
            if (chars.head == ')') openBrackets > 0 && innerBalance(chars.tail,openBrackets - 1)
            else innerBalance(chars.tail, openBrackets)
      }
      innerBalance(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      val sortedList = coins.sorted
      def innerCountChange(coinsIndex: Int, money: Int): Int = {
        if (sortedList.isEmpty) 0
        else if (money < 0) 0
        else if (coinsIndex == 0)
          if (money % sortedList(0) == 0) 1
          else 0
        else innerCountChange(coinsIndex - 1, money) + innerCountChange(coinsIndex, money - sortedList(coinsIndex))
      }
      innerCountChange(coins.length - 1, money)
    }

  /**
   * Exercise 4
   * Variant 1
   */
    def getC(x: Double): Any = {
      def innerGetC(x: Double, k: Int): Double = {
        if (k == 1) x
        else k * x + innerGetC(x, k - 1)
      }
      if (x < 2 && x > 1) x
      else if (x >= 2) innerGetC(x, 12)
      else None
    }

  }
