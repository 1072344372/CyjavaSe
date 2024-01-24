package gamehall.View;

import gamehall.View.Itf.GameView;
import gamehall.constant.GameConstant;
import gamehall.controller.DaDiShuController;
import gamehall.controller.Listener.MyMouseListener;
import gamehall.controller.Listener.MyMouseMotionListener;
import gamehall.model.domain.Player;
import gamehall.model.domain.mouse.Mouse;

import javax.swing.*;
import java.awt.*;

//TODO: 整合地图对象，老鼠对象，玩家对象，
public class DaDiShuView extends JPanel implements GameView {

    private DaDiShuController daDiShuController;
    private Player player;
    private Mouse mouse;
    public DaDiShuView(DaDiShuController daDiShuController) {
        this.daDiShuController = daDiShuController;
        setLayout(null);

    }

    /**
     * 设置监听器
     */
    public void setListener() {
        MyMouseListener myMouseListener = new MyMouseListener(daDiShuController);
        addMouseListener(myMouseListener);
        MyMouseMotionListener myMouseMotionListener = new MyMouseMotionListener(daDiShuController);
        addMouseMotionListener(myMouseMotionListener);
    }

    @Override
    public void paintComponent(Graphics g) {
        Image imageIcon = new ImageIcon(GameConstant.MBG).getImage();
        g.drawImage(imageIcon,0,0,710,620,null);

        mouse = daDiShuController.getMouse();
        mouse.drawMouse(g);
        player = daDiShuController.getPlay();
        player.drawChui(g);
    }
}
