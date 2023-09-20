import lab.TBUtils;
import lab.TextBlock;

public class Truncated implements TextBlock {
    int max_width;
    TextBlock contents;

    // Constructor for the Truncated class.
    public Truncated (TextBlock contents, int max_width) {
        this.contents = contents;
        this.max_width = max_width;
    } // Truncated()

    public TextBlock contents() {
        return this.contents;
    }

    // returns height of TextBlock.
    public int height() {
        return this.contents.height();
    } // height()

    // Returns length of truncated TextBlock.
    public int width() {
        return this.max_width;
    } // length()

    // Returns row i of the TextBlock.
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