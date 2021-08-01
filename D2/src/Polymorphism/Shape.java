package Polymorphism;

public abstract class Shape implements Drawable
{
    private String Shape;


    public String getShape() {
        return Shape;
    }

    public void setShape(String shape) {
        Shape = shape;
    }

    public void drawShape(Shape s)
    {
        System.out.println("Shape: "+s.getShape());
    }

    public abstract void getDrawingInfo();

    public abstract double getArea();

}
