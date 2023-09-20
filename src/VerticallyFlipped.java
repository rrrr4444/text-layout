import lab.TextBlock;

public class VerticallyFlipped implements TextBlock {
    TextBlock contents;

    // Constructor for the Centered class.
    public VerticallyFlipped (TextBlock contents) {
        this.contents = contents;
    } // Truncated()

    public String row(int i) throws Exception {
        int h = this.height();

        // Sanity check
        if ((i < 0) || (i >= h)) {
            throw new Exception("Invalid row " + i);
        } // if the row is invalid

        return this.contents.row((h - 1) - i);
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
            return block.getClass() == VerticallyFlipped.class
                    && this.contents.eqv(((VerticallyFlipped) block).contents());
        } catch (Exception e) {
            return false;
        }
    }
}