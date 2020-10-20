import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Task_2");
        frame.setSize(1000,600);
        frame.setLocation(200,0);
        DrawPanel drawPanel = new DrawPanel();
        frame.setBackground(Color.WHITE);
        frame.add(drawPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
