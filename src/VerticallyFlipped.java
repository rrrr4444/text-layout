import lab.TextBlock;

/**
 * Vertically flips the TextBlock rows.
 * @author Reed Colloton
 */
public class VerticallyFlipped implements TextBlock {
    TextBlock contents;

    /**
     * Constructor for the VerticallyFlipped class.
     */
    public VerticallyFlipped (TextBlock contents) {
        this.contents = contents;
    } // Truncated()

    /**
     * Get one row from the block.
     *
     * @pre 0 <= i < this.height()
     * @exception Exception if the precondition is not met
     */
    public String row(int i) throws Exception {
        int h = this.height();

        // Sanity check
        if ((i < 0) || (i >= h)) {
            throw new Exception("Invalid row " + i);
        } // if the row is invalid

        return this.contents.row((h - 1) - i);
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
            return block.getClass() == VerticallyFlipped.class
                    && this.contents.eqv(((VerticallyFlipped) block).contents());
        } catch (Exception e) {
            return false;
        }
    }
}