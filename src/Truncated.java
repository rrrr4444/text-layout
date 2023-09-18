import lab.TextBlock;

public class Truncated implements TextBlock {
    int max_width;
    TextBlock block;

    // Constructor for the Truncated class.
    public Truncated (TextBlock block, int max_width) {
        this.block = block;
        this.max_width = max_width;
    } // Truncated()

    // returns height of TextBlock.
    public int height() {
        return this.block.height();
    } // height()

    // Returns length of truncated TextBlock.
    public int width() {
        return this.max_width;
    } // length()

    // Returns row i of the TextBlock.
    public String row(int i) throws Exception {
        if (i < 0 || i >= this.block.height()) {
            throw new Exception("Invalid row " + i);
        } // if
        String line = this.block.row(i);
        return line.substring(0, this.max_width);
    } // row()

} // Truncated class