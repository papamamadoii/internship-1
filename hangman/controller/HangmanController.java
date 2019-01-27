package controller;

import java.util.List;
import java.util.Scanner;

import model.Hangman;
import model.Player;

/**
 * Controller class for the hangman game.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class HangmanController {

	private Hangman hangman = Hangman.getInstance();
	private Player player = Player.getInstance();

	/**
	 * Select category handler.
	 * 
	 * @return true if the input was numeric, false for not
	 */
	public int handleSelectCategory() {
		Scanner sc = new Scanner(System.in);
		boolean allow = false;
		String input = "";
		int choice = 0;
		while (!allow) {
			input = sc.next();
			boolean numeric = checkIntegerInput(input);
			if (numeric) {
				choice = Integer.parseInt(input);
				if (choice > 0 && choice < 4) {
					allow = true;
				}
			}
		}
		return choice;
	}

	/**
	 * Take guess method handler.
	 */
	public void handleTakeGuess() {
		showWordStatus();
		showStatus();
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		hangman.checkGuess(input);
	}

	/**
	 * Show the status of the word.
	 */
	public void showWordStatus() {
		List<String> chars = hangman.getCurrentLetters();
		chars.forEach((letter) -> System.out.print(letter + " "));
	}

	/**
	 * Show the status of the score, guess, and wrong guess taken.
	 */
	public void showStatus() {
		System.out.printf("score %d, remaining wrong guess %d ", player.getScore(), player.getGuess());
		if (hangman.getGuessLetters().size() != 0) {
			System.out.print("wrong guessed: ");
			hangman.getGuessLetters().forEach((letter) -> System.out.print(letter + " "));
		}
		System.out.println();
	}

	/**
	 * New game method handler. It resets hangman and the player stats to basic.
	 */
	public void handleNewGame() {
		hangman.reset();
		player.reset();
	}

	/**
	 * Private method for checking the input if it was an integer.
	 * 
	 * @param String input
	 * @return true if integer or false if not
	 */
	private boolean checkIntegerInput(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
}
