package gamehall.controller.Listener;

import gamehall.controller.DaDiShuController;
import gamehall.model.domain.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


/**
 * 鼠标移动监听器
 *
 * @author 罗汉
 * @date 2024/01/24
 */
public class MyMouseMotionListener implements MouseMotionListener {
    private DaDiShuController daDiShuController;
    private Player play;

    public MyMouseMotionListener() {
    }

    public MyMouseMotionListener(DaDiShuController daDiShuController) {
        this.daDiShuController=daDiShuController;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        play = daDiShuController.getPlay();
        // play.setPlayerX(e.getX());
        // play.setPlayerY(e.getY());
        // daDiShuController.getUi().getGameJFrame().repaint();
    }
}
