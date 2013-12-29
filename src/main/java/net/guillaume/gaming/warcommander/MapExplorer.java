package net.guillaume.gaming.warcommander;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MapExplorer {


    private Robot robot;
    private Rectangle OIL = new Rectangle(16, 698, 235, 30);
    private Rectangle OWNER = new Rectangle(400, 495, 350, 50);
    int i;


    public MapExplorer() {

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void background() {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("0 - Oil");
        int read = keyboard.nextInt();

        switch (read) {
            case 0:
                scanForOil();
                break;
        }

    }

    private void pause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void scanForOil() {

        for (i = 0; i < 50; i++) {
            nextOil();
            pause();
            takePicture(OWNER);
        }

    }

    private void nextOil() {
        robot.mouseMove(200, 710);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void scanForMetal() {
        throw new UnsupportedOperationException();
    }

    public void takePicture(Rectangle rectangle) {
        BufferedImage image = robot.createScreenCapture(rectangle);
        try {
            ImageIO.write(image, "png", new File("oil-" + i + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Snapshot !!");
    }


}
