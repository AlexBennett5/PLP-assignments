package assign4

import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer
import assign4.GuessingGame

class GuessingGameTest extends FunSuite {
  
  test("canary") {
    assert(true)
  }

  test("testCorrectGuessInOneAttempt") {
    var received = ""
    GuessingGame.guess(10, 1, () => 10, (response: String) => { 
      received = response 
      received})
    assert("You guessed it in 1 attempt" == received)
  }

  test("testGuessLowerThanSelectedNumber") {
    var received = ""
    GuessingGame.guess(10, 1, () => 9, (response: String) => {
      received = response
      received})
    assert("Aim higher" == received)
  }

  test("testGuessHigherThanSelectedNumber") {
    var received = ""
    GuessingGame.guess(10, 1, () => 11, (response: String) => {
      received = response
      received})
    assert("Aim lower" == received)
  }

  test("testGuessCorrectInTwoAttempts") {
    var received = ""
    GuessingGame.guess(10, 2, () => 10, (response: String) => {
      received = response
      received})
    assert("You guessed it in 2 attempts" == received)
  }

  test("testGuessReturnsTrueOnCorrectGuessWithOneAttempt") {
    assert(GuessingGame.guess(10, 1, () => 10, (response: String) => response))
  }

  test("testGuessReturnsTrueOnCorrectGuessWithAnyAttempts") {
    assert(GuessingGame.guess(10, 5, () => 10, (response: String) => response))
  }

  test("testGuessReturnsFalseOnIncorrectGuess") {
    assert(!GuessingGame.guess(10, 1, () => 9, (response: String) => response))
  }

  test("testPlayCorrectGuessInOneAttempt") {
    var received = ""

    GuessingGame.play(20, () => 20, (response: String) => {
      received = response
      received})
    assert("You guessed it in 1 attempt" == received)
  }

  test("testPlayLowerThenCorrectValueOnSecondAttempt") {
    var received : ArrayBuffer[String] = ArrayBuffer()
    var inputs = ArrayBuffer(15, 20)

    GuessingGame.play(20, () => { val choice = inputs.head 
      inputs.remove(0)
      choice}, 
      (response: String) => {
      received.append(response)
      received(0)})
    assert(ArrayBuffer("Aim higher", "You guessed it in 2 attempts") == received)
  }

  test("testPlayHigherThenCorrectValueOnSecondAttempt") {
    var received : ArrayBuffer[String] = ArrayBuffer()
    var inputs = ArrayBuffer(25, 20)

    GuessingGame.play(20, () => { val choice = inputs.head
      inputs.remove(0)
      choice},
      (response: String) => {
      received.append(response)
      received(0)})
    assert(ArrayBuffer("Aim lower", "You guessed it in 2 attempts") == received)
  }

  test("testPlayLowerThenHigherThenCorrectValueOnThirdAttempt") {
    var received : ArrayBuffer[String] = ArrayBuffer()
    var inputs = ArrayBuffer(5, 20, 15)

    GuessingGame.play(15, () => { val choice = inputs.head
      inputs.remove(0)
      choice},
      (response: String) => {
      received.append(response)
      received(0)})
    assert(ArrayBuffer("Aim higher", "Aim lower", "You guessed it in 3 attempts") == received)
  }

  test("testPlayHigherThenLowerThenCorrectValueOnThirdAttempt") {
    var received : ArrayBuffer[String] = ArrayBuffer()
    var inputs = ArrayBuffer(25, 10, 15)

    GuessingGame.play(15, () => { val choice = inputs.head
      inputs.remove(0)
      choice},
      (response: String) => {
      received.append(response)
      received(0)})
    assert(ArrayBuffer("Aim lower", "Aim higher", "You guessed it in 3 attempts") == received)
  }
}
