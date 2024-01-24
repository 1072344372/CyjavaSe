package gamehall.model.domain;

import gamehall.constant.GameConstant;

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
        this.chuiH=100;
        this.chuiW=100;
        this.playerName = "123";
        this.chuiImage = new ImageIcon(GameConstant.CHUI_OPEN).getImage();

    }
    public void drawChui(Graphics g) {
        if (chuiType == 1) {
            chuiImage = new ImageIcon(GameConstant.CHUI_OPEN).getImage();
            g.drawImage(chuiImage, playerX, playerY, chuiH, chuiW, null);

        } else {
            chuiImage = new ImageIcon(GameConstant.CHUI_CLOSE).getImage();
            g.drawImage(chuiImage, playerX, playerY, chuiH, chuiW, null);
        }
    }

    public int getChuiType() {
        return chuiType;
    }

    public void setChuiType(int chuiType) {
        this.chuiType = chuiType;
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

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerX=" + playerX +
                ", playerY=" + playerY +
                ", chuiH=" + chuiH +
                ", chuiW=" + chuiW +
                ", playerScore=" + playerScore +
                ", chuiType=" + chuiType +
                ", chuiImage=" + chuiImage +
                '}';
    }
}
