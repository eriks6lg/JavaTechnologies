package practicum1;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.util.Scanner;

public class HomeworkRightWay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_BYTE_BINARY);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 100, 100);
        graphics.setColor(Color.BLACK);
        graphics.drawString(scanner.nextLine().toUpperCase(), 0, 100);

        image.getGraphics().setColor(Color.red);
        for (int y = 0; y < image.getWidth(); y++) {
            for (int x=0; x<image.getHeight(); x++) {
                int rgb = image.getRGB(x, y);
                image.getGraphics().fillRect(x, y, 1, 1);
                if (rgb == -1)
                    System.out.print(" ");
                else
                    System.out.print("#");


            }
            System.out.println();
        }

    }

}
