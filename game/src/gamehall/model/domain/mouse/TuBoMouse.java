package gamehall.model.domain.mouse;

import gamehall.constant.GameConstant;
import gamehall.model.domain.Map;
import gamehall.model.domain.MouseMap;

/**
 * 白鼠标
 * 类型 名字 坐标x 坐标y 随机坐标的方法
 */
public class TuBoMouse extends Mouse {

    public TuBoMouse() {
        super();
        this.setMouseScore(3);//设置老鼠分值
        this.setType(GameConstant.TUBO_MOUSE); // 设置类型
        this.setMouseName("土拨鼠"); // 设置名字
    }

    @Override
    public void randomMouse(Map map) {
        super.randomMouse(map); // 调用父类的随机老鼠方法
        String[][] mouseBoard = ((MouseMap) map).getMouseBoard();
        mouseBoard[this.getMouseX()][this.getMouseY()] = this.getType(); // 设置白老鼠的图案
    }
}
