package gamehall.View;

import gamehall.controller.GameHallController;
import gamehall.controller.Listener.WindosListener;

import javax.swing.*;

/**
 * @author :罗汉
 * @date : 2024/1/22
 */
public class LoginJFrame extends JFrame {
    private LoginJPanel loginJpanel;
    public LoginJFrame(GameHallController gameHallController) {
        setTitle("登录界面");
        setSize(500, 500);
        setLocationRelativeTo(null);

        loginJpanel=new LoginJPanel(gameHallController);
        add(loginJpanel);

        //监听器
        WindosListener windosListener = new WindosListener();
        addWindowListener(windosListener);

        setVisible(false);
    }

    public LoginJPanel getLoginJpanel() {
        return loginJpanel;
    }

    public void setLoginJpanel(LoginJPanel loginJpanel) {
        this.loginJpanel = loginJpanel;
    }
}
