package assign4

import scala.util.Random
import scala.io.StdIn

object GuessingGame {

  def guess(selectedNumber: Int, attempts: Int, input: () => Int, output: String => String) : Boolean = {
    val plural = if (attempts == 1) "" else "s"
    val responses = List("Aim lower", "You guessed it in " + attempts + " attempt" + plural, "Aim higher")

    val guess_match = (selectedNumber - input()).signum

    output(responses(guess_match + 1))
    guess_match == 0
  }

  def play(selectedNumber: Int, input: () => Int, output: String => String) {
    Iterator.from(1).find { guess(selectedNumber, _, input, output) }
  }

  def main(args: Array[String]): Unit = {
    val r = new Random
    val number = r.nextInt(101) 
    play(number, () => { println("Your guess:")
      val input_guess = scala.io.StdIn.readInt()
      input_guess },
      (response: String) => { println(response)
        response })
  }
}
