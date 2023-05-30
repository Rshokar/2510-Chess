
import java.awt.Color;

public class Bishop3D extends Bishop {
    public Bishop3D(int teamNum, Color color) {
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
        boolean ur = true;
        boolean dl = true;
        boolean ul = true;
        boolean dr = true;

        int x = tile.getXCordinate();
        int y = tile.getYCordinate();

        ChessBoard3D b = (ChessBoard3D) board;

        int i = 1;
        while (i < 8) {
            if (ur && (x + i < 8 && x + i >= 0) && (y + i < 8 && y + i > 0))
                ur = highLightIfEmptyAndEnemy(b.getTile(x + i, y + i, 0));
            if (dl && (x - i < 8 && x - i >= 0) && (y - i < 8 && y - i >= 0))
                dl = highLightIfEmptyAndEnemy(b.getTile(x - i, y - i, 0));
            if (ul && (x - i < 8 && x - i >= 0) && (y + i < 8 && y + i >= 0))
                ul = highLightIfEmptyAndEnemy(b.getTile(x - i, y + i, 0));
            if (dr && (x + i < 8 && x + i >= 0) && (y - i < 8 && y - i >= 0))
                dr = highLightIfEmptyAndEnemy(b.getTile(x + i, y - i, 0));
            i++;
        }
    };
}
