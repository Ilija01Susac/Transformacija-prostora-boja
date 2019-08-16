package colortransform;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hsb {

    public static int[] getRGBColor(int j, int i, BufferedImage image){
        int[] rgb = new int[3];
        Color c = new Color(image.getRGB(j, i));
        int red = c.getRed();
        int green = c.getGreen();
        int blue = c.getBlue();
        int alpha = c.getAlpha();
        rgb = new int[]{red, green, blue, alpha};

        return rgb;
    }


    public static float[] rgbToHsb(int r, int g, int b){
        int R = r;
        int G = g;
        int B = b;

        float[] hsb = new float[3];
        Color.RGBtoHSB(r,g,b,hsb);
        return hsb;
    }

    public  static void doHsb(int red, int green, int blue, int j, int i, BufferedImage image){
        float[] hsb = rgbToHsb(red, green, blue );
        Color newColor = new Color(hsb[0],hsb[1],hsb[2]);
        image.setRGB(j,i, newColor.getRGB());
    }
}
