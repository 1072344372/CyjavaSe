package gamehall.controller.time;


import gamehall.controller.DaDiShuController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseTime {//地鼠定时器
    private int delay;//时间间隔
    private Timer mouseTimer;
    private DaDiShuController gameHallController;

    public static int countdownSeconds; // 倒计时秒数
    //响应事件
    public ActionListener actionListener=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("倒计时：" + getCountdownSeconds() + " 秒");
            startCountdownSeconds();
            if (getCountdownSeconds() <= 18) {
                mouseTimer.stop();  // 时间到，停止定时器
            }
            gameHallController.getUi().getGameJFrame().repaint();
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
    public MouseTime(DaDiShuController gameHallController) {
        System.out.println("构造方法执行了1次");
        this.gameHallController=gameHallController;
        delay=2000;
        mouseTimer=new Timer(delay,actionListener);
        countdownSeconds = 20; // 默认倒计时20秒
    }
}
