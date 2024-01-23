package gamehall.View;


import gamehall.controller.DaDiShuController;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame {
    private RightJPanel rightJPanel;
    private DaDiShuView daDiShuView;
    private GameMenu gameMenu;
    private DaDiShuController daDiShuController;
    public GameJFrame(DaDiShuController daDiShuController) {
        this.daDiShuController=daDiShuController;
        setTitle("打地鼠游戏界面");
        setSize(800,600);
        setLocationRelativeTo(null);


        daDiShuView=new DaDiShuView();
        daDiShuView.setBackground(Color.ORANGE);
        this.add(daDiShuView,BorderLayout.CENTER);

        rightJPanel=new RightJPanel();
        rightJPanel.setPreferredSize(new Dimension(100,0));
        rightJPanel.setBackground(Color.cyan);
        this.add(rightJPanel,BorderLayout.EAST);

        gameMenu=new GameMenu(this.daDiShuController);
        setJMenuBar(gameMenu);
        setVisible(false);
    }

}
