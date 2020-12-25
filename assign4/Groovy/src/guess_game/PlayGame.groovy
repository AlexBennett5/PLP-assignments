package guess_game

println "I've selected a number, can you guess it?"
GuessGame guesser = new GuessGame()
Random randNumbers = new Random()

GuessGame.play(randNumbers.nextInt(101), {
  print "Your guess:"
  System.in.newReader().readLine() as Integer
}, { println it })