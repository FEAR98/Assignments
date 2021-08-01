package ThePen;

public class Circle {

    private int radius;
    private String color;

    public Circle(int radius,String color)
    {
        this.radius=radius;
        this.color=color;
    }

    public int getRadius()
    {
        return this.radius;
    }

    public void setColor(String color)
    {
        this.color=color;
    }
    public String getColor()
    {
        return this.color;
    }

}
