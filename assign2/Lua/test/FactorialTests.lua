require "src.Factorial"

assert(true == true, "Canary Test Fails")

function runTests(factorialFunction, functionName)
  assert(factorialFunction(0) == 1, functionName .. " Factorial with Zero Fails")
  assert(factorialFunction(1) == 1, functionName .. " Factorial with One Fails")
  assert(factorialFunction(6) == 720, functionName .. " Factorial with Six Fails")
  assert(factorialFunction(12) == 479001600, functionName .. " Factorial with Twelve Fails")
end

runTests(iterativeFactorial, "Iterative")
runTests(recursiveFactorial, "Recursive")
runTests(tailRecursiveFactorial, "Tail Recursive")

print("Test complete, no errors")
