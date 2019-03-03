package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    private String state;

    public void syncState(String s){
        this.state = s;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        try {
            if (state == "setup"){
                image = ImageIO.read(new File("img/startscreen.png"));
                g.drawImage(image, 0, 0, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
