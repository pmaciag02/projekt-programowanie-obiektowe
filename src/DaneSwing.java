import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.*;

public class DaneSwing extends JComponent{

    JPanel gui;
    JButton zap, czyt;
    JLabel wynik;
    Gra gra;

    public DaneSwing(Gra g){
        gra = g;
        gui = new JPanel();
        gui.setBorder(BorderFactory.createTitledBorder("Dane gry: "));
        gui.setLayout(new GridLayout(1, 3));

        wynik = new JLabel("Wynik: 0");
        gui.add(wynik);

        zap = new JButton("Zapisz");
        zap.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                zapisz(g);
            }
        });
        gui.add(zap);

        czyt = new JButton("Wczytaj");
        czyt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                czytaj();
            }
        });
        gui.add(czyt);

    }

    public void zapisz(Gra g){
        try{
            FileOutputStream f = new FileOutputStream("dane.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(g);
            o.close();
            System.out.println("Zapisano stan gry.");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public void czytaj(){
        Gra gg = null;
        
        try{
            FileInputStream f = new FileInputStream("dane.txt");
            ObjectInputStream o = new ObjectInputStream(f);

            gg = (Gra) o.readObject();
            gra.update(gg);
            o.close();
        }
        catch(Exception e){
            gg = new Gra();
            gra.update(gg);
            gra.start();
        }
        System.out.println("Wczytano stan gry.");
    }
}