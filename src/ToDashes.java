import lab.TBUtils;
import lab.TextBlock;

/**
 * Converts all characters in the TextBlock to dashes.
 * @author Reed Colloton
 */
public class ToDashes implements TextBlock {
    TextBlock contents;

    /**
     * Constructor for the ToDashes class.
     */
    public ToDashes(TextBlock contents) {
        this.contents = contents;
    } // ToSpaces()

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

        // Return same number of spaces as length
        int length = this.contents.row(i).length();
        return TBUtils.dashes(length);
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
            return block.getClass() == ToDashes.class
                    && this.contents.eqv(((ToDashes) block).contents());
        } catch (Exception e) {
            return false;
        }
    }
}
