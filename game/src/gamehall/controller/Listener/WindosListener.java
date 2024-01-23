package gamehall.controller.Listener;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class WindosListener implements WindowListener{
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane.showConfirmDialog(null,"退出游戏？","警告",JOptionPane.CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("关闭后");
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
