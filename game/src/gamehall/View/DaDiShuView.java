package gamehall.View;

import gamehall.View.Itf.GameView;
import gamehall.controller.DaDiShuController;
import gamehall.controller.Listener.MyMouseMotionListener;
import gamehall.model.domain.mouse.Mouse;

import javax.swing.*;
import java.awt.*;

//TODO: 整合地图对象，老鼠对象，玩家对象，
public class DaDiShuView extends JPanel implements GameView {

    private DaDiShuController daDiShuController;
    public DaDiShuView(DaDiShuController daDiShuController) {
        this.daDiShuController = daDiShuController;
        setLayout(null);
        MyMouseMotionListener myMouseListener = new MyMouseMotionListener(daDiShuController);
        addMouseMotionListener(myMouseListener);
    }

    @Override
    public void paintComponent(Graphics g) {
        Mouse mouse = daDiShuController.getMouse();
        // Image imageIcon = new ImageIcon("E:\\cyStudy\\第一阶段\\javaSe\\game\\images\\loginBg.png").getImage();
        Image imageIcon = new ImageIcon("game/images/mbg.png").getImage();
        g.drawImage(imageIcon,0,0,710,620,null);
        mouse.drawMouse(g);
    }
}
