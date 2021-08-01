package ThePen;

public class Rectangle {

    private int width,height;
    private String color;

    public Rectangle(int width,int height,String color)
    {
        this.width=width;
        this.height=height;
        this.color=color;
    }

    public int getWidth()
    {
        return this.width;
    }
    public int getHeight()
    {
        return this.height;
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

