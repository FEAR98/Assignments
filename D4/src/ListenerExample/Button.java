package ListenerExample;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Button
{
    private Style style;
    private String text;

    private MouseListener myDefaultListener = new MouseListener() {
        @Override
        public void mouseClicked(ClickEvent clickEvent) {

        }

        @Override
        public void button_Clicked() {

        }
    };

    public void inlineClass(final String name)
    {
        class InnerMethodClass
        {
            public void test()
            {
                System.out.println(name);
            }
        }
    }


    private List<MouseListener> mouseListeners = new ArrayList<MouseListener>();

    public  void addMouseClickListener(MouseListener listener)
    {
        mouseListeners.add(listener);
    }

    public  void removeMouseClickListener(MouseListener listener)
    {
        mouseListeners.remove(listener);
    }

    public void click(int x, int y)
    {
        for(MouseListener ml: mouseListeners)
        {
            ml.mouseClicked(new ClickEvent(this,x,y));
            System.out.println("X: "+ x + "Y: " + y);
        }

    }

    public void setStyle(Style style)
    {
        this.style=style;
    }

    public static  class Style{
        private String textColor;

        public void changeButtonText()
        {
//            System.out.println(this.text);
        }
    }
}
