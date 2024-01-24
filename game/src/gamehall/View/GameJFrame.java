package gamehall.View;


import gamehall.controller.itf.GameHallController;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame {
    private RightJPanel rightJPanel;
    private DaDiShuView daDiShuView;
    private GameMenu gameMenu;
    private GameHallController gameHallController;
    public GameJFrame(GameHallController gameHallController) {
        this.gameHallController=gameHallController;
        setTitle(gameHallController.getGAMENAME());
        setSize(900,680);
        setLocationRelativeTo(null);

        this.add(gameHallController.getGameView(),BorderLayout.CENTER);

        rightJPanel=new RightJPanel();
        rightJPanel.setPreferredSize(new Dimension(190,0));
        rightJPanel.setBackground(Color.cyan);
        this.add(rightJPanel,BorderLayout.EAST);

        gameMenu=new GameMenu(this.gameHallController);
        setJMenuBar(gameMenu);
        setVisible(false);
    }

    public RightJPanel getRightJPanel() {
        return rightJPanel;
    }

    public void setRightJPanel(RightJPanel rightJPanel) {
        this.rightJPanel = rightJPanel;
    }

    public DaDiShuView getDaDiShuView() {
        return daDiShuView;
    }

    public void setDaDiShuView(DaDiShuView daDiShuView) {
        this.daDiShuView = daDiShuView;
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public void setGameMenu(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
    }

    public GameHallController getGameHallController() {
        return gameHallController;
    }

    public void setGameHallController(GameHallController gameHallController) {
        this.gameHallController = gameHallController;
    }
}
