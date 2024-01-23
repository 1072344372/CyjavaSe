package gamehall.model.domain.mouse;


import gamehall.constant.GameConstant;
import gamehall.model.behavior.Cry;
import gamehall.model.behavior.RandomPosition;
import gamehall.model.domain.Map;
import gamehall.model.domain.MouseMap;

import java.util.Random;

/**
 * 鼠标
 * 类型 名字 坐标x 坐标y 随机坐标的方法
 */
public class Mouse implements Cry, RandomPosition {
    private String type = GameConstant.WHITE_MOUSE;
    private String mouseName = "老鼠";
    private int mouseX;
    private int mouseY;
    private int mouseScore;

    private Random random = new Random();

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
        System.out.println(getMouseName()+"吱吱吱");
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


}
