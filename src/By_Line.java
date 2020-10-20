import java.awt.*;

public class By_Line implements PixelDrawer {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public By_Line(Point p1, Point p2) {
        this.x1 = (int) p1.getX();
        this.y1 = (int) p1.getY();
        this.x2 = (int) p2.getX();
        this.y2 = (int) p2.getY();
        if (x2 < x1) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
            temp = y1;
            y1 = y2;
            y2 = temp;
        }
    }


    @Override
    public void draw(Graphics2D g) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        if (Math.abs(dx) > Math.abs(dy)) {
            System.out.println("hor");
            drawHorizontal(g);
        } else {
            drawVertical(g);
            System.out.println("vert");
        }

    }

    @Override
    public void draw(Graphics2D g, Color color) {
        g.setColor(color);
        draw(g);
    }

    private void drawVertical(Graphics2D g) {
        if (y2 < y1) {
            int temp = y2;
            y2 = y1;
            y1 = temp;
            temp = x2;
            x2 = x1;
            x1 = temp;
        }
        int dir_x = x2 - x1;
        if (dir_x > 0) dir_x = 1;
        else dir_x = -1;

        int dx_abs = Math.abs(x1 - x2);
        int dy_abs = Math.abs(y1 - y2);
        int error = 0;
        int dErr = (dx_abs + 1);
        int x = x1;

        float increment = (float) (x2 - x1) / (float) (y2 - y1);
        float gradient = increment;
        for (int y = y1; y < y2; y++) {
            System.out.print(gradient + " ");
            drawGradientPixel(x, y + 1, Math.abs(fractionalPart(gradient)), g);
            drawGradientPixel(x, y, 1 - Math.abs(fractionalPart(gradient)), g);
            gradient += increment;
            error += dErr;
            if (error >= (dy_abs + 1)) {
                x += dir_x;
                error -= (dy_abs + 1);
            }
        }
    }

    private void drawHorizontal(Graphics2D g) {
        if (x2 < x1) {
            int temp = y2;
            y2 = y1;
            y1 = temp;
            temp = x2;
            x2 = x1;
            x1 = temp;
        }
        int dir_y = y2 - y1;
        if (dir_y > 0) dir_y = 1;
        else dir_y = -1;

        int dx_abs = Math.abs(x1 - x2);
        int dy_abs = Math.abs(y1 - y2);
        int error = 0;
        double dErr = (dy_abs + 1);
        int y = y1;

        float increment = (float) (y2 - y1) / (float) (x2 - x1);
        float gradient = increment;
        for (int x = x1; x < x2; x++) {
            drawGradientPixel(x, y + 1, Math.abs(fractionalPart(gradient)), g);
            drawGradientPixel(x, y, 1 - Math.abs(fractionalPart(gradient)), g);
            gradient += increment;
            error += dErr;
            if (error >= (dx_abs + 1)) {
                y += dir_y;
                error -= (dx_abs + 1);
            }
        }
    }


    //brightness value from 0 to 1
    private void drawGradientPixel(int x, int y, float brightness, Graphics2D g) {
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
