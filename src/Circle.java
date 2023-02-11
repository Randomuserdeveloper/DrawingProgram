import java.awt.*;
import javax.swing.*;

public class Circle extends JComponent {
    int x;
    int y;
    boolean fillModeActive;
    Color color;

    public Circle(int x, int y, boolean fillModeActive, Color color) {
        this.x = x;
        this.y = y;
        this.fillModeActive = fillModeActive;
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        if (fillModeActive) {
            g.fillOval(x, y, 25, 25);
        }
        g.drawOval(x, y, 25, 25);
    }
}