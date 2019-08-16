package colortransform;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Paralelno extends Thread {
    BufferedImage image;
    int width;
    int height;

    public Paralelno() throws IOException, InterruptedException {

        image = Pixel.loadImage();
        width = image.getWidth();
        height = image.getHeight();

        long startTime = System.nanoTime();

        t1.start();
        t4.join();
        saveImage();

        long stopTime = System.nanoTime();
        System.out.println((stopTime - startTime)+" Paralelno ");
    }


    public  void saveImage() throws IOException {
        File ouptut = new File("C:\\Users\\Ilija\\ProstorBoja\\src\\colortransform\\nature-paralelno.png");
        ImageIO.write(image, "png", ouptut);
    }


    Thread t1 = new Thread() {
        public void run() { t2.start();
            for (int i = 0; i < height / 2; i++) {
                for (int j = 0; j < width/2 ; j++) {
                    int[] rgb = Hsb.getRGBColor(j, i, image);
                    Hsb.doHsb(rgb[0], rgb[1], rgb[2], j, i, image);
                }
            }
        }
    };

    Thread t2 = new Thread() {
        public void run() { t3.start();
            for (int i = 0; i < height/2; i++) {
                for (int j = width/2; j < width; j++) {
                    int[] rgb = Hsb.getRGBColor(j, i, image);
                    Hsb.doHsb(rgb[0], rgb[1], rgb[2], j, i, image);
                }
            }
        }
    };

    Thread t3 = new Thread() {
        public void run() { t4.start();
            for (int i = height / 2; i < height; i++) {
                for (int j = 0; j < width / 2; j++) {
                    int[] rgb = Hsb.getRGBColor(j, i, image);
                    Hsb.doHsb(rgb[0], rgb[1], rgb[2], j, i, image);
                }
            }
        }
    };

    Thread t4 = new Thread() {
        public void run() {
            for (int i = height / 2; i < height; i++) {
                for (int j = width/2; j < width; j++) {
                    int[] rgb = Hsb.getRGBColor(j, i, image);
                    Hsb.doHsb(rgb[0], rgb[1], rgb[2], j, i, image);
                }
            }
        }
    };


}

