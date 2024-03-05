package lasermaze.view.widgets;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {

    private JButton startButton = new JButton("Start \u26a0");

    public ControlPanel(Board board) {
        super(true);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.shootLaser();
            }
        });
    }
}
