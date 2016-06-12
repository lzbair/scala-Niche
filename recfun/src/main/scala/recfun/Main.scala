package recfun
import common._
import scala.collection.immutable.Stack
object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
	if(c == 0 || c == r) 1
	else pascal(c, r-1) + pascal(c-1, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
	
	def check(chars: List[Char], opened : List[Char]): Boolean = {
    if (chars.isEmpty) opened.isEmpty
    else if (chars.head == ')'){  
	    if(opened.isEmpty) false else check(chars.tail, opened.tail)
	}
    else if (chars.head == '(') check(chars.tail, '('::opened)
	else check(chars.tail, opened)
    }
	
    check(chars, List.empty[Char])
  }                                              


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0) 1 
	else if(money < 0 || coins.isEmpty) 0
	else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}