package ListenerExample;

public class Executer
{
    public static void main(String[] args)
    {
        Form f = new Form();
        Button b = new Button();

        b.addMouseClickListener(f);
        b.removeMouseClickListener(f);

        b.click(40,50);

        Button.Style buttoStyle = new Button.Style();
    }
}
