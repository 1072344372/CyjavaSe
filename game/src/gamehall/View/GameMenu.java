package gamehall.View;

import gamehall.controller.Listener.ActionListener;
import gamehall.controller.itf.GameHallController;

import javax.swing.*;

/**
 * @author :罗汉
 * @date : 2024/1/22
 */
public class GameMenu extends JMenuBar {
    public GameMenu(GameHallController daDiShuController) {
        ActionListener myActionListener = new ActionListener(daDiShuController);

        JMenu jMenu = new JMenu("菜单");
        JMenuItem startItem = new JMenuItem("开始游戏");
        startItem.setActionCommand("start");
        startItem.addActionListener(myActionListener);
        jMenu.add(startItem);

        JMenuItem endItem = new JMenuItem("结束游戏");
        endItem.setActionCommand("end");
        endItem.addActionListener(myActionListener);
        jMenu.add(endItem);



        add(jMenu);
    }
}
