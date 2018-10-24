package DecorationPattern;


/**
 * @author hsw
 * @create 2018-10-18  13:07
 */


abstract class Display{
    abstract public int getColumn();
    abstract public int getRow();
    abstract public String getRowText(int row);
    public void show() {
        for (int i = 0; i < getRow(); i++) {
            System.out.println(getRowText(i));
        }
    }

}

final class StringDisplay extends Display {

    private String str;

    public StringDisplay(String str) {
        this.str = str;
    }


    @Override
    public int getColumn() {
        return str.length();
    }

    @Override
    public int getRow() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if(row == 0)
            return str;
        else return null;
    }
}

abstract class Border extends Display {

    protected Display display;

    protected Border(Display display) {
        this.display = display;
    }
}

final class SideBorder extends Border {

    private char borderChar;

    public SideBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    public int getColumn() {
        return display.getColumn() + 2;
    }

    @Override
    public int getRow() {
        return display.getRow();
    }

    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}

class FullBorder extends Border {

    protected FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumn() {
        return display.getColumn() + 2;
    }

    @Override
    public int getRow() {
        return display.getRow() + 2;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0 || row == getRow() - 1) {
            StringBuilder str = new StringBuilder("+");
            for (int i = 0; i < display.getColumn(); i++) {
                str.append("-");
            }
            return str.append("+").toString();
        } else {
            return "|" + display.getRowText(row - 1) + "|";
        }
    }
}

public class DisplayStr {
    public static void main(String[] args) {
        StringDisplay str = new StringDisplay("hello world!");
        SideBorder sideBorder = new SideBorder(str, '#');
        sideBorder.show();
        System.out.println();
        FullBorder fullBorder = new FullBorder(sideBorder);
        fullBorder.show();
        System.out.println();
        SideBorder sideBorder1 = new SideBorder(fullBorder, '*');
        sideBorder1.show();
    }
}
