import lab.TBUtils;
import lab.TextBlock;

/**
 * Truncates the TextBlock to the given width.
 * @author Reed Colloton
 */
public class Truncated implements TextBlock {
    int max_width;
    TextBlock contents;

    /**
     * Constructor for the Truncated class.
     */
    public Truncated (TextBlock contents, int max_width) {
        this.contents = contents;
        this.max_width = max_width;
    } // Truncated()

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
    } // height()

    /**
     * Returns this.width
     */
    public int width() {
        return this.max_width;
    } // length()

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

        String line = this.contents.row(i);
        int difference = this.max_width - line.length();
        if (difference > 0) {
            line += TBUtils.spaces(difference);
            return line;
        } else {
            return line.substring(0, this.max_width);
        } // if
    } // row()

    /**
     * Returns true if TextBlocks have the same structure of Classes.
     * (This also means they output the same lines.)
     */
    public boolean eqv(TextBlock block) {
        // If classes and fields are the same, recurse down contents
        try {
            return block.getClass() == Truncated.class
                    && this.max_width == block.width()
                    && this.contents.eqv(((Truncated) block).contents());
        } catch (Exception e) {
            return false;
        }
    }

} // Truncated class