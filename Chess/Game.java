import java.awt.event.*;

import javax.swing.JFrame;

public abstract class Game extends JFrame implements ActionListener {
    private GameBoard board;

    private Tile clickOne = null;
    private Tile clickTwo = null;

    private final int boardHeight;
    private final int boardWidth;

    private int currentPlayer;

    /**
     * 
     * @param args
     */
    public Game(int height, int width, String gameName) {
        super(gameName);
        this.boardHeight = height;
        this.boardWidth = width;
    }

    public int getBoardHeight() {
        return this.boardHeight;
    }

    public int getBoardWidth() {
        return this.boardWidth;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public GameBoard getBoard() {
        return this.board;
    }

    public Tile getClickOne() {
        return this.clickOne;
    }

    public Tile getClickTwo() {
        return this.clickTwo;
    }

    public void setClickOne(Tile tile) {
        this.clickOne = tile;
    }

    public void setClickTwo(Tile tile) {
        this.clickTwo = tile;
    }

    public int getCurrentPayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(int playerNum) {
        this.currentPlayer = playerNum;
    }

    abstract public void exectuteTurn(Tile tileOne, Tile tileTwo);

    abstract public void nextTurn();

    abstract public void addActionListeners();
}