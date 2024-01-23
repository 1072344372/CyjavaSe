package gamehall.View;

import javax.swing.*;

public class RegisterFrame extends JFrame {
    private JTextField account;
    private JTextField userPwd;

    private RegisterPanel registerPanel;
    private JButton registerBtn;

    public RegisterFrame() {
        registerPanel = new RegisterPanel();
        registerPanel.setLayout(null);  // 设置布局管理器为 null
        this.setContentPane(registerPanel);  // 设置内容面板为 registerPanel

        setTitle("注册窗口");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(false);

        registerFuntion();
    }

    public void registerFuntion(){
        setLayout(null);
        //输入账号
        JLabel label1 = new JLabel("请输入账号：");
        label1.setBounds(50, 20, 200, 35);
        registerPanel.add(label1);
        account = new JTextField();
        account.setBounds(150, 20, 200, 35);
        registerPanel.add(account);

        //输入密码
        JLabel label2 = new JLabel("请输入密码：");
        label2.setBounds(50, 75, 200, 35);
        registerPanel.add(label2);
        userPwd = new JPasswordField();
        userPwd.setBounds(150, 75, 200, 35);
        registerPanel.add(userPwd);


        //注册按钮
        registerBtn = new JButton("注册");
        registerBtn.setBounds(140, 380, 100, 50);
        registerPanel.add(registerBtn);


        setVisible(true);
    }

    public static void main(String[] args) {
        RegisterFrame registerFrame = new RegisterFrame();
    }
}
