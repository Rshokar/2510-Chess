
import java.awt.Color;

public class King extends Piece {
    public King(int teamNum, Color color) {
        super(teamNum, color);
        setType("King");
    }

    /**
     * This function gets the cordinates from a tile and highlights the valid tiles
     * to moves on.
     * 
     * @param board
     * @param tile
     */
    public void highlightValidMoves(GameBoard board, Tile tile) {
        int x = tile.getXCordinate();
        int y = tile.getYCordinate();

        if (x + 1 < 8 && (!board.getTile(x + 1, y).hasPiece()))
            highLightIfEmptyAndEnemy(board.getTile(x + 1, y));
        if (y + 1 < 8 && (!board.getTile(x, y + 1).hasPiece()))
            highLightIfEmptyAndEnemy(board.getTile(x, y + 1));
        if (x - 1 >= 0 && (!board.getTile(x - 1, y).hasPiece()))
            highLightIfEmptyAndEnemy(board.getTile(x - 1, y));
        if (y - 1 >= 0 && (!board.getTile(x, y - 1).hasPiece()))
            highLightIfEmptyAndEnemy(board.getTile(x, y - 1));

    }

    public void unhighlightValidMoves(GameBoard board, Tile tile) {
        int x = tile.getXCordinate();
        int y = tile.getYCordinate();
        if (x + 1 < 8)
            board.getTile(x + 1, y).unHighlight();
        if (y + 1 < 8)
            board.getTile(x, y + 1).unHighlight();
        if (x - 1 >= 0)
            board.getTile(x - 1, y).unHighlight();
        if (y - 1 >= 0)
            board.getTile(x, y - 1).unHighlight();
    };
}
