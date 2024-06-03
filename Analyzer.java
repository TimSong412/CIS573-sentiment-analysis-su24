

import java.util.*;

public class Analyzer {
	

	/**
	 * This method calculates the weighted average for each word in all the Sentences.
	 * This method is case-insensitive and all words should be stored in the Map using
	 * only lowercase letters.
	 * 
	 * @param sentences Set containing Sentence objects with words to score
	 * @return Map of each word to its weighted average; or an empty Map if the Set of
	 * Sentences is empty or null.
	 */
	public static Map<String, Double> calculateWordScores(Set<Sentence> sentences) {
		/*
		 * Implement this method in Part 2
		 */
		if( sentences == null || sentences.isEmpty()) {
			return new HashMap<String, Double>();
		}

		Map<String, Double> wordScores = new HashMap<String, Double>();
		Map<String, Integer> wordCount = new HashMap<String, Integer>();

		for(Sentence s : sentences) {
			String[] words = s.getText().toLowerCase().split(" ");
			for (String word : words) {
				if (word.length() == 0) {
					continue;
				}
				if (word.charAt(0) < 'a' || word.charAt(0) > 'z') {
					continue;
				}
				if (wordCount.containsKey(word)) {
					wordCount.put(word, wordCount.get(word) + 1);
					wordScores.put(word, wordScores.get(word) + s.getScore());
				} else {
					wordCount.put(word, 1);
					wordScores.put(word, (double) s.getScore());
				}
				
			}
			
		}

		for(String word : wordScores.keySet()) {
			wordScores.put(word, wordScores.get(word) / wordCount.get(word));
		}

		return wordScores;
	}
	
	/**
	 * This method determines the sentiment of the input sentence using the average of the
	 * scores of the individual words, as stored in the Map.
	 * This method is case-insensitive and all words in the input sentence should be
	 * converted to lowercase before searching for them in the Map.
	 * 
	 * @param wordScores Map of words to their weighted averages
	 * @param sentence Text for which the method calculates the sentiment
	 * @return Weighted average scores of all words in input sentence; or 0 if any error occurs
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		/*
		 * Implement this method in Part 3
		 */
		String[] words = sentence.toLowerCase().split(" ");
		double score = 0;
		int count = 0;
		for (String word : words) {
			if (word.length() == 0) {
				continue;
			}
			if (word.charAt(0) < 'a' || word.charAt(0) > 'z') {
				continue;
			}
			if (wordScores.containsKey(word)) {
				score += wordScores.get(word);
				
			}
			count++;
		}
		if (count == 0) {
			return 0;
		}
		return score / count;
	}

	public static void main(String[] args) 
	{
		Set <Sentence> sentences = Reader.readFile("reviews.txt");
		Map<String, Double> wordScores = calculateWordScores(sentences);

	}


}
