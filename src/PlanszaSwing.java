import javax.swing.*;
import java.awt.*;



public class PlanszaSwing extends JComponent{

    PrzyciskSwing[][] przycisks;
    JLabel next1, next2, next3;
    JPanel gui1, gui2;

    public PlanszaSwing(Gra g)
    {
       gui1 = new JPanel();
        przycisks = new PrzyciskSwing[9][9];
        gui1.setBorder(BorderFactory.createTitledBorder("Plansza"));

        gui1.setLayout(new GridLayout(9, 9));

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                przycisks[i][j] = new PrzyciskSwing(i, j, g);
                gui1.add(przycisks[i][j].przycisks);
            }
        }

        gui2 = new JPanel();
        gui2.setBorder(BorderFactory.createTitledBorder("Następna tura"));
        gui2.setLayout(new GridLayout(1, 3));
        next1 = new JLabel(new ImageIcon("kolor/ramka.png"));
        gui2.add(next1);
        next2 = new JLabel(new ImageIcon("kolor/ramka.png"));
        gui2.add(next2);
        next3 = new JLabel(new ImageIcon("kolor/ramka.png"));
        gui2.add(next3);

    }


    void zmien(int a, int b, int random){
        przycisks[a][b].zmien(random);
    }


    void update_next(String k1, String k2, String k3){
        next1.setIcon(new ImageIcon(k1));
        next2.setIcon(new ImageIcon(k2));
        next3.setIcon(new ImageIcon(k3));
    }


}