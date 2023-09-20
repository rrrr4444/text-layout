package lab;

import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  public static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Returns true if both blocks have identical rows.
   */
  public static Boolean equal(TextBlock block_0, TextBlock block_1) {
    int height_0 = block_0.height();
    int height_1 = block_1.height();

    if (height_0 != height_1) {
      return false;
    } // if

    for (int i = 0; i < height_0; i ++) {
      try {
        if (!block_0.row(i).equals(block_1.row(i))) {
          return false;
        }
      } catch (Exception e) {
          return false;
      }
    }
    return true;
  } // eq(TextBlock, TextBlock)

  /**
   * Returns true if both blocks share a memory location.
   */
  public static Boolean eq(TextBlock block_0, TextBlock block_1) {
    return block_0 == block_1;
  } // eq(TextBlock, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  public static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

} // class TBUtils
