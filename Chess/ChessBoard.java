import javax.swing.*;

import java.awt.*;

public class ChessBoard extends GameBoard {

    private final Color TEAM_ZERO_COLOR = Color.green;
    private final Color TEAM_ONE_COLOR = Color.blue;

    public ChessBoard(int height, int width) {
        super(height, width);
        setUpBoard();
        setUpJPanel();
        displayPanel();
        addButtonsToJPanel();
    }

    protected void setUpJPanel() {
        JPanel panel = getPanel();
        panel.setPreferredSize(new Dimension(850, 850));
        panel.setBackground(Color.BLACK);
    }

    protected void setUpBoard() {
        int teamNum;
        Color color, backGroundColor;
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                teamNum = i < 2 ? 0 : 1;
                color = i < 2 ? TEAM_ZERO_COLOR : TEAM_ONE_COLOR;
                backGroundColor = (i + j) % 2 == 0 ? Color.RED : Color.WHITE;
                setTile(i, j, new Tile(createPiece(i, j, teamNum, color), i, j, backGroundColor));
                getTile(i, j).setVisible(true);
                getTile(i, j).setPreferredSize(new Dimension(100, 100));

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
            return new Rook(team, color);
        } else if (column == 1 || column == 6) {
            return new Knight(team, color);
        } else if (column == 2 || column == 5) {
            return new Bishop(team, color);
        } else if (column == 3) {
            return new Queen(team, color);
        } else if (column == 4) {
            return new King(team, color);
        }
        return null;
    }

    protected void addButtonsToJPanel() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                getPanel().add(getTile(i, j));
            }
        }
    }

    private Piece newPawn(int team, Color color) {
        return new Pawn(team, color);
    }

    public void unHighlight() {
        for (int x = 0; x < getHeight(); x++) {
            for (int y = 0; y < getWidth(); y++) {
                getTile(x, y).unHighlight();
            }
        }
    }

}