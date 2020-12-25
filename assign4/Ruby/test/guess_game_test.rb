require 'minitest/autorun'
require './src/guess_game'

class GuessGameTest < MiniTest::Test
  def test_canary
    assert true
  end          
  
  def test_correct_guess_in_one_attempt
    received = ''

    guess(10, 1, lambda { 10 }, lambda {|response| received = response })

    assert_equal "You guessed it in 1 attempt", received
  end

  def test_guess_lower_than_selected_number
    received = ''

    guess(10, 1, lambda { 9 }, lambda {|response| received = response })

    assert_equal "Aim higher", received
  end

  def test_guess_higher_than_selected_number
    received = ''

    guess(10, 1, lambda { 11 }, lambda {|response| received = response })

    assert_equal "Aim lower", received
  end

  def test_correct_guess_in_two_attempts
    received = ''

    guess(12, 2, lambda { 12 }, lambda {|response| received = response })

    assert_equal "You guessed it in 2 attempts", received
  end

  def test_guess_returns_true_on_correct_guess_with_one_attempt
    assert guess(12, 1, lambda { 12 }, lambda {|response| })
  end

  def test_guess_returns_true_on_correct_guess_with_any_attempts
    assert guess(15, 3, lambda { 15 }, lambda {|response| })
  end

  def test_guess_returns_false_on_incorrect_guess
    assert !guess(15, 4, lambda { 1 }, lambda {|response| })
  end

  def test_play_correct_guess_in_one_attempt
    received = ''

    play(20, lambda { 20 }, lambda {|response| received = response })

    assert_equal "You guessed it in 1 attempt", received
  end

  def test_play_lower_then_correct_value_on_second_attempt
    received = []
    inputs = [15, 20]

    play(20, lambda { inputs.shift }, lambda {|response| received.push(response) })

    assert_equal ['Aim higher', 'You guessed it in 2 attempts'], received
  end

  def test_play_higher_then_correct_value_on_second_attempt
    received = []
    inputs = [25, 15]

    play(15, lambda { inputs.shift }, lambda {|response| received.push(response)})

    assert_equal ['Aim lower', 'You guessed it in 2 attempts'], received
  end

  def test_play_higher_then_higher_then_correct_value_on_third_attempt
    received = []
    inputs = [25, 20, 15]

    play(15, lambda { inputs.shift }, lambda {|response| received.push(response)})

    assert_equal ['Aim lower', 'Aim lower', 'You guessed it in 3 attempts'], received
  end

  def test_play_lower_then_higher_then_correct_value_on_third_attempt
    received = []
    inputs = [5, 20, 15]

    play(15, lambda { inputs.shift }, lambda {|response| received.push(response)})

    assert_equal ['Aim higher', 'Aim lower', 'You guessed it in 3 attempts'], received
  end
end