import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class GUI {
    private static JFrame frame;
    private boolean circleToolActive;
    private boolean squareToolActive;
    private boolean lineToolActive;
    private boolean quadCurveToolActive;
    private boolean cubicCurveToolActive;
    private boolean fillModeActive;
    private boolean freeDrawActive;
    private int buttonClickedTimes;
    private Color color;
    private final List<Point> pointList = new ArrayList<>();

    public GUI() {
        frame = new JFrame("Drawing Program");
        var panel = new JPanel();
        var squareButton = new JButton("Square Tool");
        var circleButton = new JButton("Circle Tool");
        var lineButton = new JButton("Line Tool");
        var quadButton = new JButton("Quadratic Curve Tool");
        var cubicButton = new JButton("Cubic Curve Tool");
        var eraseButton = new JButton("Erase");
        var fillButton = new JButton("Fill Mode On/Off");
        var colorButton = new JButton("Set Color");
        var freeDrawButton = new JButton("Free Draw");
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(1000, 50));
        frame.add(panel, BorderLayout.NORTH);
        panel.add(circleButton);
        panel.add(squareButton);
        panel.add(lineButton);
        panel.add(quadButton);
        panel.add(cubicButton);
        panel.add(freeDrawButton);
        panel.add(fillButton);
        panel.add(colorButton);
        panel.add(eraseButton);

        eraseButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.add(panel, BorderLayout.NORTH);
            panel.add(circleButton);
            panel.add(squareButton);
            panel.add(lineButton);
            panel.add(quadButton);
            panel.add(cubicButton);
            panel.add(freeDrawButton);
            panel.add(fillButton);
            panel.add(colorButton);
            panel.add(eraseButton);
            frame.revalidate();
            frame.repaint();
            System.out.println("Everything Erased!");
        });

        circleButton.addActionListener(e -> {
            circleToolActive = true;
            squareToolActive = false;
            lineToolActive = false;
            quadCurveToolActive = false;
            cubicCurveToolActive = false;
            freeDrawActive = false;
            System.out.println("Circle Tool Is Active!");
        });

        squareButton.addActionListener(e -> {
            circleToolActive = false;
            squareToolActive = true;
            lineToolActive = false;
            quadCurveToolActive = false;
            cubicCurveToolActive = false;
            freeDrawActive = false;
            System.out.println("Square Tool Is Active!");
        });

        lineButton.addActionListener(e -> {
            circleToolActive = false;
            squareToolActive = false;
            lineToolActive = true;
            quadCurveToolActive = false;
            cubicCurveToolActive = false;
            freeDrawActive = false;
            System.out.println("Line Tool Is Active!");
        });

        quadButton.addActionListener(e -> {
            circleToolActive = false;
            squareToolActive = false;
            lineToolActive = false;
            quadCurveToolActive = true;
            cubicCurveToolActive = false;
            freeDrawActive = false;
            System.out.println("Quadratic Curve Tool Is Active!");
        });

        cubicButton.addActionListener(e -> {
            circleToolActive = false;
            squareToolActive = false;
            lineToolActive = false;
            quadCurveToolActive = false;
            cubicCurveToolActive = true;
            freeDrawActive = false;
            System.out.println("Cubic Curve Tool Is Active!");
        });

        freeDrawButton.addActionListener(e -> {
            circleToolActive = false;
            squareToolActive = false;
            lineToolActive = false;
            quadCurveToolActive = false;
            cubicCurveToolActive = false;
            freeDrawActive = true;
            System.out.println("Free Draw Tool Is Active!");
        });

        fillButton.addActionListener(e -> {
            buttonClickedTimes++;
            if ((buttonClickedTimes & 1) == 0 ) {
                // Even
                fillModeActive = false;
                System.out.println("Fill mode off!");
            } else {
                // Odd
                fillModeActive = true;
                System.out.println("Fill mode on!");
            }
        });

        colorButton.addActionListener(e -> {
            color = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
        });

        class MousePressListener implements MouseListener, MouseMotionListener {
            public void mousePressed(MouseEvent event) {
            }

            public void mouseReleased(MouseEvent event) {
                int x = event.getXOnScreen();
                int y = event.getYOnScreen();
                var point = new Point(x, y);
                pointList.add(point);

                if (circleToolActive) {
                    var circle = new Circle((int) pointList.get(0).getX() - 10, (int) pointList.get(0).getY() - 100, fillModeActive, color);
                    frame.add(circle);
                    frame.revalidate();
                    frame.repaint();
                    System.out.println("Circle Painted!");
                    pointList.removeAll(pointList);

                } else if (squareToolActive) {
                    var square = new Square((int) pointList.get(0).getX() - 10, (int) pointList.get(0).getY() - 100, fillModeActive, color);
                    frame.add(square);
                    frame.revalidate();
                    frame.repaint();
                    System.out.println("Square Painted!");
                    pointList.removeAll(pointList);

                } else if (lineToolActive) {
                    if (pointList.toArray().length >= 2) {
                        var line = new Line((int) pointList.get(0).getX(), (int) pointList.get(0).getY() - 95, (int) pointList.get(1).getX(), (int) pointList.get(1).getY() - 95, color);
                        frame.add(line);
                        frame.revalidate();
                        frame.repaint();
                        System.out.println("Line Painted!");
                        pointList.removeAll(pointList);
                    }
                }

                else if (quadCurveToolActive) {
                    if (pointList.toArray().length >= 3) {
                        var quad = new QuadraticCurve((int) pointList.get(0).getX(), (int) pointList.get(0).getY() - 95, (int) pointList.get(1).getX(), (int) pointList.get(1).getY() - 95, (int) pointList.get(2).getX(), (int) pointList.get(2).getY() - 95, color);
                        frame.add(quad);
                        frame.revalidate();
                        frame.repaint();
                        System.out.println("Quadratic Curve Painted!");
                        pointList.removeAll(pointList);
                    }
                }

                else if (cubicCurveToolActive) {
                    if (pointList.toArray().length >= 4) {
                        var cubic = new CubicCurve((int) pointList.get(0).getX(), (int) pointList.get(0).getY() - 95, (int) pointList.get(1).getX(), (int) pointList.get(1).getY() - 95, (int) pointList.get(2).getX(), (int) pointList.get(2).getY() - 95, (int) pointList.get(3).getX(), (int) pointList.get(3).getY() - 95, color);
                        frame.add(cubic);
                        frame.revalidate();
                        frame.repaint();
                        System.out.println("Cubic Curve Painted!");
                        pointList.removeAll(pointList);
                    }
                }
            }

            public void mouseClicked(MouseEvent event) {
            }

            public void mouseEntered(MouseEvent event) {
            }

            public void mouseExited(MouseEvent event) {
            }

            @Override
    public void mouseDragged(MouseEvent e) {
        if (e.isMetaDown() && freeDrawActive) {
            var circle = new Circle((int) pointList.get(0).getX() - 10, (int) pointList.get(0).getY() - 100, fillModeActive, color);
            frame.add(circle);
        }

        frame.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

        }

        MousePressListener mouseListener = new MousePressListener();
        frame.addMouseListener(mouseListener);
    }
}