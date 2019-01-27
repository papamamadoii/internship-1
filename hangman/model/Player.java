package model;

/**
 * A singleton represents a singleplayer in hangman game. Consist such as
 * scores, guesses, and word in game that the player got.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class Player {

	private int guess;
	private int score;
	private static Player instance;

	private Player() {
		this.guess = 8;
		this.score = 0;
	}

	/**
	 * Return the singleton instance of this class.
	 * 
	 * @return Player instance
	 */
	public static Player getInstance() {
		if (instance == null) {
			instance = new Player();
		}
		return instance;
	}

	/**
	 * Subtract player's guess.
	 */
	public void wrongGuess() {
		this.guess -= 1;
	}

	/**
	 * Add player score due to correct guess.
	 */
	public void correctGuess() {
		this.score += 15;
	}

	/**
	 * Return the remaining guess.
	 * 
	 * @return remaining guess
	 */
	public int getGuess() {
		return this.guess;
	}

	/**
	 * Get player's score.
	 * 
	 * @return score
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Reset the player's score and guess to basic.
	 */
	public void reset() {
		this.guess = 8;
		this.score = 0;
	}
}
