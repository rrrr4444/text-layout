import lab.TBUtils;
import lab.TextBlock;

/**
 * Right-justifies the TextBlock within the given width.
 * @author Reed Colloton
 */
public class RightJustified implements TextBlock {
    int width;
    TextBlock contents;

    /**
     * Constructor for the RightJustified class.
     */
    public RightJustified (TextBlock contents, int width) {
        this.contents = contents;
        this.width = width;
    } // Truncated()s

    /**
     * Get one row from the block.
     *
     * @pre 0 <= i < this.height()
     * @exception Exception if the precondition is not met
     */
    public String row(int i) throws Exception {
        String row = this.contents.row(i);
        int rowLength = row.length();
        int paddingLeft = this.width - rowLength;
        return TBUtils.spaces(paddingLeft) + row.substring(0, this.width);
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
        return Math.max(this.contents.width(), this.width);
    }

    /**
     * Returns true if TextBlocks have the same structure of Classes.
     * (This also means they output the same lines.)
     */
    public boolean eqv(TextBlock block) {
        // If classes and fields are the same, recurse down contents
        try {
            return block.getClass() == RightJustified.class
                    && this.width == block.width()
                    && this.contents.eqv(((RightJustified) block).contents());
        } catch (Exception e) {
            return false;
        }
    }
}
