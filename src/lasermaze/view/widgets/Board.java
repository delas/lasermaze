package lasermaze.view.widgets;

import lasermaze.view.TyleType;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel {

    private Random rnd = new Random();
    private Tile[][] board;
    private int rows;
    private int cols;

    public Board(int rows, int cols) {
        this.board = new Tile[rows][cols];
        this.rows = rows;
        this.cols = cols;

        setLayout(new GridLayout(rows, cols, 4, 4));
        setBackground(Color.WHITE);

        setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.RED, 10),
                        BorderFactory.createLineBorder(Color.WHITE, 10)));

        setMinimumSize(new Dimension(cols * Tile.PIXEL_SIZE, rows * Tile.PIXEL_SIZE));
        setMaximumSize(getMinimumSize());
        setPreferredSize(getMinimumSize());

        loadBoard();
    }

    private void loadBoard() {
        // laser start
        board[rnd.nextInt(rows - 1)][0] = new Tile(TyleType.LASER);
        // target
        board[rnd.nextInt(rows - 1)][1 + rnd.nextInt(cols - 1)] = new Tile(TyleType.MIRROR);
        // add the rest
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                if (board[j][i] != null) {
                    add(board[j][i]);
                    continue;
                } else {
                    Tile t = new Tile(TyleType.EMPTY);
                    board[j][i] = t;
                    add(t);
                }
            }
        }
    }
}
