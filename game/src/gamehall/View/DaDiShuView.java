package gamehall.View;

import gamehall.controller.Listener.MyMouseListener;

import javax.swing.*;
import java.awt.*;

//TODO: 整合地图对象，老鼠对象，玩家对象，
public class DaDiShuView extends JPanel {
    public DaDiShuView() {
        setLayout(null);
        MyMouseListener myMouseListener = new MyMouseListener();
        addMouseListener(myMouseListener);
    }

    @Override
    public void paintComponent(Graphics g) {
        // Image imageIcon = new ImageIcon("E:\\cyStudy\\第一阶段\\javaSe\\game\\images\\loginBg.png").getImage();
        Image imageIcon = new ImageIcon("game/images/beijing.jpg").getImage();
        g.drawImage(imageIcon,0,0,800,600,null);

        Image dsImage = new ImageIcon("game/images/dishu.png").getImage();
        g.drawImage(dsImage,20,20,200,100,null);
    }
}
