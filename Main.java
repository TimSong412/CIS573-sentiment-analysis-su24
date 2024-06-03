/**
 * 
 * Main class for the sentiment analysis program.
 * 
 */

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO: modify input file
		// if (args.length == 0) {
		// 	System.out.println("no input file");
		// 	return;
		// }

		Set<Sentence> sentences;

		try{
			sentences = Reader.readFile("reviews.txt");
		}
		catch (Exception e) {
			System.out.println("bad input file");
			return;
		}
		
		Map<String, Double> wordScores = Analyzer.calculateWordScores(sentences);
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Enter a sentence: ");
			
			String sentence = "";
			sentence = sc.nextLine();
			// calculate the sentiment score of the sentence

			if (sentence.equals("quit")) {
				break;
			}

			double score = Analyzer.calculateSentenceScore(wordScores, sentence);
			System.out.println("The sentiment score is: " + score);
			

		}
		sc.close();
		// prompt the user to enter a sentence
		
	}

}
