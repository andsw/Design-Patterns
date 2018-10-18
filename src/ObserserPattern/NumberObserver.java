package ObserserPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author hsw
 * @create 2018-10-18  20:20
 */

abstract class NumberGenerator{
    protected List<Observer> observers;
    public NumberGenerator(){
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void deleteObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer o : observers) {
            o.update(this);
        }
    }

    public abstract int getNumber();

    public abstract void execute();
}

class RandomNumberGenerator extends NumberGenerator {

    private int number;
    private Random random;

    public RandomNumberGenerator() {
        super();
        random = new Random();
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        number = random.nextInt(50);
        notifyObservers();
    }
}

interface Observer{
    void update(NumberGenerator numberGenerator);
}

class DigitalObserver implements Observer {
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("update number to ：  " + numberGenerator.getNumber());
    }
}

class GraphObserver implements Observer {

    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.print("update character *'s number to:    ");
        for (int i = 0; i < numberGenerator.getNumber(); i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

public class NumberObserver {

    public static void main(String[] args) {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        DigitalObserver observer1 = new DigitalObserver();
        GraphObserver observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
