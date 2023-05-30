
import java.awt.Color;

public class King3D extends King {
    public King3D(int teamNum, Color color) {
        super(teamNum, color);
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

        ChessBoard3D b = (ChessBoard3D) board;

        if (x + 1 < 8 && (!b.getTile(x + 1, y, 0).hasPiece()))
            highLightIfEmptyAndEnemy(b.getTile(x + 1, y, 0));
        if (y + 1 < 8 && (!b.getTile(x, y + 1, 0).hasPiece()))
            highLightIfEmptyAndEnemy(b.getTile(x, y + 1, 0));
        if (x - 1 >= 0 && (!b.getTile(x - 1, y, 0).hasPiece()))
            highLightIfEmptyAndEnemy(b.getTile(x - 1, y, 0));
        if (y - 1 >= 0 && (!b.getTile(x, y - 1, 0).hasPiece()))
            highLightIfEmptyAndEnemy(b.getTile(x, y - 1, 0));

    }
}
