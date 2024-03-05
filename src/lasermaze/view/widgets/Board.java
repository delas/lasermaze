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

    private int laserRow;
    private int laserCol;

    public Board(int rows, int cols) {
        this.board = new Tile[rows][cols];
        this.rows = rows;
        this.cols = cols;

        setLayout(new GridLayout(rows, cols));
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
        laserCol = 0;
        laserRow = rnd.nextInt(rows - 1);
        board[laserRow][laserCol] = new Tile(TyleType.LASER);
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

    public void shootLaser() {
        new Thread() {
            @Override
            public void run() {
                for (int col = laserCol + 1; col < cols; col++) {
                    board[laserRow][col].setLaserBeam(true);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) { }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { }
                for (int col = laserCol + 1; col < cols; col++) {
                    board[laserRow][col].setLaserBeam(false);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) { }
                }
            }
        }.start();
    }
}
