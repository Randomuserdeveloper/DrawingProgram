import java.awt.*;
import java.awt.geom.QuadCurve2D;
import javax.swing.*;

public class QuadraticCurve extends JComponent {
    int x1;
    int y1;
    int ctrlX1;
    int ctrlY1;
    int x2;
    int y2;
    Color color;

    public QuadraticCurve(int x1, int y1, int ctrlX1, int ctrlY1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.ctrlX1 = ctrlX1;
        this.ctrlY1 = ctrlY1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        QuadCurve2D quadCurve = new QuadCurve2D.Double();
        quadCurve.setCurve(x1, y1, ctrlX1, ctrlY1, x2, y2);
        g2d.draw(quadCurve);
    }
}