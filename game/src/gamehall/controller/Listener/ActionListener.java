package gamehall.controller.Listener;

import gamehall.View.LoginJFrame;
import gamehall.View.LoginJPanel;
import gamehall.View.UI;
import gamehall.controller.DaDiShuController;
import gamehall.controller.itf.GameHallController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ActionListener implements java.awt.event.ActionListener {
    private DaDiShuController daDiShuController;

    public ActionListener(GameHallController daDiShuController) {
        System.out.println("ActionListener执行了构造函数一次");
        this.daDiShuController = (DaDiShuController) daDiShuController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UI ui = daDiShuController.getUi();
        LoginJFrame loginJFrame = ui.getLoginJFrame();
        LoginJPanel loginJpanel = loginJFrame.getLoginJpanel();
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "login":
                String account = loginJpanel.getAccText().getText();
                String password = loginJpanel.getPasswordText().getText();
                String code = loginJpanel.getCodeText().getText();

                System.out.println("账号：" + account);
                System.out.println("密码：" + password);
                System.out.println("验证码：" + code);
                //todo: 登录效验做完整
                if ("1234".equals(code)){
                    daDiShuController.getUi().getLoginJFrame().setVisible(false);
                    daDiShuController.getUi().getGameJFrame().setVisible(true);
                }
                break;
            case "code":
                break;
            case "start":
                System.out.println("start");
                break;
            case "end":
                System.out.println("end");
                int i = JOptionPane.showConfirmDialog(null, "退出游戏？", "警告", JOptionPane.CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
                if (i==0) System.exit(0);
                break;
        }
    }
}
