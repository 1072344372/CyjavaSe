package gamehall.View;

import javax.swing.*;

/**
 * @author :罗汉
 * @date : 2024/1/22
 */
public class RightJPanel extends JPanel  {
    private JLabel scoreLabel;
    private JLabel combLabel;
    public RightJPanel() {
        setLayout(null);
        scoreLabel=new JLabel("得分: 0");
        scoreLabel.setBounds(20,30,100,30);
        add(scoreLabel);


        combLabel=new JLabel("联机数: 0");
        combLabel.setBounds(20,100,100,30);
        add(combLabel);
    }
}
