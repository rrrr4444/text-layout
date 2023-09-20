import java.io.PrintWriter;

import lab.VComposition;
import lab.TBUtils;
import lab.TextBlock;
import lab.TextLine;


public class Experiments {
    public static void main(String[] args) {
        PrintWriter pen = new PrintWriter(System.out, true);
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
        block = new Centered(block, 3);
        TBUtils.print(pen, block);
    }

    public static void rightJustify(PrintWriter pen) {
        TextBlock block = new TextLine("hello");
        TBUtils.print(pen, block);
        block = new RightJustified(block, 3);
        TBUtils.print(pen, block);
    }

    public static void horizontallyFlip(PrintWriter pen) {
        TextBlock block = new TextLine("hello");
        TBUtils.print(pen, block);
        block = new HorizontallyFlipped(block);
        TBUtils.print(pen, block);
    }

    public static void verticallyFLip(PrintWriter pen) {
        TextBlock one = new TextLine("one");
        TextBlock two = new TextLine("two");
        TextBlock block = new VComposition(one, two);
        TBUtils.print(pen, block);
        block = new VerticallyFlipped(block);
        TBUtils.print(pen, block);
    }

    public static void isEq(PrintWriter pen) {
        TextBlock one = new TextLine("hi");
        TextBlock two = new TextLine("hi");
        pen.println(TBUtils.eq(one, two));
        pen.println(TBUtils.eq(one, one));
    }

    public static void isEqual(PrintWriter pen) {
        TextBlock one = new TextLine("hi");
        TextBlock two = new TextLine("hi");
        pen.println(TBUtils.equal(one, two));
        pen.println(TBUtils.equal(one, one));
    }

    public static void toDashes(PrintWriter pen) {
        TextBlock block = new TextLine("dashes");
        TBUtils.print(pen, block);
        block = new ToDashes(block);
        TBUtils.print(pen, block);
    }

    public static void isEqv(PrintWriter pen) {
        TextBlock block_0 = new TextLine("base");
        TextBlock block_a = new TextLine("test");
        TextBlock block_1 = new VComposition(block_0, block_0);
        TextBlock block_2 = new VComposition(block_0, block_a);
        pen.println(block_1.eqv(block_2));
    }
} // Experiments class
