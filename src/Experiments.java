import java.io.PrintWriter;

import lab.TBUtils;
import lab.TextBlock;
import lab.TextLine;


public class Experiments {
    public static void main(String[] args) {
        truncate();
    } // main()

    public static void truncate() {
        PrintWriter pen = new PrintWriter(System.out, true);
        TextBlock block = new TextLine("hello hello hello hello hello");
        TBUtils.print(pen, block);
        block = new Truncated(block, 10);
        TBUtils.print(pen, block);
    }
} // Experiments class
