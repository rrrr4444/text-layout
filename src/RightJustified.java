import lab.TBUtils;
import lab.TextBlock;

public class RightJustified implements TextBlock {
    int width;
    TextBlock block;

    // Constructor for the Centered class.
    public RightJustified (TextBlock block, int width) {
        this.block = block;
        this.width = width;
    } // Truncated()s

    public String row(int i) throws Exception {
        String row = this.block.row(i);
        int rowLength = row.length();
        if (rowLength > this.width) {
            throw new Exception("TextBlock longer than centering width");
        }
        int paddingLeft = this.width - rowLength;
        return TBUtils.spaces(paddingLeft) + row;
    }

    public int height() {
        return this.block.height();
    }

    public int width() {
        return this.block.width();
    }
}
