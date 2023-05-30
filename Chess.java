import java.awt.event.*;
import java.awt.GridLayout;

public class Chess extends Game {

    static String gameName = "Chess";

    public Chess(int height, int width) {
        super(height, width, gameName);
        setBoard(new ChessBoard(getBoardHeight(), getBoardWidth()));
        setLayout(new GridLayout());
        add(getBoard().getPanel());
        setSize(900, 900);
        setVisible(true);
        addActionListeners();
    }

    public void addActionListeners() {
        GameBoard board = getBoard();
        for (int i = 0; i < getBoardHeight(); i++) {
            for (int j = 0; j < getBoardWidth(); j++) {
                board.getTile(i, j).addActionListener(this);
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
        new Chess(HEIGHT, WIDTH);
    }
}