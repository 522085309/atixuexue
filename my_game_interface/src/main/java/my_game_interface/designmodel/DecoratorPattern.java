package my_game_interface.designmodel;

/**
 * 装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。
 * 这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。
 */
public class DecoratorPattern {
    public static void main(String[] args) {
//        Shape2 circle = new Circle2();
//        circle.draw();
//        ShapeDecorator redCircle = new RedShapeDecorator(new Circle2());
//        redCircle.draw();
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle2());
        redRectangle.draw();
    }
}

interface Shape2 {
    void draw();
}

class Rectangle2 implements Shape2 {
    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}

class Circle2 implements Shape2 {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

abstract class ShapeDecorator implements Shape2{
    protected Shape2 decoratedShape;

    public ShapeDecorator(Shape2 decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator{
    public RedShapeDecorator(Shape2 decoratedShape) {
        super(decoratedShape);
    }
    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape2 decoratedShape){
        System.out.println("Red");
    }
}
