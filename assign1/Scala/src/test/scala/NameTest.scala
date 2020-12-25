package assign1

import org.scalatest.FunSuite
import assign1.Name

class NameTest extends FunSuite {

  test("canary"){
    assert(true)
  }

  test("imperativeAverageWithEmptyList"){
    assert(Name.imperativeAverageNumberOfLetters(List()) == 0)
  }

  test("imperativeAverageWithOneNameInList"){
    assert(Name.imperativeAverageNumberOfLetters(List("Derrick")) == 7)
  }

  test("imperativeAverageWithTwoNamesOfSameLengthInList"){
    assert(Name.imperativeAverageNumberOfLetters(List("Omar", "Hiep")) == 4)
  }

  test("imperativeAverageWithTwoNamesOfDifferentLengthInList"){
    assert(Name.imperativeAverageNumberOfLetters(List("Derrick", "Al")) == 4.5)
  }

  test("imperativeAverageWithThreeNamesOfDifferentLengthInList"){
    assert(Name.imperativeAverageNumberOfLetters(List("Derrick", "Alexander", "Ira")) == 19.0/3.0)
  }

  test("imperativeGroupNamesByFirstLetterWithEmptyList"){
    assert(Name.imperativeGroupNamesByFirstLetter(List()) == Map())
  }

  test("imperativeGroupNamesByFirstLetterWithOneName"){
    assert(Name.imperativeGroupNamesByFirstLetter(List("Jim")) == Map('J' -> List("Jim")))
  }

  test("imperativeGroupNamesByFirstLetterWithTwoNamesWithSameStartingLetter"){
    assert(Name.imperativeGroupNamesByFirstLetter(List("Jim", "Jack")) == Map('J' -> List("Jim", "Jack")))
  }

  test("imperativeGroupNamesByFirstLetterWithThreeNamesWithDifferentStartingLetters"){
    assert(Name.imperativeGroupNamesByFirstLetter(List("Jim", "Jack", "Sara")) ==
      Map('J' -> List("Jim", "Jack"), 'S' -> List("Sara")))
  }

  test("imperativeCountNamesStartingWithEachLetterWithEmptyList"){
    assert(Name.imperativeCountNamesStartingWithEachLetter(List()) == Map())
  }

  test("imperativeCountNamesStartingWithEachLetterWithOneName"){
    assert(Name.imperativeCountNamesStartingWithEachLetter(List("Jim")) == Map('J' -> 1))
  }

  test("imperativeCountNamesStartingWithEachLetterWithTwoNamesWithSameStartingLetter"){
    assert(Name.imperativeCountNamesStartingWithEachLetter(List("Jim", "Jack")) == Map('J' -> 2))
  }

  test("imperativeCountNamesStartingWithEachLetterWithThreeNamesWithDifferentStartingLetters"){
    assert(Name.imperativeCountNamesStartingWithEachLetter(List("Jim", "Jack", "Sara")) == Map('J' -> 2, 'S' -> 1))
  }

  test("functionalAverageWithEmptyList"){
    assert(Name.functionalAverageNumberOfLettersInName(List()) == 0.0)
  }

  test("functionalAverageWithOneNameInList"){
    assert(Name.functionalAverageNumberOfLettersInName(List("Derrick")) == 7.0)
  }

  test("functionalAverageWithTwoNamesOfSameLengthInList"){
    assert(Name.functionalAverageNumberOfLettersInName(List("Omar", "Hiep")) == 4.0)
  }

  test("functionalAverageWithTwoNamesOfDifferentLengthInList"){
    assert(Name.functionalAverageNumberOfLettersInName(List("Derrick", "Alexander")) == 8.0)
  }

  test("functionalAverageWithThreeNamesOfDifferentLengthInList"){
    assert(Name.functionalAverageNumberOfLettersInName(List("Derrick", "Alexander", "Ira")) == 19.0/3.0)
  }

  test("functionalGroupNamesByFirstLetterEmptyList") {
    assert(Name.functionalGroupNamesByFirstLetter(List()) == Map())
  }

  test("functionalGroupNamesByFirstLetterOneName") {
    assert(Name.functionalGroupNamesByFirstLetter(List("Jim")) == Map('J' -> List("Jim")))
  }

  test("functionalGroupNamesByFirstLetterTwoNamesSameLetter") {
    assert(Name.functionalGroupNamesByFirstLetter(List("Jim", "Jack")) == Map('J' -> List("Jim", "Jack")))
  }

  test("functionalGroupNamesByFirstLetterTwoNamesDifferentLetters") {
    assert(Name.functionalGroupNamesByFirstLetter(List("Jim", "Jack", "Sara")) == Map('J' -> List("Jim", "Jack"), 'S' -> List("Sara")))
  }

  test("functionalCountNamesStartingWithEachLetterWithEmptyList"){
    assert(Name.functionalCountNamesStartingWithEachLetter(List()) == Map())
  }

  test("functionalCountNamesStartingWithEachLetterWithOneName"){
    assert(Name.functionalCountNamesStartingWithEachLetter(List("Jim")) == Map('J' -> 1))
  }

  test("functionalCountNamesStartingWithEachLetterWithTwoNamesWithSameStartingLetter"){
    assert(Name.functionalCountNamesStartingWithEachLetter(List("Jim", "Jack")) == Map('J' -> 2))
  }

  test("functionalCountNamesStartingWithEachLetterWithThreeNamesWithDifferentStartingLetters"){
    assert(Name.functionalCountNamesStartingWithEachLetter(List("Jim", "Jack", "Sara")) == Map('J' -> 2, 'S' -> 1))
  }
}
