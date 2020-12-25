Object subclass: RodCutting [
  recursiveRodCutting: prices and: length [
    |range possiblePrices|
  
    (prices isEmpty or: [length = 0]) ifTrue: [^0].
    
    ^((Interval from: 1 to: length) collect: [:cut | (prices at: cut ifAbsent: [0]) + 
        (self recursiveRodCutting: prices and: (length - cut))]) fold: [:a :b | a max: b].      
  ]

  memoizedRodCutting: prices and: length [
    ^((self computeMemoizedPrices: prices and: (Dictionary new) and: length) at: length).
  ]

  computeMemoizedPrices: prices and: maxPrices and: length [

    (maxPrices includesKey: length)
      ifTrue: [^maxPrices].

    (prices isEmpty or: [length = 0]) ifTrue: [^maxPrices,  (Dictionary from: {length -> 0})].

    ^(1 to: length) inject: maxPrices into:
      [:accumulatedMaxPrices :cut
        ||maxPricesComputed maxPriceForPart newMaxPrice|

        maxPricesComputed := self computeMemoizedPrices: prices and: accumulatedMaxPrices and: (length - cut).
        maxPriceForPart := (prices at: cut ifAbsent: [0]) + (maxPricesComputed at: (length - cut) ifAbsent: [0]).
        newMaxPrice := (maxPricesComputed, (Dictionary from: {length -> (maxPriceForPart max: (maxPricesComputed at: length ifAbsent: [0]))})).
        newMaxPrice
      ].
  ]
]
