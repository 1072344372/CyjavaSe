package gamehall.controller.Listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author :罗汉
 * @date : 2024/1/23
 */
public class MyMouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("e.getX()+\"-\"+e.getY() = " + e.getX() + "-" + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("e.getX()+\"-\"+e.getY() = " + e.getX()+"-"+e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("e.getX()+\"-\"+e.getY() = " + e.getX()+"-"+e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("e.getX()+\"-\"+e.getY() = " + e.getX()+"-"+e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("e.getX()+\"-\"+e.getY() = " + e.getX()+"-"+e.getY());
    }
}
