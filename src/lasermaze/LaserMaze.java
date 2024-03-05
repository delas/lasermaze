package lasermaze;

import lasermaze.view.widgets.Board;

import javax.swing.*;
import java.awt.*;

public class LaserMaze {
    public static void main(String[] args) {

        int initialRow = 7;
        int initialColumn = 7;

        Board board = new Board(initialRow, initialColumn);

        JFrame f = new JFrame("Laser Maze Demo - v.0.1");
        f.setLayout(new FlowLayout(FlowLayout.CENTER));
        f.add(board);
        f.setSize(800, 800);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
