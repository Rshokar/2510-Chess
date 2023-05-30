import javax.swing.JButton;
import java.awt.Color;

public class Tile extends JButton {
    private Piece piece;
    private Color highLightColor = Color.yellow;
    private Color backColor;

    private int x;
    private int y;

    public Tile(Piece piece, int x, int y, Color backGroundColor) {
        this.piece = piece;
        this.x = x;
        this.y = y;
        this.setBackground(backGroundColor);
        this.backColor = backGroundColor;
        if (piece != null) {
            this.setText(piece.getType());
            this.setForeground(piece.getColor());
        }
    }

    public int getXCordinate() {
        return this.x;
    }

    public int getYCordinate() {
        return this.y;
    }

    public Piece getPiece() {
        return this.piece;
    }

    /**
     * 
     * @return true if it has a piece.
     */
    public boolean hasPiece() {
        return piece != null;
    }

    public boolean isHightlighted() {
        return this.getBackground() == this.highLightColor;
    }

    public void setPiece(Piece p) {
        this.piece = p;
        if (p == null) {
            this.setText("");
            this.setForeground(null);
        } else {
            this.setText(piece.getType());
            this.setForeground(piece.getColor());
        }
    }

    public void highLight() {
        this.setBackground(this.highLightColor);
    }

    public void unHighlight() {
        this.setBackground(this.backColor);
    }

    public boolean isOnTeam(int teamNum) {
        if (this.piece == null) {
            return false;
        }
        return this.piece.getTeamNun() == teamNum;
    }

    public boolean isOnTeam(Tile tile) {
        if (this.piece == null) {
            return false;
        }
        return this.piece.getTeamNun() == tile.getPiece().getTeamNun();
    }
}
