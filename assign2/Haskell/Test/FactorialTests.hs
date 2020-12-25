import Src.Factorial
import System.Exit
import System.IO

exitWithErrorMessage :: String -> ExitCode -> IO a
exitWithErrorMessage str e = hPutStrLn stderr str >> exitWith e

assert :: Bool -> String -> IO ()
assert True str = pure()
assert False str = exitWithErrorMessage str (ExitFailure 2)

testSuite :: (Integer -> Integer) -> String -> IO ()
testSuite function functionName = do 
  assert (function 0 == 1) (functionName ++ " with Zero failed")
  assert (function 1 == 1) (functionName ++ " with One failed")
  assert (function 6 == 720) (functionName ++ " with Six failed")
  assert (function 12 == 479001600) (functionName ++ " with Twelve failed")
  assert (function 50 == 30414093201713378043612608166064768844377641568960512000000000000) (functionName ++ "with Fifty failed")

main :: IO()
main = do
  assert True "Canary Test Failed"
  testSuite factorialIterative "Iterative"
  testSuite regularRecursiveFactorial "Regular Recursive"
  testSuite tailRecursiveFactorial "Tail Recursive"
  putStrLn "Testing complete, no errors"
