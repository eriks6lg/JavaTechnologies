package practicum3;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Homework {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String url = scanner.nextLine().trim();

            BufferedImage image = null;
            try {
                image = ImageIO.read(new URL(url));
            } catch (IOException e) {
                e.printStackTrace();
            }
            int prev = 0;
            for (int i = 0; i < image.getHeight(); i += image.getWidth() / 100) {
                for (int j = 0; j < image.getWidth(); j += image.getWidth() / 100) {
                    Color color = new Color(image.getRGB(j, i));
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    int now = red*green*blue;

//                    if((now-prev)>1000000)
//                        System.out.print("#");
//                    else {
//                        System.out.print(" ");
//                    }
//                    prev = now;


                    if (red == 255 && green == 255 && blue == 255) {
                        System.out.print(" ");
                    } else if (red > 150 || green > 150 || blue > 150) {
                        System.out.print("/");

                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println();
            }
        }

    }


}

