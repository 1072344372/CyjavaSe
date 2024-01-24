package gamehall.controller.Listener;

import gamehall.controller.DaDiShuController;
import gamehall.model.domain.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 鼠标点击监听器
 *
 * @author 罗汉
 * @date 2024/01/24
 */
public class MyMouseListener implements MouseListener {
    private DaDiShuController daDiShuController;
    private Player play;

    public MyMouseListener() {
    }

    public MyMouseListener(DaDiShuController daDiShuController) {
        this.daDiShuController = daDiShuController;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
