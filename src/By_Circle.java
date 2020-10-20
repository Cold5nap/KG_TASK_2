import java.awt.*;

public class By_Circle implements PixelDrawer {

    private int x0;
    private int y0;
    private int radius;

    public By_Circle(int x0, int y0, int radius) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    public void draw(Graphics2D g) {
        int x = radius;
        int y = 0;
        int radiusError = 1 - x;
        float gradient = 0.5f;
        while (x >= y) {
            drawPx(x + x0, y + y0, g);
            drawPx(y + x0, x + y0, g);
            drawPx(-x + x0, y + y0, g);
            drawPx(-y + x0, x + y0, g);
            drawPx(-x + x0, -y + y0, g);
            drawPx(-y + x0, -x + y0, g);
            drawPx(x + x0, -y + y0, g);
            drawPx(y + x0, -x + y0, g);

            drawGradientPx(x + x0, y + y0+1,gradient, g);
            drawGradientPx(y + x0, x + y0+1,gradient, g);
            drawGradientPx(-x + x0, y + y0+1,gradient, g);
            drawGradientPx(-y + x0, x + y0+1,gradient, g);
            drawGradientPx(-x + x0, -y + y0+1,gradient, g);
            drawGradientPx(-y + x0, -x + y0+1,gradient, g);
            drawGradientPx(x + x0, -y + y0+1,gradient, g);
            drawGradientPx(y + x0, -x + y0+1,gradient, g);
            y++;
            if (radiusError < 0) {
                radiusError += 2 * y + 1;
            } else {
                x--;
                radiusError += 2 * (y - x + 1);
            }
        }
    }

    @Override
    public void draw(Graphics2D g, Color color) {
    }

    void drawPx(int x, int y, Graphics2D g) {
        g.fillRect(x, y, 1, 1);
    }
    //brightness value from 0 to 1
    private void drawGradientPx(int x, int y, float brightness, Graphics2D g) {
        g.setColor(new Color(Color.HSBtoRGB(0, 1, brightness)));
        g.fillRect(x, y, 1, 1);
    }

    //дробная часть
    private int fractionalPart(Float number) {
        String fractional = number.toString().split("\\.")[1];
        if (fractional.length() > 6) fractional = fractional.substring(0, 6);
        return Integer.parseInt(fractional);
    }

    //дробная часть
    private int fractionalPart(Double number) {
        String fractional = number.toString().split("\\.")[1];
        if (fractional.length() > 8) fractional = fractional.substring(0, 8);
        return Integer.parseInt(fractional);
    }

    //целая часть
    private int intPart(Float number) {
        String fractional = number.toString().split("\\.")[0];
        if (fractional.length() > 8) fractional = fractional.substring(0, 8);
        return Integer.parseInt(fractional);
    }

    //целая часть
    private int intPart(Double number) {
        String fractional = number.toString().split("\\.")[0];
        if (fractional.length() > 8) fractional = fractional.substring(0, 8);
        return Integer.parseInt(fractional);
    }
}


