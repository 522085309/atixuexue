package my_game_interface.designmodel;

/**
 * 工厂模式
 */
public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape rectangle = shapeFactory.getShape("Rectangle");
        rectangle.draw();
    }
}

/**
 * 定义公共接口
 */
interface Shape{
    void draw();
}

/**
 * 实现接口的类
 */
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

/**
 * 创建一个工厂，生成基于给定信息的类
 */
class ShapeFactory{
    public Shape getShape(String shapeType){
        if (shapeType == null){
            return null;
        }
        if (shapeType.equalsIgnoreCase("Circle")){
            return new Circle();
        }
        if (shapeType.equalsIgnoreCase("Rectangle")){
            return new Rectangle();
        }
        return null;
    }
}
