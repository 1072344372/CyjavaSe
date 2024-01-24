package gamehall.model.domain.mouse;


import gamehall.constant.GameConstant;
import gamehall.model.behavior.Cry;
import gamehall.model.behavior.RandomPosition;
import gamehall.model.domain.Map;
import gamehall.model.domain.MouseMap;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 鼠标
 * 类型 名字 坐标x 坐标y 随机坐标的方法
 */
public class Mouse implements Cry, RandomPosition {
    private String type = GameConstant.DISHUHI_MOUSE;
    private String mouseName = "老鼠";
    private int mouseX = 50;
    private int mouseY = 30;
    private  int mouseH = 140;
    private  int mouseW = 150;
    private Image mouseImage;
    private int mouseScore;
    private boolean isHit=false;
    private Random random = new Random();

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public void drawMouse(Graphics g) {
        if (isHit){
            mouseImage = new ImageIcon(GameConstant.DISHUHI2_MOUSE).getImage();
            g.drawImage(mouseImage, mouseX, mouseY, mouseH, mouseW, null);
        }else {
            mouseImage = new ImageIcon(this.getType()).getImage();
            g.drawImage(mouseImage, mouseX, mouseY, mouseH, mouseW, null);
        }
    }

    public void mouseMove() {
        random = new Random();
        int num = random.nextInt(3) + 1;
        switch (num) {
            case 1:
                mouseX=50;
                mouseY=30;
                break;
            case 2:
                mouseX=150;
                mouseY=130;
                break;
            case 3:
                mouseX=250;
                mouseY=230;
                break;

        }
    }

    /**
     * 随机老鼠
     *
     * @param map 地图
     */
    public void randomMouse(Map map) {
        random = new Random();
        mouseX = random.nextInt(map.getRowSize());
        mouseY = random.nextInt(map.getColSize());
        String[][] mouseBoard = ((MouseMap) map).getMouseBoard();
        mouseBoard[mouseX][mouseY] = type;
    }

    @Override
    public void cry() {
        System.out.println(getMouseName() + "吱吱吱");
    }

    @Override
    public String feedBack() {
        return mouseX + "," + mouseY;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getMouseName() {
        return mouseName;
    }

    public void setMouseName(String mouseName) {
        this.mouseName = mouseName;
    }

    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    public int getMouseScore() {
        return mouseScore;
    }

    public void setMouseScore(int mouseScore) {
        this.mouseScore = mouseScore;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getMouseH() {
        return mouseH;
    }

    public void setMouseH(int mouseH) {
        this.mouseH = mouseH;
    }

    public int getMouseW() {
        return mouseW;
    }

    public void setMouseW(int mouseW) {
        this.mouseW = mouseW;
    }
}
