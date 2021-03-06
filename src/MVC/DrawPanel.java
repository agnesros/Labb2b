package MVC;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Map;
import java.util.HashMap;
import Main.*;
// This panel represent the animated part of the view with the car images.

public class DrawPanel <A extends Vehicle> extends JPanel {

    BufferedImage volvoImage, saabImage, scaniaImage;
    Map<String, BufferedImage> imageMap = new HashMap<String, BufferedImage>();
    private Map<String, Point> pointMap=new HashMap<>();
    // TODO: Make this genereal for all cars

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.ORANGE);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            imageMap.put("Saab95", saabImage);
            imageMap.put("Volvo240", volvoImage);
            imageMap.put("Scania", scaniaImage);

        } catch (IOException ex) {

        }
    }

    void updateImages(Map<String, Point> pointMap) {
        this.pointMap = pointMap;
    }

    // This method is called each time the panel updates/refreshes/repaints itself

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Map.Entry<String, Point> e : this.pointMap.entrySet()) {
            for (Map.Entry<String, BufferedImage> f : imageMap.entrySet()) {
                if (e.getKey().contains(f.getKey()))
                  g.drawImage(f.getValue(),e.getValue().x,e.getValue().y,null);
            }
        }
    }
}
