package gamehall.controller.time;


import gamehall.View.RightJPanel;
import gamehall.controller.DaDiShuController;
import gamehall.model.domain.Player;
import gamehall.model.domain.mouse.Mouse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseTime {// 地鼠定时器
    private int delay;// 时间间隔
    private Timer mouseTimer;
    private DaDiShuController daDiShuController;
    private Mouse mouse;
    private Player player;
    public static int countdownSeconds; // 倒计时秒数
    // 响应事件
    public ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            startCountdownSeconds();
            mouse = daDiShuController.getMouse();
            player=daDiShuController.getPlay();
            // if (countdownSeconds%2==0){
            mouse.mouseMove();// 地鼠移动


            if (getCountdownSeconds() <= 0) {
                mouseTimer.stop();  // 时间到，停止定时器
            }
            daDiShuController.getUi().getGameJFrame().repaint();

            //更新倒计时
            RightJPanel rightJPanel = daDiShuController.getUi().getGameJFrame().getRightJPanel();
            rightJPanel.getCountdownSeconds().setText("倒计时：" + getCountdownSeconds());



            mouse.setHit(false);
            player.setChuiType(1);
        }
    };

    public void startCountdownSeconds() {
        countdownSeconds--;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public Timer getMouseTimer() {
        return mouseTimer;
    }

    public void setMouseTimer(Timer mouseTimer) {
        this.mouseTimer = mouseTimer;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public int getCountdownSeconds() {
        return countdownSeconds;
    }

    public void setCountdownSeconds(int countdownSeconds) {
        this.countdownSeconds = countdownSeconds;
    }

    public MouseTime(DaDiShuController daDiShuController) {
        this.daDiShuController = daDiShuController;
        delay = 1000;
        mouseTimer = new Timer(delay, actionListener);
        countdownSeconds = 20;
    }
}
