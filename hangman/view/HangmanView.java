package view;

import java.util.List;
import java.util.Scanner;

import controller.HangmanController;
import model.Hangman;
import model.Player;

/**
 * The view of the hangman game.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class HangmanView {

	private HangmanController controller = new HangmanController();
	private Hangman hangman = Hangman.getInstance();

	/**
	 * Select the category from the existing choice.
	 * 
	 * @return number of the category listed
	 */
	public int selectCategory() {
		System.out.println("Select Category:");
		System.out.println("1.) Animal");
		System.out.println("2.) Instrument");
		System.out.println("3.) Exit");
		return controller.handleSelectCategory();
	}

	public void takeGuess() {
		controller.handleTakeGuess();
	}

	/**
	 * Main part of the game. Selecting the category and keep guessing.
	 */
	public void startGame() {
		int choice = selectCategory();
		if (choice == 3) {
			System.out.println("Bye!");
			System.exit(0);
		}
		hangman.randomWord(choice - 1);
		System.out.println(hangman.getWord().getHint());
		while (hangman.canGuess() == 0) {
			takeGuess();
		}
		if (hangman.canGuess() == -2) {
			System.out.println("Hooray! You've completed the word :D");
		} else {
			System.out.println("You lose :(");
		}
	}

	public void newGame() {
		controller.handleNewGame();
		startGame();
	}

	/**
	 * Body of the whole program. Choose whether to continue or start a new game.
	 */
	public void playGame() {
		boolean stop = false;
		while (!stop) {
			newGame();
			System.out.println("Press 'n' for new game or other key to exit.");
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			if (!input.equals("n")) {
				stop = true;
			}
		}
	}

}
