require './src/guess_game'

puts "I've selected a number, can you guess it?"

play(rand(0..100), lambda {
  print "Your guess:"
  gets.to_i
}, method(:puts))