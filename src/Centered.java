import lab.TBUtils;
import lab.TextBlock;

/**
 * Centers the TextBlock within the given width.
 * @author Reed Colloton
 */
public class Centered implements TextBlock {
    int width;
    TextBlock contents;

    /**
     * Constructor for the Centered class.
      */
    public Centered (TextBlock contents, int width) {
        this.contents = contents;
        this.width = width;
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
        int rowLength = row.length();
        int padding = this.width - rowLength;
        int paddingLeft = 0;
        int paddingRight = 0;
        // If odd number of spaces, move one to the right
        if (padding % 2 == 1) {
            padding--;
            paddingRight = 1;
        }
        paddingLeft += padding / 2;
        paddingRight += padding / 2;
        return TBUtils.spaces(paddingLeft) +
                row.substring(0, this.width) +
                TBUtils.spaces(paddingRight);
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
        return this.width;
    }

    /**
     * Returns true if TextBlocks have the same structure of Classes.
     * (This also means they output the same lines.)
     */
    public boolean eqv(TextBlock block) {
        // If classes and fields are the same, recurse down contents
        try {
            return block.getClass() == Centered.class
                    && this.width == block.width()
                    && this.contents.eqv(((Centered) block).contents());
        } catch (Exception e) {
            return false;
        }
    }
}
