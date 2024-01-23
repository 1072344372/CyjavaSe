package gamehall.model.domain;

public abstract class Map implements MapInterface{
    private Object[][] board;// 棋盘
    private int rowSize;// 行大小
    private int colSize;// 列大小

    public Map() {

    }

    public Map(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.board = new Object[rowSize][colSize];
        initializeBoard();
    }


    public Object[][] getBoard() {
        return board;
    }

    public void setBoard(Object[][] board) {
        this.board = board;
    }

    public int getRowSize() {
        return rowSize;
    }

    public void setRowSize(int rowSize) {
        this.rowSize = rowSize;
    }

    public int getColSize() {
        return colSize;
    }

    public void setColSize(int colSize) {
        this.colSize = colSize;
    }

    /**
     * 初始化
     */
    public abstract void initializeBoard();

    /**
     * 放置初始部件
     */
    public abstract void plantBoard();
}
