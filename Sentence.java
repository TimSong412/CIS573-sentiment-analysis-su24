import java.util.HashSet;
import java.util.Set;

/** 
 * @author Chris Murphy
 *
 * This class represents a single sentence from the input file.
 * 
 */


public class Sentence {
	
	/**
	 * The sentiment score for the sentence. Should be in the range [-2, 2]
	 */
	private int score;
	
	/**
	 * The text contained in the sentence. 
	 */
	private String text;
	
	public Sentence(int score, String text) {
		this.score = score;
		this.text = text;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getText() {
		return text;
	}

	// judge if two sentences are equal
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Sentence) {
			Sentence s = (Sentence) obj;
			return this.score == s.score && this.text.equals(s.text);
		}
		return false;
	}

	// hashcode method
	@Override
	public int hashCode(){
		return text.hashCode();
	}

	// main method for testing
	public static void main(String[] args) {
		Sentence s = new Sentence(1, "This is a test.");
		Set <Sentence> sentences = new HashSet<Sentence>();
		sentences.add(s);
		Sentence s1 = new Sentence(1, "This is a test.");
		// check if set contains s1 by using equals method
		System.out.println(sentences.contains(s1));
		sentences.add(s1);
		System.out.println(sentences.size());
	}
	
}
