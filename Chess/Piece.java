
import java.awt.Color;

public abstract class Piece {
    private String type;
    private int teamNum;
    private Color color;

    public Piece(int teamNum, Color color) {
        this.color = color;
        this.teamNum = teamNum;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTeamNun(int teamNum) {
        this.teamNum = teamNum;
    };

    public int getTeamNun() {
        return this.teamNum;
    };

    public boolean equals(Piece p) {
        return this.teamNum == p.getTeamNun();
    }

    public Color getColor() {
        return this.color;
    }

    /**
     * This function takes the piece from tile arguments and adds it to this. Then
     * sets tile argument piece to null.
     * 
     * @param tile
     */
    public void moveTo(Tile tileOne, Tile tileTwo) {
        tileTwo.setPiece(this);
        tileOne.setPiece(null);
    }

    /**
     * Checks to see if a tile has a peiece. If it does it returns false. If the
     * tile has an enemy piece or is empty it will highlight it.
     * 
     * @param tile
     * @return if piece has a tile false, otherwise true.
     */
    public boolean highLightIfEmptyAndEnemy(Tile tile) {
        if (!tile.hasPiece() || !tile.getPiece().equals(this))
            tile.highLight();
        return !tile.hasPiece();
    }

    public abstract void highlightValidMoves(GameBoard board, Tile tile);
}
