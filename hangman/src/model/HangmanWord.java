package src.model;

/**
 * A class that represents a single word in hangman game which consists of the word
 * and its hint.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class HangmanWord {
	private String word;
	private String hint;

	public HangmanWord(String word, String hint) {
		this.word = word;
		this.hint = hint;
	}
	/**
	 * Return the word from this HangmanWord's object.
	 */
	public String getWord() {
		return this.word;
	}
	
	/**
	 * Return the hint from this HangmanWord's object.
	 * @return
	 */
	public String getHint() {
		return this.hint;
	}
}
