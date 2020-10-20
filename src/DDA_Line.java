import java.awt.*;


public class DDA_Line implements PixelDrawer {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public DDA_Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public DDA_Line(Point p1, Point p2) {
        this.x1 = (int) p1.getX();
        this.y1 = (int) p1.getY();
        this.x2 = (int) p2.getX();
        this.y2 = (int) p2.getY();
    }

    @Override
    public void draw(Graphics2D g) {
        double x = x1;
        double y = y1;

        int dx = x2 - x1;
        int dy = y2 - y1;

        int abs_dx = Math.abs(dx);
        int abs_dy = Math.abs(dy);

        int steps = abs_dx > abs_dy ? abs_dx : abs_dy;
        double inc_x = dx / (double) steps;
        double inc_y = dy / (double) steps;

        for (int i = 0; i <= steps; i++) {
            g.fillRect((int) x, (int) y, 1, 1);
            x += inc_x;
            y += inc_y;
        }

    }

    @Override
    public void draw(Graphics2D g, Color color) {
        g.setColor(color);
        draw(g);
    }

}
