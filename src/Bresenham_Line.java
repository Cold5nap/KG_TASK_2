import java.awt.*;

public class Bresenham_Line implements PixelDrawer {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Bresenham_Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Bresenham_Line(Point p1, Point p2) {
            this.x1 = (int) p1.getX();
            this.y1 = (int) p1.getY();
            this.x2 = (int) p2.getX();
            this.y2 = (int) p2.getY();
    }


    @Override
    public void draw(Graphics2D g) {
        int dx_abs = Math.abs(x1 - x2);
        int dy_abs = Math.abs(y1 - y2);
        if (dx_abs > dy_abs) {
            System.out.println("hor");
            drawHorizontal(g);
        } else {
            System.out.println("vert");
            drawVertical(g);
        }
    }

    @Override
    public void draw(Graphics2D g, Color color) {
        g.setColor(color);
        draw(g);
    }

    public void drawHorizontal(Graphics2D g) {
        if(x2<x1){
            int temp= y2;
            y2=y1;
            y1=temp;
            temp=x2;
            x2=x1;
            x1=temp;
        }
        int dir_y = y2 - y1;
        if (dir_y > 0) dir_y = 1;
        else dir_y = -1;

        int dx_abs = Math.abs(x1 - x2);
        int dy_abs = Math.abs(y1 - y2);
        int error = 0;
        int dErr = (dy_abs + 1);
        int y = y1;

        for (int x = x1; x < x2; x++) {
            g.fillRect(x, y, 1, 1);
            error += dErr;
            if (error >= (dx_abs + 1)) {
                y += dir_y;
                error -= (dx_abs + 1);
            }
        }
    }

    public void drawVertical(Graphics2D g) {
        if(y2<y1){
            int temp= y2;
            y2=y1;
            y1=temp;
            temp=x2;
            x2=x1;
            x1=temp;
        }
        int dir_x = x2 - x1;
        if (dir_x > 0) dir_x = 1;
        else dir_x = -1;

        int dx_abs = Math.abs(x1 - x2);
        int dy_abs = Math.abs(y1 - y2);
        int error = 0;
        int dErr = (dx_abs + 1);
        int x = x1;

        for (int y = y1; y < y2; y++) {
            g.fillRect(x, y, 1, 1);
            error += dErr;
            if (error >= (dy_abs + 1)) {
                x += dir_x;
                error -= (dy_abs + 1);
            }
        }
    }
}
