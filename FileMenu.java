import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class FileMenu extends JMenuBar {
    JMenu menu;
    JMenuItem saveItem;
    int counter;
    String pathName = System.getProperty("user.home") + "\\Desktop";


    public FileMenu(JFrame frame) {
        menu = new JMenu("File");
        menu.getAccessibleContext().setAccessibleDescription(
                "File Options");
        this.add(menu);

        saveItem = new JMenuItem("Save");
        saveItem.getAccessibleContext().setAccessibleDescription(
                "Saves the current drawing on screen.");
        saveItem.addActionListener(e -> {
            counter++;
            pathName = System.getProperty("user.home") + "\\Desktop" + "\\savedImage" + counter + ".png";
            var bufferedImage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D createGraphics = bufferedImage.createGraphics();
            frame.paintAll(createGraphics);
            try {
                if (ImageIO.write(bufferedImage, "png", new File(pathName)))
                {
                    System.out.println("File Saved");
                }
            } catch (IOException i) {
                i.printStackTrace();
            }
        });
        menu.add(saveItem);
    }
}