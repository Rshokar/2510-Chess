import java.awt.event.*;
import java.awt.GridLayout;

public class Chess3D extends Game {

    static String gameName = "3D - Chess";
    private final int numBoards;

    public Chess3D(int height, int width, int numBoards) {
        super(height, width, gameName);
        this.numBoards = numBoards;
        setBoard(new ChessBoard3D(getBoardHeight(), getBoardWidth(), getNumBoards()));
        setLayout(new GridLayout());
        addBoards();
        setSize(1500, 1000);
        setVisible(true);
        addActionListeners();
    }

    private void addBoards() {
        ChessBoard3D board = (ChessBoard3D) getBoard();
        for (int i = 0; i < board.getNumBoards(); i++) {
            add(board.getPanel(i));
        }
    }

    private int getNumBoards() {
        return this.numBoards;
    }

    public void addActionListeners() {
        ChessBoard3D board = (ChessBoard3D) getBoard();
        for (int b = 0; b < getNumBoards(); b++) {
            for (int i = 0; i < getBoardHeight(); i++) {
                for (int j = 0; j < getBoardWidth(); j++) {
                    board.getTile(i, j, b).addActionListener(this);
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        Tile tile = (Tile) e.getSource();
        if (getClickOne() == null && tile.isOnTeam(getCurrentPayer())) {
            setClickOne(tile);
            tile.highLight();
            tile.getPiece().highlightValidMoves(getBoard(), tile);
        } else if (getClickTwo() == null && getClickOne() != null) {
            if (tile.isOnTeam(getClickOne())) {
                getBoard().unHighlight();
                getClickOne().unHighlight();
                setClickOne(tile);
                tile.highLight();
                tile.getPiece().highlightValidMoves(getBoard(), tile);
            } else if (tile.isHightlighted()) {
                setClickTwo(tile);
                tile.highLight();
            }
        }

        if ((getClickOne() != null) && (getClickTwo() != null)) {
            exectuteTurn(getClickOne(), getClickTwo());
        }
    }

    public void exectuteTurn(Tile tileOne, Tile tileTwo) {
        getBoard().unHighlight();
        tileOne.getPiece().moveTo(tileOne, tileTwo);
        tileOne.unHighlight();
        tileTwo.unHighlight();
        setClickOne(null);
        setClickTwo(null);
        nextTurn();
    }

    public void nextTurn() {
        int nextPlayer = getCurrentPayer() == 0 ? 1 : 0;
        setCurrentPlayer(nextPlayer);
    }

    public static void main(String args[]) {
        final int WIDTH = 8;
        final int HEIGHT = 8;
        final int BOARDS = 3;
        new Chess3D(HEIGHT, WIDTH, BOARDS);
    }
}