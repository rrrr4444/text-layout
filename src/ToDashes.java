import lab.TBUtils;
import lab.TextBlock;

public class ToDashes implements TextBlock {
    TextBlock contents;

    // Constructor for the Centered class.
    public ToDashes(TextBlock contents) {
        this.contents = contents;
    } // ToSpaces()

    public String row(int i) throws Exception {

        // Sanity check
        if ((i < 0) || (i >= this.height())) {
            throw new Exception("Invalid row " + i);
        } // if the row is invalid

        // Return same number of spaces as length
        int length = this.contents.row(i).length();
        return TBUtils.dashes(length);
    }

    public TextBlock contents() {
        return this.contents;
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
            return block.getClass() == ToDashes.class
                    && this.contents.eqv(((ToDashes) block).contents());
        } catch (Exception e) {
            return false;
        }
    }
}
