
import java.awt.Color;

public class Knight3D extends Knight {
    public Knight3D(int teamNum, Color color) {
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
        int rise = 2;
        int run = 1;

        for (int i = 0; i < 4; i++) {
            if (x + run < 8 && x + run >= 0 && y + rise < 8 && y + rise >= 0)
                highLightIfEmptyAndEnemy(b.getTile(x + run, y + rise, 0));
            if (x + rise < 8 && x + rise >= 0 && y + run < 8 && y + run >= 0)
                highLightIfEmptyAndEnemy(b.getTile(x + rise, y + run, 0));

            rise = i < 3 ? rise * -1 : rise;
            run = i == 1 ? run * -1 : run;

        }
    }
}
