import java.awt.Color;

public class Tile3D extends Tile {

    private int z;

    public Tile3D(Piece piece, int x, int y, int z, Color backGroundColor) {
        super(piece, x, y, backGroundColor);
        this.z = z;
    }

    public int getZCordinate() {
        return this.z;
    }

    public int[] getCordinates() {
        int[] cordinates = { getXCordinate(), getYCordinate(), this.z };
        return cordinates;
    }
}
