package ThePen;

public class Pen {

    public  void drawRectangle(Rectangle r)
    {
        int area=r.getHeight()*r.getWidth();
        System.out.println("Rectangle Area: " + area);
        System.out.println("Color: " + r.getColor());
    }
    public  void drawCircle(Circle c)
    {
        double area=c.getRadius()*c.getRadius()*3.14;
        System.out.println("Circle Area: " + area);
        System.out.println("Color: " + c.getColor());
    }
    public  void changeColorRectangle(String color, Rectangle r)
    {
        r.setColor(color);
        System.out.println("New Rectangle Color: "+r.getColor());
    }
    public  void changeColorCircle(String color, Circle c)
    {
        c.setColor(color);
        System.out.println("New Circle Color: "+c.getColor());
    }

    public static void main(String[] args)
    {
        Pen p1 = new Pen();
        Circle c1 = new Circle(15,"Blue");
        Rectangle r1 = new Rectangle(5,10,"Red");

        p1.drawRectangle(r1);
        p1.drawCircle(c1);

        p1.changeColorCircle("Black",c1);
        p1.changeColorRectangle("Green",r1);
    }
}

