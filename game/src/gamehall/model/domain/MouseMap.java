package gamehall.model.domain;


public class MouseMap extends Map {
    private String type;
    private String [][] mouseBoard;

    private String defaultMap="┼";

    public MouseMap() {
        super();
    }

    public MouseMap(int rowSize, int colSize) {
        super(rowSize, colSize);
    }


    /**
     * 初始化板
     */
    @Override
    public void initializeBoard() {
        if (null == mouseBoard) {
            mouseBoard = new String[getRowSize()][getColSize()];
        }

        // 初始化绘制棋盘1
        // 两层循环画中心
        for (int i = 0; i < mouseBoard.length; i++) {
            for (int j = 0; j < mouseBoard[i].length; j++) {
                mouseBoard[i][j] = defaultMap;
            }
        }

        int BORDER = mouseBoard.length - 1;

        // 画边
        for (int i = 1; i < BORDER; i++) {
            mouseBoard[0][i] = "┬";
            mouseBoard[BORDER][i] = "┴";
            mouseBoard[i][0] = "├";
            mouseBoard[i][BORDER] = "┤";
        }

        // 直接画角
        mouseBoard[0][0] = "┌";
        mouseBoard[0][BORDER] = "┐";
        mouseBoard[BORDER][0] = "└";
        mouseBoard[BORDER][BORDER] = "┘";

        setMouseBoard(mouseBoard);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[][] getMouseBoard() {
        return mouseBoard;
    }

    public void setMouseBoard(String[][] mouseBoard) {
        this.mouseBoard = mouseBoard;
    }

    /**
     * 打印地图
     */
    @Override
    public void plantBoard() {
        // 优化打印
        for (int i = 0; i < mouseBoard.length; i++) {
            for (int j = 0; j < mouseBoard[i].length; j++) {
                System.out.print(mouseBoard[i][j] + " ");
            }
            System.out.println(i);
        }

        // 画棋盘底部
        for (int i = 0; i < mouseBoard[0].length; i++) {
            System.out.printf("%-3d", i);
        }
    }
}
