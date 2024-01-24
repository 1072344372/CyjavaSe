package gamehall.controller.Listener;

import gamehall.View.LoginJFrame;
import gamehall.View.LoginJPanel;
import gamehall.controller.UserController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private LoginJFrame loginJFrame;
    private LoginJPanel loginJPanel;

    // public LoginListener(LoginJFrame loginJFrame) {
    //     this.loginJFrame = loginJFrame;
    // }
    public LoginListener(LoginJPanel loginJPanel) {
        this.loginJPanel = loginJPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "login":
                String account = loginJPanel.getAccText().getText();
                String password = loginJPanel.getPasswordText().getText();
                String code = loginJPanel.getCodeText().getText();

                System.out.println("账号：" + account);
                System.out.println("密码：" + password);
                System.out.println("验证码：" + code);
                // todo: 登录效验做完整
                if ("1234".equals(code)) {
                    UserController.isLogin=true;
                    loginJPanel.setVisible(false);
                }
                break;
            case "code":
                break;
        }
    }
}
