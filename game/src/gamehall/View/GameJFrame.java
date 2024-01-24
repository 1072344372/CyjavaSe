package gamehall.View;


import gamehall.View.Itf.GameView;
import gamehall.controller.DaDiShuController;
import gamehall.controller.itf.GameHallController;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame {
    private RightJPanel rightJPanel;
    private DaDiShuView daDiShuView;
    private GameMenu gameMenu;
    private GameHallController gameHallController;
    public GameJFrame(GameHallController gameHallController, GameView gameView) {
        this.gameHallController=gameHallController;
        setTitle("打地鼠游戏界面");
        setSize(900,680);
        setLocationRelativeTo(null);


        // daDiShuView=new DaDiShuView(daDiShuController);
        // this.add(daDiShuView,BorderLayout.CENTER);

        // daDiShuView=new DaDiShuView(gameHallController);
        this.add((Component) gameView,BorderLayout.CENTER);

        rightJPanel=new RightJPanel();
        rightJPanel.setPreferredSize(new Dimension(190,0));
        rightJPanel.setBackground(Color.cyan);
        this.add(rightJPanel,BorderLayout.EAST);

        gameMenu=new GameMenu(this.gameHallController);
        setJMenuBar(gameMenu);
        setVisible(false);
    }

}
