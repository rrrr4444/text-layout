import lab.TextBlock;

/**
 * Horizontally flips the text in the TextBlocks.
 * @author Reed Colloton
 */
public class HorizontallyFlipped implements TextBlock {
    TextBlock contents;

    /**
     * Constructor for the HorizontallyFlipped class.
     */
    public HorizontallyFlipped (TextBlock contents) {
        this.contents = contents;
    } // Truncated()

    /**
     * Get one row from the block.
     *
     * @pre 0 <= i < this.height()
     * @exception Exception if the precondition is not met
     */
    public String row(int i) throws Exception {

        // Sanity check
        if ((i < 0) || (i >= this.height())) {
            throw new Exception("Invalid row " + i);
        } // if the row is invalid
        String row = this.contents.row(i);
        String reversed_row = "";
        for (int j = row.length() - 1; j >= 0; j--) {
            reversed_row += row.charAt(j);
        }
        return reversed_row;
    }

    /**
     * Returns this.contents
     */
    public TextBlock contents() {
        return this.contents;
    }

    /**
     * Returns this.height
     */
    public int height() {
        return this.contents.height();
    }

    /**
     * Returns this.width
     */
    public int width() {
        return this.contents.width();
    }

    /**
     * Returns true if TextBlocks have the same structure of Classes.
     * (This also means they output the same lines.)
     */
    public boolean eqv(TextBlock block) {
        // If classes and fields are the same, recurse down contents
        try {
            return block.getClass() == HorizontallyFlipped.class
                    && this.contents.eqv(((HorizontallyFlipped) block).contents());
        } catch (Exception e) {
            return false;
        }
    }
}