package my_game_interface.designmodel;

/**
 * 工厂模式
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory factoryProducer = FactoryProducer.getFactory("shape");
        Color red = factoryProducer.getColor("red");
        red.fill();
    }
}

/**
 * 定义公共接口（两个工厂）
 */
interface Shape1{
    void draw();
}
interface Color{
    void fill();
}

/**
 * 实现接口的类
 */
class Rectangle1 implements Shape1{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Circle1 implements Shape1 {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

class Red implements Color{
    @Override
    public void fill() {
        System.out.println("Red");
    }
}
class Blue implements Color{
    @Override
    public void fill() {
        System.out.println("Blue");
    }
}

/**
 * 抽象工厂
 */
abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape1 getShape(String shape);
}

/**
 * 颜色工厂
 */
class ColorFactory extends AbstractFactory{

    @Override
    Color getColor(String color) {
        if (color == null){
            return null;
        }
        if (color.equalsIgnoreCase("Red")){
            return new Red();
        }
        if (color.equalsIgnoreCase("blue")){
            return new Blue();
        }
        return null;
    }

    @Override
    Shape1 getShape(String shape) {
        return null;
    }
}

/**
 * 图形工厂
 */
class ShapeFactory1 extends AbstractFactory{
    @Override
    Color getColor(String color) {
        return null;
    }

    @Override
    Shape1 getShape(String shape) {
        if (shape == null){
            return null;
        }
        if (shape.equalsIgnoreCase("Rectangle1")){
            return new Rectangle1();
        }
        if (shape.equalsIgnoreCase("Circle1")){
            return new Circle1();
        }
        return null;
    }
}

/**
 * 工厂创造器，通过传入形状或者颜色来获取对应的工厂
 */
class FactoryProducer {
    static AbstractFactory getFactory(String choise){
        if (choise.equalsIgnoreCase("shape")){
            return new ColorFactory();
        }
        if (choise.equalsIgnoreCase("color")){
            return new ShapeFactory1();
        }
        return null;
    }
}

