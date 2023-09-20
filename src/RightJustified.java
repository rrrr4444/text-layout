import lab.TBUtils;
import lab.TextBlock;

public class RightJustified implements TextBlock {
    int width;
    TextBlock contents;

    // Constructor for the Centered class.
    public RightJustified (TextBlock contents, int width) {
        this.contents = contents;
        this.width = width;
    } // Truncated()s

    public String row(int i) throws Exception {
        String row = this.contents.row(i);
        int rowLength = row.length();
        int paddingLeft = this.width - rowLength;
        return TBUtils.spaces(paddingLeft) + row.substring(0, this.width);
    }

    public TextBlock contents() {
        return this.contents;
    }

    public int height() {
        return this.contents.height();
    }

    public int width() {
        return Math.max(this.contents.width(), this.width);
    }

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
