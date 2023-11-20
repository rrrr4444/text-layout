import lab.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for this package.
 *
 * @author Reed Colloton
 */
public class TextBlockTests {
  /**
   * Tests for the Centered class.
   */
  @Test
  void centeredTests() {
    assertEquals("    ",
            TBUtils.toString(new Centered(new TextLine(""), 4)));
    assertEquals("",
            TBUtils.toString(new Centered(new TextLine("hello"), 0)));
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
    assertEquals("hello",
            TBUtils.toString(new Centered(new Centered(new TextLine("hello"), 5), 5)));
  } // centeredTests()

  /**
   * Tests for the HorizontallyFlipped class.
   */
  @Test
  void horizontallyFlippedTests() {
    assertEquals("",
            TBUtils.toString(new HorizontallyFlipped(new TextLine(""))));
    assertEquals("olleh",
            TBUtils.toString(new HorizontallyFlipped(new TextLine("hello"))));
    assertEquals(TBUtils.toString(new BoxedBlock(new TextLine("olleh"))),
            TBUtils.toString(new HorizontallyFlipped(new BoxedBlock(new TextLine("hello")))));
    assertEquals(TBUtils.toString(new HComposition(new TextLine("a"), new TextLine("b"))),
            TBUtils.toString(new HorizontallyFlipped(new HComposition(new TextLine("b"), new TextLine("a")))));
    assertEquals(TBUtils.toString(new HComposition(new TextLine("a"), new TextLine("b"))),
            TBUtils.toString(new HorizontallyFlipped (new HorizontallyFlipped(new HComposition(new TextLine("a"), new TextLine("b"))))));
  } // horizontallyFlippedTests()

  /**
   * Tests for the RightJustified class.
   */
  @Test
  void RightJustified() {
    assertEquals("    ",
            TBUtils.toString(new RightJustified(new TextLine(""), 4)));
    assertEquals("",
            TBUtils.toString(new RightJustified(new TextLine("hello"), 0)));
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
    assertEquals("hello",
            TBUtils.toString(new RightJustified(new RightJustified(new TextLine("hello"), 5), 5)));
  } // rightJustifiedTests()

  /**
   * Tests for the ToDashes class.
   */
  @Test
  void toDashesTests() {
    assertEquals("",
            TBUtils.toString(new ToDashes(new TextLine(""))));
    assertEquals("-----",
            TBUtils.toString(new ToDashes(new TextLine("hello"))));
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
    assertEquals("-----",
            TBUtils.toString(new ToDashes(new ToDashes(new TextLine("hello")))));
  } // toDashesTests()

  /**
   * Tests for the Truncated class.
   */
  @Test
  void truncatedTests() {
    assertEquals("    ",
            TBUtils.toString(new Truncated(new TextLine(""), 4)));
    assertEquals("",
            TBUtils.toString(new Truncated(new TextLine("hello"), 0)));
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
    assertEquals("hello",
            TBUtils.toString(new Truncated(new Truncated(new TextLine("hello"), 5), 5)));
  } // truncatedTests()

  /**
   * Tests for the VerticallyFlipped class.
   */
  @Test
  void verticallyFlippedTests() {
    assertEquals("",
            TBUtils.toString(new VerticallyFlipped(new TextLine(""))));
    assertEquals("hello",
            TBUtils.toString(new VerticallyFlipped(new TextLine("hello"))));
    assertEquals("hello",
            TBUtils.toString(new VerticallyFlipped(new TextLine("hello"))));
    assertEquals(TBUtils.toString(new BoxedBlock(new TextLine("hello"))),
            TBUtils.toString(new VerticallyFlipped(new BoxedBlock(new TextLine("hello")))));
    assertEquals(TBUtils.toString(new VComposition(new TextLine("a"), new TextLine("b"))),
            TBUtils.toString(new VerticallyFlipped(new VComposition(new TextLine("b"), new TextLine("a")))));
    assertEquals(TBUtils.toString(new BoxedBlock(new TextLine("hello"))),
            TBUtils.toString(new VerticallyFlipped(new VerticallyFlipped(new BoxedBlock(new TextLine("hello"))))));
  } // verticallyFlippedTests()


  /**
   * Tests for the equal comparator.
   */
  @Test
  void equalTests() {
    TextBlock hello_0 = new TextLine("hello");
    TextBlock emptyLine_0 = new TextLine("");
    TextBlock box_0 = new BoxedBlock(hello_0);
    TextBlock hello_1 = new TextLine("hello");
    TextBlock emptyLine_1 = new TextLine("");
    TextBlock box_1 = new BoxedBlock(hello_1);

    assertEquals(true, TBUtils.equal(hello_0, hello_1));
    assertEquals(true, TBUtils.equal(emptyLine_0, emptyLine_1));
    assertEquals(true, TBUtils.equal(box_0, box_1));

    assertEquals(false, TBUtils.equal(hello_0, box_1));
    assertEquals(false, TBUtils.equal(box_0, emptyLine_1));
    assertEquals(false, TBUtils.equal(emptyLine_0, hello_1));
    assertEquals(false, TBUtils.equal(emptyLine_0, null));
    assertEquals(false, TBUtils.equal(hello_1, null));
  } // equalTests()

  /**
   * Tests for the eqv comparator.
   */
  @Test
  void eqvTests() {
    TextBlock hello_rev_0 = new HorizontallyFlipped((new TextLine("hello")));
    TextBlock hello_rev_1 = new TextLine("olleh");
    TextBlock tower_0 = new VerticallyFlipped(new VComposition(new TextLine("a"), new TextLine("b")));
    TextBlock tower_1 = new VComposition(new TextLine("b"), new TextLine("a"));
    TextBlock emptyLine_0 = new TextLine("");
    TextBlock emptyLine_1 = new TextLine("");

    assertEquals(false, TBUtils.eqv(hello_rev_0, hello_rev_1));
    assertEquals(true, TBUtils.eqv(hello_rev_1, hello_rev_1));
    assertEquals(false, TBUtils.eqv(tower_0, tower_1));
    assertEquals(true, TBUtils.eqv(tower_1, tower_1));
    assertEquals(true, TBUtils.eqv(emptyLine_0, emptyLine_1));

    assertEquals(false, TBUtils.eqv(hello_rev_0, new Centered(hello_rev_0, 5)));
    assertEquals(false, TBUtils.eqv(tower_0, hello_rev_0));
    assertEquals(false, TBUtils.eqv(emptyLine_0, hello_rev_0));
    assertEquals(false, TBUtils.eqv(emptyLine_0, null));
    assertEquals(false, TBUtils.eqv(hello_rev_0, null));
  } // eqvTests()

  /**
   * Tests for the eq comparator.
   */
  @Test
  void eqTests() {
    TextBlock hello = new TextLine("hello");
    TextBlock emptyLine = new TextLine("");
    TextBlock box = new BoxedBlock(hello);

    assertEquals(true, TBUtils.eq(hello, hello));
    assertEquals(true, TBUtils.eq(emptyLine, emptyLine));
    assertEquals(true, TBUtils.eq(box, box));

    assertEquals(false, TBUtils.eq(hello, box));
    assertEquals(false, TBUtils.eq(box, emptyLine));
    assertEquals(false, TBUtils.eq(emptyLine, hello));
    assertEquals(false, TBUtils.eq(emptyLine, null));
    assertEquals(false, TBUtils.eq(hello, null));
  } // eqTests()
}
