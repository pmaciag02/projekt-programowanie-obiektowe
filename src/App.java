import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args){
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Gra gra = new Gra();

        gra.start();


        frame.add(gra.planszas.gui1, BorderLayout.NORTH);
        frame.add(gra.planszas.gui2, BorderLayout.CENTER);
        frame.add(gra.dane.gui, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }
}
