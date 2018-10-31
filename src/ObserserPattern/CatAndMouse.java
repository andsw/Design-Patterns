package ObserserPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hsw
 * @create 2018-10-31  18:59
 */

abstract class MySubject {

    protected List<MyObserver> observers;

    public abstract void attach(MyObserver observer);
    public abstract void detach(MyObserver observer);
    public abstract void notifyObservers();
    public abstract void meow();

}

interface MyObserver {
    void response();
}

class ConcreteCat extends MySubject {

    public ConcreteCat() {
        observers = new ArrayList<>();
    }

    @Override
    public void attach(MyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(MyObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(MyObserver::response);
    }

    @Override
    public void meow() {
        System.out.println("cat is meowing!");
        notifyObservers();
    }
}

class ConcreteDog implements MyObserver {

    @Override
    public void response() {
        System.out.println("dog is barking!");
    }
}

class ConcreteMouse implements MyObserver {

    @Override
    public void response() {
        System.out.println("mouse is running away!");
    }
}

public class CatAndMouse {

    public static void main(String[] args) {
        MySubject cat = new ConcreteCat();
        MyObserver dog = new ConcreteDog();
        MyObserver mouse = new ConcreteMouse();

        cat.attach(dog);
        cat.meow();

        System.out.println();
        cat.attach(mouse);
        cat.meow();

        System.out.println();
        cat.detach(dog);
        cat.meow();
    }
}
