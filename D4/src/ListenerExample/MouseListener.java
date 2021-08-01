package ListenerExample;

import java.awt.event.MouseEvent;
import java.util.EventListener;

public interface MouseListener extends EventListener
{

    public void mouseClicked(ClickEvent clickEvent);

    void button_Clicked();
}
