package assign1

import scala.collection.mutable

object Name {
  def imperativeAverageNumberOfLetters(names : List[String]) : Double = {
    if (names.isEmpty) {
      0.0
    } else {
      var sum = 0.0

      for (name <- names){
        sum += name.length()
      }

      sum / names.length
    }
  }


  def imperativeGroupNamesByFirstLetter(names: List[String]): mutable.Map[Char, List[String]] = {
    val groupedNames = mutable.Map[Char, List[String]]()

    for (name <- names){
      val firstCharacter = name(0)

      if (!groupedNames.contains(firstCharacter)) {
        groupedNames(firstCharacter) = List()
      }

      groupedNames(firstCharacter) = groupedNames(firstCharacter) ::: List(name)
    }

    groupedNames
  }

  def imperativeCountNamesStartingWithEachLetter(names : List[String]): mutable.Map[Char, Int] ={
    val countedNames = mutable.Map[Char, Int]()

    for (name <- names){
      val firstCharacter = name(0)

      if (!countedNames.contains(firstCharacter)) {
        countedNames.addOne(firstCharacter -> 0)
      }

      countedNames(firstCharacter) = countedNames(firstCharacter) + 1
    }

    countedNames
  }

  def functionalAverageNumberOfLettersInName(names : List[String]) : Double = {
    if (names.isEmpty){
      0.0
    }else{
      names.map(_.length).sum.toDouble / names.length.toDouble
    }
  }
  
  def functionalGroupNamesByFirstLetter(names : List[String]) : Map[Char, List[String]] = {
    if (names.isEmpty) {
      Map.empty[Char, List[String]]
    } else {
      names.groupBy(_(0))
    }
  }

  def functionalCountNamesStartingWithEachLetter(names : List[String]) : Map[Char, Int] = {
    if (names.isEmpty) {
      Map.empty[Char, Int]
    } else {
      names.groupBy(_(0)).map { case(key, value) => key -> value.size }
    }
  }

  def main(args : Array[String]) : Unit = {
    val names = List("Fadi", "Timothy", "Derrick", "Omar", "Hiep", "Alexander", "Daniel", "Isela", "Jackqueline", "Bryan", "Nguyen", "Maxim", "Edgar", "Ahson", "Abdulkadir", "En-Kai", "Karla", "Panpan", "You", "Andrew", "Trevor", "Hoang", "Johnson", "Janelle", "Moujie", "MD", "Albert", "Jiahui", "Alejandro", "Venkat")

    println("Imperative implementation")
    println("Average number of letters in name: " + imperativeAverageNumberOfLetters(names))
    println("Group names by first letter: " + imperativeGroupNamesByFirstLetter(names))
    println("Count names starting with each letter: " + imperativeCountNamesStartingWithEachLetter(names))
    
    println("Functional implementation")
    println("Average number of letters in name: " + functionalAverageNumberOfLettersInName(names))
    println("Group names by first letter: " + functionalGroupNamesByFirstLetter(names))
    println("Count names starting with each letter: " + functionalCountNamesStartingWithEachLetter(names))
  }
}
