import java.awt.*;

public class Bresenham_Circle implements PixelDrawer{
    private int x0;
    private int y0;
    private int radius;

    public Bresenham_Circle(int x0, int y0, int radius) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;
    }

    public void draw(Graphics2D g) {
        int x = radius;
        int y = 0;
        int radiusError = 1 - x;
        while (x >= y)
        {
            drawPx(x + x0, y + y0,g);
            drawPx(y + x0, x + y0,g);
            drawPx(-x + x0, y + y0,g);
            drawPx(-y + x0, x + y0,g);
            drawPx(-x + x0, -y + y0,g);
            drawPx(-y + x0, -x + y0,g);
            drawPx(x + x0, -y + y0,g);
            drawPx(y + x0, -x + y0,g);
            y++;
            if (radiusError < 0)
            {
                radiusError += 2 * y + 1;
            }
            else
            {
                x--;
                radiusError += 2 * (y - x + 1);
            }
        }
    }

    @Override
    public void draw(Graphics2D g, Color color) {

    }

    void drawPx(int x,int y,Graphics2D g){
        g.fillRect(x,y,1,1);
    }
}
