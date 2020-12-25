package src.test.kotlin

import io.kotlintest.specs.StringSpec
import io.kotlintest.shouldBe
import kotlin.system.measureTimeMillis
import src.main.kotlin.RodCutting.recursiveRodCutting
import src.main.kotlin.RodCutting.memoizationRodCutting

class RodCuttingTest : StringSpec() {

  fun runTests(rodCutting: (Map<Int, Int>, Int) -> Int, functionName: String){
    "$functionName Test for empty price list" {
      rodCutting(mapOf(), 1) shouldBe 0
    }
  
    "$functionName Test for length 1 where price of 1 is present in the price list" {
      rodCutting(mapOf(1 to 5), 1) shouldBe 5
    }
  
    "$functionName Test for length 2 where prices for 1 and 2 are present in price list" {
      rodCutting(mapOf(1 to 1, 2 to 3), 2) shouldBe 3
    }

    "$functionName Test for length 2 where price list has prices for only length 1 and 3" {
      rodCutting(mapOf(1 to 1, 3 to 4), 3) shouldBe 4
    }
  
    "$functionName Test for length 2 where price list has prices for length 1 and 2, but twice price of length 1 is greater than price for length 2" {
      rodCutting(mapOf(1 to 2, 2 to 1), 2) shouldBe 4
    }
  
    "$functionName Test for length 5 where the price list has prices for lengths 1 to 5, but the total price of lengths 1, 2, 2 is greater than price for 5" {
      rodCutting(mapOf(1 to 5, 2 to 5, 3 to 1, 4 to 1, 5 to 4), 5) shouldBe 25
    }
  }

  init {
    "canary test should pass" {
      true shouldBe true
    }

    runTests({prices: Map<Int, Int>, length: Int -> recursiveRodCutting(prices, length)}, "recursion")
    runTests({prices: Map<Int, Int>, length: Int -> memoizationRodCutting(prices, length)}, "memoization")

    "recursive execution time should be at least 10 times the memoization execution time"{
      fun measureTime(rodCutting: (Map<Int, Int>, Int) -> Int): Long{
        return measureTimeMillis { rodCutting(
          mapOf(1 to 5, 2 to 3, 3 to 2, 4 to 7, 5 to 5, 6 to 1, 7 to 6, 8 to 4, 9 to 4, 10 to 2, 
          11 to 3, 12 to 7, 13 to 2, 14 to 5, 15 to 1, 16 to 6, 17 to 8, 18 to 1, 19 to 8, 20 to 2), 
          20) 
        }
      }
      
      val recursiveExecutionTime = measureTime(::recursiveRodCutting)
      val memoizationExecutionTime = measureTime(::memoizationRodCutting)  

      assert(recursiveExecutionTime >= (10 * memoizationExecutionTime))
    }
    
  }  
}