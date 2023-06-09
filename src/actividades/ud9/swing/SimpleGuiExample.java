package actividades.ud9.swing;

import javax.swing.*;
import java.awt.*;

public class SimpleGuiExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My fisrt GUI");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 300);
        frame.setLayout(new FlowLayout());
        JButton button1 = new JButton("Button 1"),
                button2 = new JButton("Button 2");
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        frame.setVisible(true);

    }
}
