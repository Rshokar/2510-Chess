
import java.awt.Color;

public class Rook3D extends Rook {
    public Rook3D(int teamNum, Color color) {
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
        // Direction on the gameboard ur = Up-Right, dl = Down-Left...
        boolean right = true;
        boolean left = true;
        boolean forward = true;
        boolean back = true;

        int x = tile.getXCordinate();
        int y = tile.getYCordinate();
        ChessBoard3D b = (ChessBoard3D) board;

        int i = 1;
        while (i < 8) {
            if (right && ((x + i) < 8))
                right = highLightIfEmptyAndEnemy(b.getTile(x + i, y, 0));
            if (left && ((x - i) >= 0))
                left = highLightIfEmptyAndEnemy(b.getTile(x - i, y, 0));
            if (back && ((y - i) >= 0))
                back = highLightIfEmptyAndEnemy(b.getTile(x, y - i, 0));
            if (forward && ((y + i) < 8))
                forward = highLightIfEmptyAndEnemy(b.getTile(x, y + i, 0));
            i++;
        }
    }
}
