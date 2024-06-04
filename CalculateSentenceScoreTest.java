import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class CalculateSentenceScoreTest{

    // Test case 1: null null input
    @Test
    public void testCalculateSentenceScore_null() {
       
        double score = Analyzer.calculateSentenceScore(null, null);
        assertEquals(0, score, 0.0001);
    }

    // Test case 2: empty null input
    @Test 
    public void testCalculateSentenceScore_empty() {
        Map<String, Double> scores = new HashMap<>();
        double score = Analyzer.calculateSentenceScore(scores, null);
        assertEquals(0, score, 0.0001);
    }

    // Test case 3: null empty input
    @Test
    public void testCalculateSentenceScore_nullEmpty() {
        double score = Analyzer.calculateSentenceScore(null, "");
        assertEquals(0, score, 0.0001);
    }

    // Test case 4: empty empty input
    @Test
    public void testCalculateSentenceScore_emptyEmpty() {
        Map<String, Double> scores = new HashMap<>();
        double score = Analyzer.calculateSentenceScore(scores, "");
        assertEquals(0, score, 0.0001);
    }


    // Test case 5: invalid word
    @Test
    public void testCalculateSentenceScore_invalidWord() {
        Map<String, Double> scores = new HashMap<>();
        scores.put("hello", 1.0);
        double score = Analyzer.calculateSentenceScore(scores, "-world");
        assertEquals(0, score, 0.0001);
    }

    // Test case 6: word not in map
    @Test
    public void testCalculateSentenceScore_notInMap() {
        Map<String, Double> scores = new HashMap<>();
        scores.put("hello", 1.0);
        double score = Analyzer.calculateSentenceScore(scores, "world");
        assertEquals(0, score, 0.0001);
    }

    // Test case 7: single word
    @Test
    public void testCalculateSentenceScore_single() {
        Map<String, Double> scores = new HashMap<>();
        scores.put("hello", 1.0);
        double score = Analyzer.calculateSentenceScore(scores, "hello");
        assertEquals(1.0, score, 0.0001);
    }

    // Test case 8: multiple words
    @Test
    public void testCalculateSentenceScore_multiple() {
        Map<String, Double> scores = new HashMap<>();
        scores.put("hello", 1.0);
        scores.put("world", -1.0);
        double score = Analyzer.calculateSentenceScore(scores, "hello world");
        assertEquals(0, score, 0.0001);
    }

    // Test case 9: Case-insensitive
    @Test
    public void testCalculateSentenceScore_caseInsensitive() {
        Map<String, Double> scores = new HashMap<>();
        scores.put("hello", 1.0);
        scores.put("world", -1.0);
        double score = Analyzer.calculateSentenceScore(scores, "Hello World");
        assertEquals(0, score, 0.0001);
    }

  
}
