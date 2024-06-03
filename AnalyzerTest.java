import org.junit.Test;
import static org.junit.Assert.*;

public class AnalyzerTest {

    @Test
    public void testCalculateWordScores() {
        // Create an instance of Analyzer
        Analyzer analyzer = new Analyzer();

        // Test case 1: Empty input
        String[] words1 = {};
        double[] scores1 = analyzer.calculateWordScores(words1);
        assertEquals(0, scores1.length);

        // Test case 2: Single word with positive score
        String[] words2 = {"happy"};
        double[] scores2 = analyzer.calculateWordScores(words2);
        assertEquals(1, scores2.length);
        assertEquals(0.5, scores2[0], 0.001);

        // Test case 3: Multiple words with mixed scores
        String[] words3 = {"good", "bad", "neutral"};
        double[] scores3 = analyzer.calculateWordScores(words3);
        assertEquals(3, scores3.length);
        assertEquals(0.8, scores3[0], 0.001);
        assertEquals(-0.5, scores3[1], 0.001);
        assertEquals(0.0, scores3[2], 0.001);
    }
}