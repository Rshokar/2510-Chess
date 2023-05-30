
import java.awt.Color;

public class Pawn3D extends Pawn {
    private boolean firstTurn = true;

    public Pawn3D(int teamNum, Color color) {
        super(teamNum, color);
    }

    /**
     * This function gets the cordinates from a tile and highlights the valid tiles
     * to moves on.
     * 
     * @param board
     * @param tile
     */
    public void highlightValidMoves(GameBoard board, Tile tile) throws ArrayIndexOutOfBoundsException {
        int x, y, z;
        int[] cordinates = tile.getCordinates();
        x = cordinates[0];
        y = cordinates[1];
        z = cordinates[2];
        int spaces = firstTurn ? 2 : 1;
        int direction = (getTeamNun() == 0 ? 1 : -1);
        boolean flat = true;
        boolean up = true;
        boolean down = true;
        ChessBoard3D b = (ChessBoard3D) board;

        try {
            for (int i = 1; i <= spaces; i++) {
                if (flat)
                    flat = highLightIfEmptyAndEnemy(b.getTile(x + (i * direction), y, z));
                if (up && (z + i < b.getNumBoards()))
                    up = highLightIfEmptyAndEnemy(b.getTile(x + (i * direction), y, z + i));
                if (down && (z - i >= 0))
                    down = highLightIfEmptyAndEnemy(b.getTile(x + (i * direction), y, z - i));
            }
        } catch (ArrayIndexOutOfBoundsException err) {
            System.out.println(err);
        }
    }

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
