package src.view;

import java.util.Scanner;

import src.controller.HangmanController;
import src.model.Hangman;

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

	/**
	 * View method for taking guess which is handle by the controller.
	 */
	public void takeGuess() {
		controller.handleTakeGuess();
	}

	/**
	 * The gameplay part. Selecting the category and keep guessing.
	 */
	public void playGame() {
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
			System.out.printf("The answer is %s.\n", hangman.getWord().getWord());
		}
	}

	/**
	 * Start a new game.
	 */
	public void newGame() {
		controller.handleNewGame();
		playGame();
	}

	/**
	 * Pause the game after the game is complete. Press 'n' to continue and other
	 * key to exit.
	 * 
	 * @return true if stop, false if continue
	 */
	public boolean pauseGame() {
		boolean stop = false;
		System.out.println("Press 'n' for new game or other key to exit.");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		if (!input.equals("n")) {
			stop = true;
		}
		return stop;
	}

	/**
	 * Body of the whole program. Choose whether to start a new game or exit.
	 */
	public void startGame() {
		boolean stop = false;
		while (!stop) {
			newGame();
			stop = pauseGame();
		}
		System.out.println("Bye!");
	}

}
