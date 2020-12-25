package guess_game

import java.util.stream.*

static boolean guess(int selectedNumber, Long attempts, Closure input, Closure output){
  String plural = (attempts != 1) ? "s" : ""
  def responses = ["Aim lower", "You guessed it in ${attempts} attempt${plural}", "Aim higher"]
  def guessMatch = selectedNumber <=> input()

  output(responses[guessMatch + 1])
  guessMatch == 0
}

static void play(int selectedNumber, Closure input, Closure output){
  Stream.iterate(1) {i -> i + 1}.iterator().find { guess(selectedNumber, it, input, output) }
}
