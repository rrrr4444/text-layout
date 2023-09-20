import lab.TBUtils;
import lab.TextBlock;

public class HorizontallyFlipped implements TextBlock {
    TextBlock contents;

    // Constructor for the Centered class.
    public HorizontallyFlipped (TextBlock contents) {
        this.contents = contents;
    } // Truncated()

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

    public int height() {
        return this.contents.height();
    }

    public int width() {
        return this.contents.width();
    }

    public boolean eqv(TextBlock block) {
        // If classes and fields are the same, recurse down contents
        try {
            return block.getClass() == HorizontallyFlipped.class
                    && this.contents.eqv(block);
        } catch (Exception e) {
            return false;
        }
    }
}