package colortransform;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

class Pixel extends Thread {
    BufferedImage image;
    int width;
    int height;

    public Pixel() throws IOException, InterruptedException {
        long startTime = System.nanoTime();

        image = loadImage();
        width = image.getWidth();
        height = image.getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int[] rgb = Hsb.getRGBColor(j,i,image);
                int red = rgb[0];
                int green = rgb[1];
                int blue = rgb[2];

                Hsb.doHsb(red,green,blue,j,i, image );

            }
        }
       saveImage();

        long stopTime = System.nanoTime();
        System.out.println((stopTime - startTime)+" Sekvencijalno ");
    }

    public static BufferedImage loadImage() throws IOException {
        File input = new File("C:\\Users\\Ilija\\ProstorBoja\\src\\colortransform\\nature.jpeg");
        return ImageIO.read(input);
    }

    public  void saveImage() throws IOException {
        File ouptut = new File("C:\\Users\\Ilija\\ProstorBoja\\src\\colortransform\\nature-1.png");
        ImageIO.write(image, "png", ouptut);
    }



}