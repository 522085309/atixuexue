package my_game_interface.designmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。
 * 比如，当一个对象被修改时，则会自动通知它的依赖对象。观察者模式属于行为型模式。
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new HexaObserver(subject);
        subject.setState(15);
    }
}

abstract class Observer{
    public Subject subject;
    abstract void update();
}

class Subject{
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers){
            observer.update();
        }
    }
}

class BinaryObserver extends Observer{
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("aaa");
    }
}

class HexaObserver  extends Observer{
    public HexaObserver (Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("bbb");
    }
}
