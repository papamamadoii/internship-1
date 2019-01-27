package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.TextReader;

/**
 * A singleton object represents the hangman game. Containing methods for the
 * game to be able to play.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class Hangman {
	private static Hangman instance;
	private Player player = Player.getInstance();
	private List<List<HangmanWord>> allWords;
	private List<String> currentChar;
	private List<String> guessChar;
	private List<String> wordChar;
	private HangmanWord hmWord;

	private Hangman() {
		allWords = new ArrayList<List<HangmanWord>>();
		currentChar = new ArrayList<>();
		guessChar = new ArrayList<>();
		wordChar = new ArrayList<>();
		TextReader tr = TextReader.getInstance();
		List<String> animals = tr.readTextFile("Animal.txt");
		createHangmanWords(animals);
		List<String> instrument = tr.readTextFile("Instrument.txt");
		createHangmanWords(instrument);
	}

	/**
	 * Get the singleton instance of this class.
	 * 
	 * @return Hangman
	 */
	public static Hangman getInstance() {
		if (instance == null) {
			instance = new Hangman();
		}
		return instance;
	}

	/**
	 * Private method for the class to add words to the list.
	 * 
	 * @param Unsplitted string list
	 */
	private void createHangmanWords(List<String> list) {
		List<HangmanWord> tmp = new ArrayList<>();
		for (int i = 0; i < list.size() - 2; i += 2) {
			String word = list.get(i);
			String hint = list.get(i + 1);
			HangmanWord hw = new HangmanWord(word, hint);
			tmp.add(hw);
		}
		allWords.add(tmp);
	}

	/**
	 * Random the word for the player from the selected category.
	 * 
	 * @param selected category
	 */
	public void randomWord(int choice) {
		Random rand = new Random();
		List<HangmanWord> words = allWords.get(choice);
		int num = rand.nextInt(words.size() - 1) + 0;
		HangmanWord word = words.get(num);
		setWord(word);
	}

	/**
	 * Set the word from the random list.
	 * 
	 * @param Hangman word
	 */
	private void setWord(HangmanWord word) {
		this.hmWord = word;
		for (int i = 0; i < word.getWord().length(); i++) {
			String tmpWord = Character.toString(word.getWord().charAt(i));
			wordChar.add(tmpWord);
			currentChar.add("_");
		}
	}

	/**
	 * Return the current letter status of the game.
	 * 
	 * @return list of letters
	 */
	public List<String> getCurrentLetters() {
		return this.currentChar;
	}

	/**
	 * Return guessed letters.
	 * 
	 * @return list of guessed letters
	 */
	public List<String> getGuessLetters() {
		return guessChar;
	}

	/**
	 * Return the current word that is used in the gameplay.
	 * 
	 * @return HangmanWord
	 */
	public HangmanWord getWord() {
		return this.hmWord;
	}

	/**
	 * Check player's guess.
	 * 
	 * @param input
	 * @return true if correct guess, false if not
	 */
	public void checkGuess(String input) {
		boolean correct = false;
		String guess = input.toLowerCase();
		for (int i = 0; i < wordChar.size(); i++) {
			if (guess.equals(wordChar.get(i))) {
				currentChar.set(i, guess);
				correct = true;
				player.correctGuess();
			}
		}
		if (!correct) {
			guessChar.add(guess);
			player.wrongGuess();
		}
	}

	/**
	 * Check whether the player can take the guess or not.
	 * 
	 * @return -2 equal victory, -1 for not, and 0 for continue
	 */
	public int canGuess() {
		if (player.getGuess() == 0) {
			if (currentChar.contains("_")) {
				return -1;
			}
		}else if(!currentChar.contains("_")) {
			return -2;
		}
		return 0;

	}

	/**
	 * Reset the game to basic
	 */
	public void reset() {
		currentChar.clear();
		guessChar.clear();
		wordChar.clear();
	}
}
