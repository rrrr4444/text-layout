import lab.TBUtils;
import lab.TextBlock;

public class Centered implements TextBlock {
    int width;
    TextBlock contents;

    // Constructor for the Centered class.
    public Centered (TextBlock contents, int width) {
        this.contents = contents;
        this.width = width;
    } // Truncated()

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

    public TextBlock contents() {
        return this.contents;
    }

    public int height() {
        return this.contents.height();
    }

    public int width() {
        return this.width;
    }

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
