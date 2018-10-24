package DecorationPattern;

/**
 * @author hsw
 * @create 2018-10-17  19:27
 */

interface Transformation{
    void move();
}

class Car implements Transformation{

    public Car() {
        System.out.print("I am a Car  ");
    }

    @Override
    public void move() {
        System.out.print("I can move on the ground  ");
    }
}

class Transformer implements Transformation{

    private Transformation transformation;

    public Transformer(Transformation transformation) {
        this.transformation = transformation;
    }

    @Override
    public void move() {
        transformation.move();
    }
}

class Plane extends Transformer{
    public Plane(Transformation transformation) {
        super(transformation);
        System.out.print("-->   equip with flight capability like a plane   ");
    }

    public void move(){
        super.move();
        System.out.print("-->   and can also fly in the sky   ");
    }
}

class Submarine extends Transformer{

    public Submarine(Transformation transformation) {
        super(transformation);
        System.out.print("-->   equip with diving capability like a submarine   ");
    }

    public void move(){
        super.move();
        System.out.print("--> and can also dive under water");
    }
}


public class TransformerMain {

    public static void main(String[] args) {
        Car car = new Car();
        Plane plane = new Plane(car);
        Submarine submarine = new Submarine(plane);

        System.out.println();
        plane.move();

        System.out.println();
        submarine.move();
    }

}
