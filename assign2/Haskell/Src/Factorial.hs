module Src.Factorial where

factorialIterative givenNumber = product [1..givenNumber]

regularRecursiveFactorial 0 = 1
regularRecursiveFactorial givenNumber = givenNumber * regularRecursiveFactorial (givenNumber - 1)

tailRecursiveFactorial givenNumber = tailRecursive givenNumber 1 where
  tailRecursive givenNumber factorial = if givenNumber <= 1 then factorial else tailRecursive (givenNumber - 1) (factorial * givenNumber)
