package colortransform;


public class Cmyk {

    public  static double[] rgbToCmyk(double red, double green, double blue) {
        double black = Math.min(Math.min(1.0 - red, 1.0 - green), 1.0 - blue);

        if (black!=1.0) {
            double cyan    = (1.0-red-black)/(1.0-black);
            double magenta = (1.0-green-black)/(1.0-black);
            double yellow  = (1.0-blue-black)/(1.0-black);
            return new double[] {cyan,magenta,yellow,black};
        } else {
            double cyan = 1.0 - red;
            double magenta = 1.0 - green;
            double yellow = 1.0 - blue;
            return new double[] {cyan,magenta,yellow,black};

        }
    }

    public static void doCmyk(int red, int green, int blue){
        double[] cmyk= rgbToCmyk(red, green, blue);
        float cyan = (float)cmyk[0]*100;
        float magenta = (float)cmyk[1]*100;
        float yellow = (float)cmyk[2]*100;
        float black= cyan+magenta+yellow;

        int cyanl= (int) cyan;
        int magental=(int)magenta;
        int yellowl=(int)yellow;
        int blackl= (int)black;


        System.out.println("R: "+red+"  G: "+green+"  B: "+blue);
        System.out.println("C: "+cyanl+"  M: "+magental+"  Y: "+yellowl+"  K: "+blackl);
    }
}
