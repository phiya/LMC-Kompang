package leapmotion;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;
import com.leapmotion.leap.Gesture.Type;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
class CustomListener extends Listener {

public Robot robot;

public void onFrame(Controller c)
{
    try {robot = new Robot();} catch(Exception e) {}
    Frame frame = c.frame();
    InteractionBox box = frame.interactionBox();
            for (Hand h : frame.hands())
            {
                Vector handPos = h.palmPosition();
                Vector boxHandPos = box.normalizePoint(handPos);
                Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                robot.mouseMove((int)(screen.width * boxHandPos.getX()), (int)(screen.height - boxHandPos.getY() * screen.height));
            }
}
}
public class LeapMouse {

public static void Mouse(String[] args) {

    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}