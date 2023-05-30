
import java.awt.Color;

public class Pawn extends Piece {
    private boolean firstTurn = true;

    public Pawn(int teamNum, Color color) {
        super(teamNum, color);
        setType("Pawn");
    }

    /**
     * This function gets the cordinates from a tile and highlights the valid tiles
     * to moves on.
     * 
     * @param board
     * @param tile
     */
    public void highlightValidMoves(GameBoard board, Tile tile) throws ArrayIndexOutOfBoundsException {
        int x = tile.getXCordinate();
        int y = tile.getYCordinate();
        int spaces = firstTurn ? 2 : 1;
        int direction = (getTeamNun() == 0 ? 1 : -1);
        boolean foundPiece = true;

        try {
            for (int i = 1; i <= spaces && foundPiece; i++) {
                foundPiece = highLightIfEmptyAndEnemy(board.getTile(x + (i * direction), y));
            }
        } catch (ArrayIndexOutOfBoundsException err) {
            System.out.println(err);
        }
    }

    public void unhighlightValidMoves(GameBoard board, Tile tile) {
        int x = tile.getXCordinate();
        int y = tile.getYCordinate();
        int spaces = firstTurn ? 2 : 1;
        int direction = (getTeamNun() == 0 ? 1 : -1);

        try {
            for (int i = 1; i <= spaces; i++) {
                board.getTile(x + (i * direction), y).unHighlight();
            }
        } catch (ArrayIndexOutOfBoundsException err) {
            System.out.println(err);
        }

    };

    /**
     * This function takes the piece from tile arguments and adds it to this. Then
     * sets tile argument piece to null.
     * 
     * @param tile
     */
    public void moveTo(Tile tileOne, Tile tileTwo) {
        this.firstTurn = false;
        tileTwo.setPiece(this);
        tileOne.setPiece(null);
    }

}
