import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import lab.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for this package.
 * @author Reed Colloton
 */
public class TestBlockTests {
    /**
     * Tests for the Centered class.
     */
    @Test
     void centeredTests() {
        assertEquals("hello",
                TBUtils.toString(new Centered(new TextLine("hello"), 5)));
        assertEquals("hello ",
                TBUtils.toString(new Centered(new TextLine("hello"), 6)));
        assertEquals("     hello     ",
                TBUtils.toString(new Centered(new TextLine("hello"), 15)));
        assertEquals("",
                TBUtils.toString(new Centered(new TextLine("hello"), 0)));
        assertEquals("h",
                TBUtils.toString(new Centered(new TextLine("hello"), 1)));
        assertEquals("he",
                TBUtils.toString(new Centered(new TextLine("hello"), 2)));
    } // centeredTests()

    /**
     * Tests for the HorizontallyFlipped class.
     */
    @Test
    void horizontallyFlippedTests() {
        assertEquals("olleh",
                TBUtils.toString(new HorizontallyFlipped(new TextLine("hello"))));
        assertEquals(TBUtils.toString(new BoxedBlock(new TextLine("olleh"))),
                TBUtils.toString(new HorizontallyFlipped(new BoxedBlock( new TextLine("hello")))));
        assertEquals(TBUtils.toString(new HComposition(new TextLine("a"), new TextLine("b"))),
                TBUtils.toString(new HorizontallyFlipped(new HComposition(new TextLine("b"), new TextLine("a")))));
    } // horizontallyFlippedTests()

    /**
     * Tests for the RightJustified class.
     */
    @Test
    void RightJustified() {
        assertEquals("hello",
                TBUtils.toString(new RightJustified(new TextLine("hello"), 5)));
        assertEquals(" hello",
                TBUtils.toString(new RightJustified(new TextLine("hello"), 6)));
        assertEquals("          hello",
                TBUtils.toString(new RightJustified(new TextLine("hello"), 15)));
        assertEquals("",
                TBUtils.toString(new RightJustified(new TextLine("hello"), 0)));
        assertEquals("h",
                TBUtils.toString(new RightJustified(new TextLine("hello"), 1)));
        assertEquals("he",
                TBUtils.toString(new RightJustified(new TextLine("hello"), 2)));
    } // rightJustifiedTests()

    /**
     * Tests for the ToDashes class.
     */
    @Test
    void toDashesTests() {
        assertEquals("",
                TBUtils.toString(new ToDashes(new TextLine(""))));
        assertEquals("-",
                TBUtils.toString(new ToDashes(new TextLine("a"))));
        assertEquals("--",
                TBUtils.toString(new ToDashes(new TextLine("ab"))));
        assertEquals("----------",
                TBUtils.toString(new ToDashes(new TextLine("abcdefhjij"))));
        assertEquals("---------------",
                TBUtils.toString(new ToDashes(new HComposition(new TextLine("hello"),
                                                  new TextLine("abcdefhjij")))));
    } // toDashesTests()

    /**
     * Tests for the Truncated class.
     */
    @Test
    void truncatedTests() {
        assertEquals("hello",
                TBUtils.toString(new Truncated(new TextLine("hello"), 5)));
        assertEquals("hello ",
                TBUtils.toString(new Truncated(new TextLine("hello"), 6)));
        assertEquals("hello     ",
                TBUtils.toString(new Truncated(new TextLine("hello"), 10)));
        assertEquals("",
                TBUtils.toString(new Truncated(new TextLine("hello"), 0)));
        assertEquals("h",
                TBUtils.toString(new Truncated(new TextLine("hello"), 1)));
        assertEquals("he",
                TBUtils.toString(new Truncated(new TextLine("hello"), 2)));
    } // truncatedTests()

    /**
     * Tests for the VerticallyFlipped class.
     */
    @Test
    void verticallyFlippedTests() {
        assertEquals("hello",
                TBUtils.toString(new VerticallyFlipped(new TextLine("hello"))));
        assertEquals(TBUtils.toString(new BoxedBlock(new TextLine("hello"))),
                TBUtils.toString(new VerticallyFlipped(new BoxedBlock( new TextLine("hello")))));
        assertEquals(TBUtils.toString(new VComposition(new TextLine("a"), new TextLine("b"))),
                TBUtils.toString(new VerticallyFlipped(new VComposition(new TextLine("b"), new TextLine("a")))));
    } // verticallyFlippedTests()

    /**
     * Tests for the eq comparator.
     */
    @Test
    void eqTests() {
        assertEquals("hello",
                TBUtils.toString(new VerticallyFlipped(new TextLine("hello"))));
        assertEquals(TBUtils.toString(new BoxedBlock(new TextLine("hello"))),
                TBUtils.toString(new VerticallyFlipped(new BoxedBlock( new TextLine("hello")))));
        assertEquals(TBUtils.toString(new VComposition(new TextLine("a"), new TextLine("b"))),
                TBUtils.toString(new VerticallyFlipped(new VComposition(new TextLine("b"), new TextLine("a")))));
    } // eqTests()

    /**
     * Tests for the equals comparator.
     */
    @Test
    void equalsTests() {
    } // equalsTests()
}
