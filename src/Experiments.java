import java.io.PrintWriter;

import lab.TBUtils;
import lab.TextBlock;
import lab.TextLine;


public class Experiments {
    public static void main(String[] args) {
        PrintWriter pen = new PrintWriter(System.out, true);
        truncate(pen);
        center(pen);
        rightJustify(pen);
    } // main()

    public static void truncate(PrintWriter pen) {
        TextBlock block = new TextLine("hello hello hello hello hello");
        TBUtils.print(pen, block);
        block = new Truncated(block, 10);
        TBUtils.print(pen, block);
    }

    public static void center(PrintWriter pen) {
        TextBlock block = new TextLine("hello");
        TBUtils.print(pen, block);
        block = new Centered(block, 30);
        TBUtils.print(pen, block);
    }

    public static void rightJustify(PrintWriter pen) {
        TextBlock block = new TextLine("hello");
        TBUtils.print(pen, block);
        block = new RightJustified(block, 6);
        TBUtils.print(pen, block);
    }
} // Experiments class
