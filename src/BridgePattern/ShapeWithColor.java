package BridgePattern;

/**
 * @author hsw
 * @create 2018-10-10  20:00
 */

interface Color {
    void bePainted(String shapeName);
}

abstract class Shape {
    Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

class Circle extends Shape{

    public void draw() {
        color.bePainted("正方形");
    }
}

class Rectangle extends Shape{

    public void draw() {
        color.bePainted("长方形");
    }

}

class Square extends Shape{

    public void draw() {
        color.bePainted("正方形");
    }

}

class White implements Color{

    public void bePainted(String shape) {
        System.out.println("白色的" + shape);
    }
}

class Gray implements Color{

    public void bePainted(String shape) {
        System.out.println("灰色的" + shape);
    }
}

class Black implements Color{

    public void bePainted(String shape) {
        System.out.println("黑色的" + shape);
    }
}

public class ShapeWithColor {
    public static void main(String[] args) {
        Color white = new White();
        Shape square = new Square();
        square.setColor(white);
        square.draw();
    }
}
