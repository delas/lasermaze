package lasermaze.view.widgets;

import lasermaze.view.TyleType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile extends JPanel {

    public static final int PIXEL_SIZE = 102;
    private TyleType type;
    private BufferedImage image;
    private boolean hasLaserBeam = false;

    public Tile(TyleType type) {
        super(true);

        this.type = type;
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(this.type.getPictureFile()));
        } catch (IOException e) {
            this.image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        }
        setMinimumSize(new Dimension(PIXEL_SIZE, PIXEL_SIZE));
        setMaximumSize(getMinimumSize());
        setPreferredSize(getMinimumSize());
    }

    public void setLaserBeam(boolean hasLaserBeam) {
        this.hasLaserBeam = hasLaserBeam;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, PIXEL_SIZE, PIXEL_SIZE);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(image, 0, 0, null);

        if (hasLaserBeam) {
            int verticalCenter = PIXEL_SIZE / 2 - 5;

            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(0, verticalCenter, PIXEL_SIZE, verticalCenter);
            g2d.setColor(new Color(255, 0, 0, 50));
            g2d.drawLine(0, verticalCenter - 3, PIXEL_SIZE, verticalCenter - 3);
            g2d.drawLine(0, verticalCenter + 3, PIXEL_SIZE, verticalCenter + 3);
        }
    }
}
