def guess(selected_number, attempts, input, output)
  plural = 's' unless attempts == 1
  responses = ['Aim lower', "You guessed it in #{attempts} attempt#{plural}", "Aim higher"]
  
  guess_match = selected_number <=> input.call
  output.call(responses[guess_match + 1])
  
  guess_match == 0
end

def play(selected_number, input, output)
  (1..).take_while { |attempt| !guess(selected_number, attempt, input, output) }
end
