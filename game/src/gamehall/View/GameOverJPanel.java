package gamehall.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author :罗汉
 * @date : 2024/1/22
 */
public class GameOverJPanel extends JPanel {
    private JLabel gameOverLabel;
    private JButton restartButton;
    private JButton exitButton;

    public GameOverJPanel() {
        setLayout(null);

        gameOverLabel = new JLabel("游戏结束");
        gameOverLabel.setBounds(50, 50, 200, 100);
        add(gameOverLabel);

        restartButton = new JButton("重新开始");
        restartButton.setBounds(170, 200, 150, 40);
        add(restartButton);

        exitButton = new JButton("退出游戏");
        exitButton.setBounds(170, 300, 150, 40);
        add(exitButton);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        Image imageIcon = new ImageIcon("game/images/lose.jpg").getImage();
        g.drawImage(imageIcon, 0, 0, 600, 600, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("游戏结束页面");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameOverJPanel gameOverPanel = new GameOverJPanel();
        frame.add(gameOverPanel);

        frame.setVisible(true);
    }
}
