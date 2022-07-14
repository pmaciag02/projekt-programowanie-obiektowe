import javax.swing.*;
import java.awt.event.*;



public class PrzyciskSwing extends JComponent implements ActionListener{

    //Przycisk przycisk;
    Gra gra;
    JButton przycisks;
    int I, J, kolor;
    Icon icon;
    Kolory kolory;

    public PrzyciskSwing(int i, int j, Gra g)
    {
        gra = g;
        icon = new ImageIcon("kolor/ramka.png");
        przycisks = new JButton(icon);
        I = i;
        J = j;
        kolor = 0;
        kolory = new Kolory();
        przycisks.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        System.out.println(I + " " + J);

        if(gra.wybrane == 0){
            if(gra.plansza[I][J] == 0){
                System.out.println("Error!");
            }
            else{
                System.out.println("kolor: " + gra.plansza[I][J]);
                zmien2(gra.plansza[I][J]);

                gra.I = I; gra.J = J;

                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        gra.mozliwosci[i][j] = 0;
                    }
                }
                gra.ways(I, J);
            }
            gra.wybrane = gra.plansza[I][J];
        }
        else{
            if(gra.plansza[I][J] == 0 && gra.mozliwosci[I][J] != 0){
                gra.plansza[I][J] = gra.wybrane;
                zmien(gra.wybrane);
                gra.zeruj();



                gra.usun_klik((I * 9) + J);

                gra.dodaj(gra.I, gra.J, 0);


                if(gra.suma_wolne < 3){
                    System.out.print("Endgame. Suma pkt: " + gra.suma_pkt);
                    //endgame();
                    System.exit(0);
                }

                gra.dodaj_nowe(gra.kolory.random1);
                gra.dodaj_nowe(gra.kolory.random2);
                gra.dodaj_nowe(gra.kolory.random3);
                gra.kolory.random_kolory();
                gra.update_nast();
                gra.licz_pkt();
                System.out.println("Free: " + gra.suma_wolne);

                if(gra.suma_wolne < 3){
                    System.out.print("Endgame. Suma pkt: " + gra.suma_pkt);
                    //endgame();
                    System.exit(0);
                }
            }
            else{
                System.out.println("Error!");
                gra.wroc();
            }
            gra.wybrane = 0;
        }




        
    }

    void zmien(int kolor){
        icon = new ImageIcon(kolory.kolory[kolor]);
        przycisks.setIcon(icon);
    }

    void zmien2(int kolor){
        icon = new ImageIcon(kolory.kolory_klik[kolor]);
        przycisks.setIcon(icon);
    }

}