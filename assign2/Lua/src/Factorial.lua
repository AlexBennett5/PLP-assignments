local fun = require 'src.fun'

function iterativeFactorial(number)
  if (number < 2) then
    return 1
  else
    return fun.product(fun.range(1, number))
  end
end

function recursiveFactorial(number)
  if (number < 2) then
	  return 1
  else
	  return number * recursiveFactorial(number - 1)
  end
end

function tailRecursiveFactorial(number, currentResult)
  if (number < 2) then
	  return (currentResult or 1)
  else
	  return tailRecursiveFactorial(number - 1, number * (currentResult or 1))
  end
end
