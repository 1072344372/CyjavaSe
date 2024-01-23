package gamehall.dao;

import gamehall.model.domain.mouse.*;

import java.util.Random;

/**
 * 老师工厂
 *
 */
public class MouseFactory {

    private static final MouseFactory instance = new MouseFactory();
    private final Random random = new Random();
    private final YellowMouse yellowMouse=new YellowMouse();
    private final FieldMouse fieldMouse=new FieldMouse();
    private final TuBoMouse tuBoMouse=new TuBoMouse();
    private final Mouse mouse=new Mouse();

    private MouseFactory() {
    }

    public static MouseFactory getInstance() {
        return instance;
    }

    public Mouse createRandomMouse() {
        int randomNumber = random.nextInt(3); //黄老鼠，田鼠，土拨鼠
        switch (randomNumber) {
            case 0:
                return yellowMouse;
            case 1:
                return fieldMouse;
            case 2:
                return tuBoMouse;
            default:
                return mouse;
        }
    }
}
