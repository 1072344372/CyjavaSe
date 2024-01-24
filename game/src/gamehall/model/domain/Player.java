package gamehall.model.domain;

import javax.swing.*;
import java.awt.*;

/**
 * 玩家
 * 账户、姓名、金钱、（名称，坐标，得分，自定义地图方法，输入坐标打地鼠方法）
 */
public class Player extends User {
    private String playerName;
    private int playerX;
    private int playerY;
    private int chuiH;
    private int chuiW;
    private int playerScore;
    private int chuiType = 1;
    private Image chuiImage;


    public Player() {
        this.playerX = 100;
        this.playerY = 100;
        this.playerName = "123";
        this.chuiImage = new ImageIcon("images/chui2.png").getImage();

    }

    public void drawChui(Graphics g) {
        if (chuiType == 1) {
            chuiImage = new ImageIcon("images/chui2.png").getImage();
            g.drawImage(chuiImage, playerX, playerY, chuiH, chuiW, null);

        } else {
            chuiImage = new ImageIcon("images/chui1.png").getImage();
            g.drawImage(chuiImage, playerX, playerY, chuiH, chuiW, null);
        }
    }


    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public int getChuiH() {
        return chuiH;
    }

    public void setChuiH(int chuiH) {
        this.chuiH = chuiH;
    }

    public int getChuiW() {
        return chuiW;
    }

    public void setChuiW(int chuiW) {
        this.chuiW = chuiW;
    }

    public Image getChuiImage() {
        return chuiImage;
    }

    public void setChuiImage(Image chuiImage) {
        this.chuiImage = chuiImage;
    }

}
