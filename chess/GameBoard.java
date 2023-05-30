import javax.swing.*;

abstract class GameBoard {

    private int height;
    private int width;

    private Tile[][] tiles;
    private JPanel panel;

    public GameBoard(int height, int width) {
        this.height = height;
        this.width = width;
        this.panel = new JPanel();
        tiles = new Tile[height][width];
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public Tile getTile(int x, int y) {
        return this.tiles[x][y];
    }

    public void setTile(int x, int y, Tile tile) {
        this.tiles[x][y] = tile;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void displayPanel() {
        this.panel.setVisible(true);
    }

    protected abstract void setUpJPanel();

    protected abstract void setUpBoard();

    protected abstract void addButtonsToJPanel();

}
