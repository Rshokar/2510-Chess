
import java.awt.Color;

public class Rook extends Piece {
    public Rook(int teamNum, Color color) {
        super(teamNum, color);
        setType("Rook");
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
        boolean up = true;
        boolean down = true;

        int x = tile.getXCordinate();
        int y = tile.getYCordinate();

        int i = 1;
        while (i < 8) {
            if (right && ((x + i) < 8))
                right = highLightIfEmptyAndEnemy(board.getTile(x + i, y));
            if (left && ((x - i) >= 0))
                left = highLightIfEmptyAndEnemy(board.getTile(x - i, y));
            if (down && ((y - i) >= 0))
                down = highLightIfEmptyAndEnemy(board.getTile(x, y - i));
            if (up && ((y + i) < 8))
                up = highLightIfEmptyAndEnemy(board.getTile(x, y + i));
            i++;
        }
    }

    public void unhighlightValidMoves(GameBoard board, Tile tile) {
        int x = tile.getXCordinate();
        int y = tile.getYCordinate();

        int i = 1;
        while (i < 8) {
            if ((x + i) < 8) {
                board.getTile(x + i, y).unHighlight();
            }
            if ((x - i) >= 0) {
                board.getTile(x - i, y).unHighlight();
            }
            if ((y - i) >= 0) {
                board.getTile(x, y - i).unHighlight();
            }
            if ((y + i) < 8) {
                board.getTile(x, y + i).unHighlight();
            }
            i++;
        }
    };

}
