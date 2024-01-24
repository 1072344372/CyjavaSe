package gamehall.controller.Listener;

import gamehall.controller.DaDiShuController;
import gamehall.model.domain.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * 鼠标移动监听器
 *
 */
public class MyMouseMotionListener implements MouseMotionListener {
    private DaDiShuController daDiShuController;
    private Player play;

    public MyMouseMotionListener() {

    }

    public MyMouseMotionListener(DaDiShuController daDiShuController) {
        System.out.println("MyMouseMotionListener构造器执行了一次\n"+daDiShuController);
        this.daDiShuController=daDiShuController;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        play = daDiShuController.getPlay();
        play.setPlayerX(e.getX()-90);
        play.setPlayerY(e.getY()-90);
        daDiShuController.getUi().getGameJFrame().repaint();//刷新画面
    }
}
