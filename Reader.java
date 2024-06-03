import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;
import java.util.*;

public class Reader {
	/**
	 * This method reads sentences from the input file, creates a Sentence object
	 * for each, and returns a Set of the Sentences.
	 * 
	 * @param filename Name of the input file to be read
	 * @return Set containing one Sentence object per sentence in the input file
	 * @throws IllegalArgumentException if filename is null
	 */
	public static Set<Sentence> readFile(String filename) {

		Set <Sentence> sentences = new HashSet<Sentence>();
		/*
		 * Implement this method in Part 1
		 */
		try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = in.readLine()) != null) {
				// Process the line
				int score;
				String text;

				String scoretxt = line.split(" ")[0];
				try {
					score = Integer.parseInt(scoretxt);
				} catch (NumberFormatException e) {
					System.out.println("Error reading score: " + e.getMessage());
					continue;
				}
				text = line.substring(scoretxt.length() + 1);

				if (score < -2 || score > 2)
					continue;
				
				if (text.length() == 0)
					continue;

								
				System.out.println(score);
				System.out.println(text);
				
				Sentence s = new Sentence(score, text);
				sentences.add(s);
			}
		}
		catch (Exception e) {
			System.out.println("Error reading file: " + e.getMessage());
			throw new IllegalArgumentException("Error reading file: " + e.getMessage());
		}

		return null;
	}

	// main method for testing
	public static void main(String[] args) {
		readFile("reviews.txt");
	}
}
