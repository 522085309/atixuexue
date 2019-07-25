package my_game_interface.designmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。
 * 比如，当一个对象被修改时，则会自动通知它的依赖对象。观察者模式属于行为型模式。
 *
 * Subject：抽象主题（抽象被观察者），抽象主题角色把所有观察者对象保存在一个集合里，每个主题都可以有任意数量的观察者，抽象主题提供一个接口，可以增加和删除观察者对象。
 ConcreteSubject：具体主题（具体被观察者），该角色将有关状态存入具体观察者对象，在具体主题的内部状态发生改变时，给所有注册过的观察者发送通知。
 Observer：抽象观察者，是观察者者的抽象类，它定义了一个更新接口，使得在得到主题更改通知时更新自己。
 ConcrereObserver：具体观察者，实现抽象观察者定义的更新接口，以便在得到主题更改通知时更新自身的状态。
 */
public class ObserverPattern {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        ConcrereObserver concrereObserver1 = new ConcrereObserver("aaa");
        ConcrereObserver concrereObserver2 = new ConcrereObserver("bbb");
        ConcrereObserver concrereObserver3 = new ConcrereObserver("ccc");
        concreteSubject.atach(concrereObserver1);
        concreteSubject.atach(concrereObserver2);
        concreteSubject.atach(concrereObserver3);
        concreteSubject.notify("改变了");
    }
}

interface Observer{
    public void updata(String msg);
}

class ConcrereObserver implements Observer{
    private String name;

    public ConcrereObserver(String name) {
        this.name = name;
    }

    @Override
    public void updata(String msg) {
        System.out.println(name + "--" +msg);
    }
}

interface Subject{
    //  添加
    public void atach(Observer observer);
    //  删除
    public void detach(Observer observer);
    //  更新
    public void notify(String msg);
}

class ConcreteSubject implements Subject{
    List<Observer> observerList = new ArrayList<>();
    @Override
    public void atach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notify(String msg) {
        for (Observer observer1 : observerList){
            observer1.updata(msg);
        }
    }
}

