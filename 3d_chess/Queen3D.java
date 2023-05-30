
import java.awt.Color;

public class Queen3D extends Queen {
    public Queen3D(int teamNum, Color color) {
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
        int x, y, z;
        int[] cordinates = tile.getCordinates();
        x = cordinates[0];
        y = cordinates[1];
        z = cordinates[2];
        int i = 1;
        ChessBoard3D b = (ChessBoard3D) board;
        horizontalMovement(x, y, z, i, b);
        verticalMovement(x, y, z, b);
    }

    private void horizontalMovement(int x, int y, int z, int i, ChessBoard3D board) {
        boolean right = true;
        boolean left = true;
        boolean forward = true;
        boolean back = true;
        boolean fl = true;
        boolean bl = true;
        boolean fr = true;
        boolean br = true;
        while (i < 8) {
            if (right && ((x + i) < 8))
                right = highLightIfEmptyAndEnemy(board.getTile(x + i, y, z));
            if (left && ((x - i) >= 0))
                left = highLightIfEmptyAndEnemy(board.getTile(x - i, y, z));
            if (back && ((y - i) >= 0))
                back = highLightIfEmptyAndEnemy(board.getTile(x, y - i, z));
            if (forward && ((y + i) < 8))
                forward = highLightIfEmptyAndEnemy(board.getTile(x, y + i, z));
            if (fl && (x + i < 8 && x + i >= 0) && (y + i < 8 && y + i > 0))
                fl = highLightIfEmptyAndEnemy(board.getTile(x + i, y + i, z));
            if (bl && (x - i < 8 && x - i >= 0) && (y - i < 8 && y - i >= 0))
                bl = highLightIfEmptyAndEnemy(board.getTile(x - i, y - i, z));
            if (fr && (x - i < 8 && x - i >= 0) && (y + i < 8 && y + i >= 0))
                fr = highLightIfEmptyAndEnemy(board.getTile(x - i, y + i, z));
            if (br && (x + i < 8 && x + i >= 0) && (y - i < 8 && y - i >= 0))
                br = highLightIfEmptyAndEnemy(board.getTile(x + i, y - i, z));
            i++;
        }
    }

    private void verticalMovement(int x, int y, int z, ChessBoard3D board) {
        boolean rightUp = true;
        boolean rightDown = true;

        boolean leftUp = true;
        boolean leftDown = true;

        boolean forwardUp = true;
        boolean forwardDown = true;

        boolean backUp = true;
        boolean backDown = true;

        boolean flUp = true;
        boolean flDown = true;

        boolean blUp = true;
        boolean blDown = true;

        boolean frUp = true;
        boolean frDown = true;

        boolean brUp = true;
        boolean brDown = true;
        int numBoard = board.getNumBoards();

        for (int i = 1; i < numBoard; i++) {
            if (rightUp && ((x + i) < 8) && (z + i) < numBoard)
                rightUp = highLightIfEmptyAndEnemy(board.getTile(x + i, y, z + i));
            if (rightDown && ((x + i) < 8) && (z - i) >= 0)
                rightDown = highLightIfEmptyAndEnemy(board.getTile(x + i, y, z - i));

            if (leftUp && ((x - i) >= 0) && (z + i) < numBoard)
                leftUp = highLightIfEmptyAndEnemy(board.getTile(x - i, y, z + i));
            if (leftDown && ((x - i) >= 0) && (z - i) >= 0)
                leftDown = highLightIfEmptyAndEnemy(board.getTile(x - i, y, z - i));

            if (backUp && ((y - i) >= 0) && (z + i) < numBoard)
                backUp = highLightIfEmptyAndEnemy(board.getTile(x, y - i, z + i));
            if (backDown && ((y - i) >= 0) && (z - i) >= 0)
                backDown = highLightIfEmptyAndEnemy(board.getTile(x, y - i, z - i));

            if (forwardUp && ((y + i) < 8) && (z + i) < numBoard)
                forwardUp = highLightIfEmptyAndEnemy(board.getTile(x, y + i, z + i));
            if (forwardDown && ((y + i) < 8) && (z - i) >= 0)
                forwardDown = highLightIfEmptyAndEnemy(board.getTile(x, y + i, z - i));

            if (flUp && (x + i < 8 && x + i >= 0) && (y + i < 8 && y + i > 0) && (z + i) < numBoard)
                flUp = highLightIfEmptyAndEnemy(board.getTile(x + i, y + i, z + i));
            if (flDown && (x + i < 8 && x + i >= 0) && (y + i < 8 && y + i > 0) && (z - i) >= 0)
                flDown = highLightIfEmptyAndEnemy(board.getTile(x + i, y + i, z - i));

            if (blUp && (x - i < 8 && x - i >= 0) && (y - i < 8 && y - i >= 0) && (z + i) < numBoard)
                blUp = highLightIfEmptyAndEnemy(board.getTile(x - i, y - i, z + i));
            if (blDown && (x - i < 8 && x - i >= 0) && (y - i < 8 && y - i >= 0) && (z - i) >= 0)
                blDown = highLightIfEmptyAndEnemy(board.getTile(x - i, y - i, z - i));

            if (frUp && (x - i < 8 && x - i >= 0) && (y + i < 8 && y + i >= 0) && (z + i) < numBoard)
                frUp = highLightIfEmptyAndEnemy(board.getTile(x - i, y + i, z + i));
            if (frDown && (x - i < 8 && x - i >= 0) && (y + i < 8 && y + i >= 0) && (z - i) >= 0)
                frDown = highLightIfEmptyAndEnemy(board.getTile(x - i, y + i, z - i));

            if (brUp && (x + i < 8 && x + i >= 0) && (y - i < 8 && y - i >= 0) && (z + i) < numBoard)
                brUp = highLightIfEmptyAndEnemy(board.getTile(x + i, y - i, z + i));
            if (brDown && (x + i < 8 && x + i >= 0) && (y - i < 8 && y - i >= 0) && (z - i) >= 0)
                brDown = highLightIfEmptyAndEnemy(board.getTile(x + i, y - i, z - i));
        }
    }
}
