import lab.TBUtils;
import lab.TextBlock;

public class Centered implements TextBlock {
    int width;
    TextBlock block;

    // Constructor for the Centered class.
    public Centered (TextBlock block, int width) {
        this.block = block;
        this.width = width;
    } // Truncated()

    public String row(int i) throws Exception {
        String row = this.block.row(i);
        int rowLength = row.length();
        if (rowLength > this.width) {
            throw new Exception("TextBlock longer than centering width");
        }
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
        return TBUtils.spaces(paddingLeft) + row + TBUtils.spaces(paddingRight);
    }

    public int height() {
        return this.block.height();
    }

    public int width() {
        return this.block.width();
    }
}
