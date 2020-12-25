FileStream fileIn: 'src/RodCutting.st'.

Object subclass: RodCuttingTest [

  runTests: functionName [
    (1 = 1) ifFalse: [^self error: 'Canary test failed'].

    ((functionName value:(Dictionary new) value: 1) = 0) ifFalse: [^self error: 'Test for empty price list failed'].
    
    ((functionName value: (Dictionary from: {1 -> 5}) value: 1) = 5) ifFalse: [^self error: 'Test for length 1 where price for 1 is present in the price list failed'].

    ((functionName value: (Dictionary from: {1 -> 1. 2 -> 3}) value: 2) = 3) ifFalse: [^self error: 'Test for length 2 where prices for 1 and 2 are present in the price list failed'].

    ((functionName value: (Dictionary from: {1 -> 1. 3 -> 4}) value: 2) = 2) ifFalse: [^self error: 'Test for length 2 where prices for 1 and 3 are present in the price list failed'].

    ((functionName value: (Dictionary from: {1 -> 2. 2 -> 1}) value: 2) = 4) ifFalse: [^self error: 'Test for length 2 where prices for 1 and 2 are present in the price list, but twice of price 1 is greater than price for length 2 failed'].
    
    ((functionName value: (Dictionary from: {1 -> 5. 2 -> 5. 3 -> 1. 4 -> 1. 5 -> 4}) value: 5) = 25) ifFalse: [^self error: 'Test for length 5 where prices for 1 through 5 are present in the price list, but the total price of lengths 1, 2, 2 is greater than price for 5 failed'].

    ^self
  ]

  measureTime: functionName [
    | time |

    time := Time millisecondsToRun:[( functionName value:(Dictionary from: {1 -> 5. 2 -> 3. 3 -> 2. 4 -> 7. 5 -> 5. 6 -> 1. 7 -> 6.
       8 -> 4. 9 -> 4. 10 -> 2. 11 -> 3. 12 -> 7. 13 -> 2. 14 -> 5. 15 -> 1. 16 -> 6. 17 -> 8. 
       18 -> 1. 19 -> 8. 20 -> 2}) value: 20)].

    ^time
  ]

]

tester := RodCuttingTest new.
Transcript show: 'Recursive Rod Cutting Tests'; cr.
tester runTests: [:a :b | RodCutting new recursiveRodCutting: a and: b].
Transcript show: 'Memoized Rod Cutting Tests'; cr.
tester runTests: [:a :b | RodCutting new memoizedRodCutting: a and: b].
Transcript show: 'Comparing Execution Time'; cr.

recursiveExecutionTime := tester measureTime: [:a :b | RodCutting new recursiveRodCutting: a and: b].
memoizedExecutionTime := tester measureTime: [:a :b | RodCutting new memoizedRodCutting: a and: b].

((recursiveExecutionTime >= (10 * memoizedExecutionTime))) ifFalse: [^self error: 'Recursive execution time is not at least 10 times the memoized execution time'].
Transcript show: 'Testing complete'; cr.
