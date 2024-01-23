package gamehall.model.domain;

import gamehall.constant.GameConstant;
import gamehall.model.behavior.RandomPosition;

import java.util.Random;

public class Bomb implements RandomPosition {
    private int bombX;
    private int bombY;
    private String type = GameConstant.ZHA_DAN;
    private Random random = new Random();
    /**
     * 随机炸弹
     *
     * @param map 地图
     */
    public void randomMouse(Map map) {
        random = new Random();
        bombX = random.nextInt(map.getRowSize());
        bombY = random.nextInt(map.getColSize());
        String[][] mouseBoard = ((MouseMap) map).getMouseBoard();
        mouseBoard[bombX][bombY] = type;
    }

    /**
     * 反馈炸弹位置
     *
     * @return {@link String}
     */
    @Override
    public String feedBack() {
        return bombX + "," + bombY;
    }



    public int getBombX() {
        return bombX;
    }

    public void setBombX(int bombX) {
        this.bombX = bombX;
    }

    public int getBombY() {
        return bombY;
    }

    public void setBombY(int bombY) {
        this.bombY = bombY;
    }
}
