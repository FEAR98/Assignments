package Polymorphism;

public class Circle extends Shape {
    public void drawShape(Circle c) {
        System.out.println("Circle Shape: " + c.getShape());
    }

    @Override
    public void getDrawingInfo() {

    }

    @Override
    public double getArea() {
        return 0;
    }
}
