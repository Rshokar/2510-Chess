import javax.swing.*;

import java.awt.*;

public class ChessBoard3D extends GameBoard {

    private final Color TEAM_ZERO_COLOR = Color.green;
    private final Color TEAM_ONE_COLOR = Color.blue;
    private final int numBoards;

    private Tile[][][] tiles;
    private JPanel[] pannels;

    public ChessBoard3D(int height, int width, int numBoards) {
        super(height, width);
        this.numBoards = numBoards;
        this.tiles = new Tile[numBoards][height][width];
        this.pannels = new JPanel[numBoards];
        addJPannels();
        setUpBoard();
        setUpJPanel();
        displayPanel();
        addButtonsToJPanel();
    }

    public Tile getTile(int x, int y, int z) {
        return this.tiles[z][x][y];
    }

    public int getNumBoards() {
        return this.numBoards;
    }

    public void setTile(int x, int y, int z, Tile tile) {
        this.tiles[z][x][y] = tile;
    }

    public JPanel getPanel(int index) {
        return this.pannels[index];
    }

    public void displayPanel() {
        for (int i = 0; i < this.pannels.length; i++) {
            pannels[i].setVisible(true);
        }
    }

    private void addJPannels() {
        for (int i = 0; i < getNumBoards(); i++) {
            this.pannels[i] = new JPanel();
        }
    }

    protected void setUpJPanel() {
        for (int i = 0; i < getNumBoards(); i++) {
            pannels[i].setPreferredSize(new Dimension(500, 1000));
            pannels[i].setBackground(Color.BLACK);
        }
    }

    protected void setUpBoard() {
        int teamNum;
        Color color, backGroundColor;
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                teamNum = i < 2 ? 0 : 1;
                color = i < 2 ? TEAM_ZERO_COLOR : TEAM_ONE_COLOR;
                backGroundColor = (i + j) % 2 == 0 ? Color.RED : Color.WHITE;
                setTile(i, j, 0, new Tile3D(createPiece(i, j, teamNum, color), i, j, 0, backGroundColor));
                getTile(i, j, 0).setVisible(true);
                getTile(i, j, 0).setPreferredSize(new Dimension(62, 100));
            }
        }

        for (int i = 1; i < numBoards; i++) {
            for (int x = 0; x < getHeight(); x++) {
                for (int y = 0; y < getWidth(); y++) {
                    backGroundColor = (x + y) % 2 == 0 ? Color.RED : Color.WHITE;
                    setTile(x, y, i, new Tile3D(null, x, y, i, backGroundColor));
                    getTile(x, y, i).setVisible(true);
                    getTile(x, y, i).setPreferredSize(new Dimension(62, 100));
                }
            }
        }

    }

    private Piece createPiece(int height, int width, int team, Color color) {
        int heightMinusOne = getHeight() - 1;
        int heightMinusTwo = getHeight() - 2;
        if (height == heightMinusOne || height == 0) {
            return createSpecialPiece(width, team, color);
        } else if (height == heightMinusTwo || height == 1) {
            return newPawn(team, color);
        }
        return null;
    }

    private Piece createSpecialPiece(int column, int team, Color color) {
        if (column == 0 || column == 7) {
            return new Rook3D(team, color);
        } else if (column == 1 || column == 6) {
            return new Knight3D(team, color);
        } else if (column == 2 || column == 5) {
            return new Bishop3D(team, color);
        } else if (column == 3) {
            return new Queen3D(team, color);
        } else if (column == 4) {
            return new King3D(team, color);
        }
        return null;
    }

    protected void addButtonsToJPanel() {
        for (int pannel = 0; pannel < getNumBoards(); pannel++) {
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getWidth(); j++) {
                    System.out.println("Pannel: " + pannel + " Height: " + i + " Width: " + j);
                    pannels[pannel].add(getTile(i, j, pannel));
                }
            }
        }
    }

    private Piece newPawn(int team, Color color) {
        return new Pawn3D(team, color);
    }

    public void unHighlight() {
        for (int b = 0; b < getNumBoards(); b++) {
            for (int x = 0; x < getHeight(); x++) {
                for (int y = 0; y < getWidth(); y++) {
                    tiles[b][x][y].unHighlight();
                }
            }
        }
    }

}