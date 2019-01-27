package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A utiliy class especially for reading text file.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class TextReader {

	private static TextReader instance;

	private TextReader() {
	}

	/**
	 * Get the singleton instance of this class.
	 * 
	 * @return TextReader instance
	 */
	public static TextReader getInstance() {
		if (instance == null)
			instance = new TextReader();
		return instance;
	}

	/**
	 * Reads the file, collect it in a List<String>, and return the list.
	 * 
	 * @param filename
	 */
	public List<String> readTextFile(String filename) {
		File file = new File("hangman/words/" + filename);
		FileReader fl = null;
		try {
			fl = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		BufferedReader br = new BufferedReader(fl);
		String st;
		List<String> texts = new ArrayList<>();
		try {
			while ((st = br.readLine()) != null) {
				texts.add(st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return texts;
	}

}
