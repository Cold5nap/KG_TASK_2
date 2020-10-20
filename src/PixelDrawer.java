import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;


public interface PixelDrawer {

    public void draw(Graphics2D g);
    void draw(Graphics2D g, Color color);
}
