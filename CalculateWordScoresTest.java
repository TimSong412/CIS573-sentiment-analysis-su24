import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class CalculateWordScoresTest {

    @Test
    public void testCalculateWordScores_null() {
        // Test case 1: Empty input
        Map<String, Double> scores1 = Analyzer.calculateWordScores(null);
        assertEquals(0, scores1.size());
    }

    @Test
    public void testCalculateWordScores_empty() {
        // Test case 1: Empty input
        Set<Sentence> words1 = new HashSet<>();
        Map<String, Double> scores1 = Analyzer.calculateWordScores(words1);
        assertEquals(0, scores1.size());
    }

    @Test
    public void testCalculateWordScores_single() {
        // Test case 2: Single word
        Set<Sentence> words2 = new HashSet<>();
        words2.add(new Sentence(1, "hello"));
        Map<String, Double> scores2 = Analyzer.calculateWordScores(words2);
        assertEquals(1, scores2.size());
        assertEquals(1.0, scores2.get("hello"), 0.0001);
       
    }


    // Test case 3: words with zero length
    @Test
    public void testCalculateWordScores_zeroLength() {
        Set<Sentence> words3 = new HashSet<>();
        words3.add(new Sentence(1, ""));
        Map<String, Double> scores3 = Analyzer.calculateWordScores(words3);
        assertEquals(0, scores3.size());
    }

    // Test case 4: words with non-alphabetic characters
    @Test
    public void testCalculateWordScores_nonAlphabetic() {
        Set<Sentence> words4 = new HashSet<>();
        words4.add(new Sentence(1, "-123"));
        Map<String, Double> scores4 = Analyzer.calculateWordScores(words4);
        assertEquals(0, scores4.size());
    }

    // Test case 5: multiple words
    @Test
    public void testCalculateWordScores_multiple() {
        Set<Sentence> words5 = new HashSet<>();
        words5.add(new Sentence(1, "hello world"));
        words5.add(new Sentence(-1, "hello"));
        words5.add(new Sentence(1, "world"));
        Map<String, Double> scores5 = Analyzer.calculateWordScores(words5);
        assertEquals(2, scores5.size());
        assertEquals(0.0, scores5.get("hello"), 0.0001);
        assertEquals(1.0, scores5.get("world"), 0.0001);
    }


    // Test case 6: case-insensitive
    @Test
    public void testCalculateWordScores_caseInsensitive() {
        Set<Sentence> words6 = new HashSet<>();
        words6.add(new Sentence(1, "Hello"));
        words6.add(new Sentence(-1, "hello"));
        Map<String, Double> scores6 = Analyzer.calculateWordScores(words6);
        assertEquals(1, scores6.size());
        assertEquals(0.0, scores6.get("hello"), 0.0001);
    }


}
