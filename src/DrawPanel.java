import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    private int x = 300;
    private int y = 10;
    private Point[] pts = {
            new Point(x, y),
            new Point(x + 200, y + 200),
            new Point(x + 100, y + 500),
            new Point(x - 100, y + 500),
            new Point(x - 200, y + 200),
    };

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        BresenhamArcCheck(g2d);
        //BresenhamEllipseCheck(g2d);
        //BresenhamCircleCheck(g2d);
        //ByDrawCheck(g2d);
        //DDADrawCheck(g2d);
        //BresenhamDrawCheck(g2d);
    }
    void BresenhamArcCheck(Graphics2D g){
        Bresenham_Arc arc = new Bresenham_Arc(500, 300, 200,100,Color.red,Color.green);
        arc.draw(g);
    }
    void BresenhamEllipseCheck(Graphics2D g){
        Bresenham_Ellipse ellipse = new Bresenham_Ellipse(500, 300, 200,100,Color.red,Color.green);
        ellipse.draw(g);
    }

    void BresenhamCircleCheck(Graphics2D g){
        Bresenham_Circle circle = new Bresenham_Circle(300, 300, 200);
        circle.draw(g);
    }

    void ByDrawCheck(Graphics2D g2d) {
        int np1 = 2, np2 = 3;
        for (int countPoint = 0; countPoint < pts.length; countPoint++) {
            if (np1 >= pts.length) {
                np1 = 0;
            }
            if (np2 >= pts.length) {
                np2 = 0;
            }
            By_Line line = new By_Line(pts[countPoint], pts[np1]);
            line.draw(g2d);
            line = new By_Line(pts[countPoint], pts[np2]);
            line.draw(g2d);
            np1++;
            np2++;
        }
    }

    void DDADrawCheck(Graphics2D g2d) {
        int np1 = 2, np2 = 3;
        for (int countPoint = 0; countPoint < pts.length; countPoint++) {
            if (np1 >= pts.length) {
                np1 = 0;
            }
            if (np2 >= pts.length) {
                np2 = 0;
            }
            DDA_Line line = new DDA_Line(pts[countPoint], pts[np1]);
            line.draw(g2d);
            line = new DDA_Line(pts[countPoint], pts[np2]);
            line.draw(g2d);
            np1++;
            np2++;
        }
    }


    void BresenhamDrawCheck(Graphics2D g2d) {
        int np1 = 2, np2 = 3;
        for (int countPoint = 0; countPoint < pts.length; countPoint++) {
            if (np1 >= pts.length) {
                np1 = 0;
            }
            if (np2 >= pts.length) {
                np2 = 0;
            }
            Bresenham_Line line = new Bresenham_Line(pts[countPoint], pts[np1]);
            line.draw(g2d);
            line = new Bresenham_Line(pts[countPoint], pts[np2]);
            line.draw(g2d);
            np1++;
            np2++;
        }
    }

}
