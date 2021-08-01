package Polymorphism;

public class Rectangular extends Shape
{
    public Rectangular(String shape)
    {
        this.setShape(shape);
    }

    public void drawShape(Rectangular r)
    {
        System.out.println("Rectangular Shape: " + r.getShape());
    }

    @Override
    public void getDrawingInfo()
    {

    }

    @Override
    public double getArea()
    {
        return 0;
    }
}
