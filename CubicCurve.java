import java.awt.*;
import java.awt.geom.CubicCurve2D;
import javax.swing.*;

public class CubicCurve extends JComponent {
    int x1;
    int y1;
    int ctrlX1;
    int ctrlY1;
    int ctrlX2;
    int ctrlY2;
    int x2;
    int y2;
    Color color;

    public CubicCurve(int x1, int y1, int ctrlX1, int ctrlY1, int ctrlX2, int ctrlY2, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.ctrlX1 = ctrlX1;
        this.ctrlY1 = ctrlY1;
        this.ctrlX2 = ctrlX2;
        this.ctrlY2 = ctrlY2;
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
        CubicCurve2D cubicCurve = new CubicCurve2D.Double();
        cubicCurve.setCurve(x1, y1, ctrlX1, ctrlY1, ctrlX2, ctrlY2, x2, y2);
        g2d.draw(cubicCurve);
    }
}