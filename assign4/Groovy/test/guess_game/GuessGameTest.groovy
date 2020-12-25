package guess_game

import spock.lang.Specification

class GuessGameTest extends Specification {
  void 'test Canary'() {
    expect:
      true == true
  }

  void 'correct guess in one attempt'() {
    String received = ''

    GuessGame.guess(10, 1, { 10 }, { received = it })

    expect: 
      "You guessed it in 1 attempt" == received
  }

  void 'guess lower than selected number'() {
    String received = ''

    GuessGame.guess(10, 1, { 9 }, { received = it })

    expect: 
      "Aim higher" == received
  }

  void 'guess higher than selected number'() {
    String received = ''

    GuessGame.guess(10, 1, { 11 }, { received = it })

    expect: 
      "Aim lower" == received
  }

  void 'correct guess on second attempt'() {
    String received = ''

    GuessGame.guess(12, 2, { 12 }, { received = it })

    expect: 
      "You guessed it in 2 attempts" == received
  }

  void 'guess returns true on correct guess on first attempt'() {
    expect:
      GuessGame.guess(12, 1, { 12 }, { })
  }

  void 'guess returns true on correct guess on any number of attempts'() {
    expect:
      GuessGame.guess(15, 3, { 15 }, { })
  }

  void 'guess returns false on incorrect guess'() {
    expect:
      !GuessGame.guess(15, 4, { 1 }, { })
  }

  void 'play correct guess in one attempt'() {
    String received = ''

    GuessGame.play(20, { 20 }, { received = it })

    expect: 
      "You guessed it in 1 attempt" == received
  }

  void 'play lower then correct guess on second attempt'() {
    def received = []
    def inputs = [15, 20]

    GuessGame.play(20, { inputs.pop() }, { received.push(it) })

    expect:
      ["You guessed it in 2 attempts", "Aim higher"] == received
  }

  void 'play higher then correct guess on second attempt'() {
    def received = []
    def inputs = [25, 15]

    GuessGame.play(15, { inputs.pop() }, { received.push(it) })

    expect:
      ["You guessed it in 2 attempts", "Aim lower"] == received
  }

  void 'play higher then higher then correct guess on third attempt'() {
    def received = []
    def inputs = [25, 20, 15]

    GuessGame.play(15, { inputs.pop() }, { received.push(it) })

    expect:
      ["You guessed it in 3 attempts", "Aim lower", "Aim lower"] == received
  }

  void 'play lower then higher then correct guess on third attempt'() {
    def received = []
    def inputs = [5, 20, 15]

    GuessGame.play(15, { inputs.pop() }, { received.push(it) })

    expect:
      ["You guessed it in 3 attempts", "Aim lower", "Aim higher"] == received
  }
}
