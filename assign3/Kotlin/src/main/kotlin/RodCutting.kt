package src.main.kotlin

object RodCutting {
  fun recursiveRodCutting(prices: Map<Int, Int>, length: Int): Int {
    if (length <= 0 || prices.isEmpty()) {
      return 0
    }
    
    return (1..length).toList().map { prices.getOrDefault(it, 0) + recursiveRodCutting(prices, length - it) }?.max() ?: 0
  }

  fun memoizationRodCutting(prices: Map<Int, Int>, length: Int) : Int{
    fun computeMaxPrices(length: Int, maxPrices: Map<Int, Int>): Map<Int, Int>{
      if(maxPrices.containsKey(length)){
        return maxPrices
      }

      if(length == 0 || prices.isEmpty()){
        return maxPrices + Pair(length, 0)
      }

      return (1..length).fold(maxPrices) { accumulatedMaxPrices, cut ->
        val maxPricesComputed = computeMaxPrices(length - cut, accumulatedMaxPrices) 
        val maxPriceForPart = prices.getOrDefault(cut, 0) + maxPricesComputed.getOrDefault(length - cut, 0)

        maxPricesComputed + (length to Math.max(maxPriceForPart, maxPricesComputed.getOrDefault(length, 0)))
      }
    }

    return computeMaxPrices(length, mapOf()).getValue(length)
  }
}
