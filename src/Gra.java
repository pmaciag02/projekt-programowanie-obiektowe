import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.Serializable;


public class Gra implements Serializable{
    int[][] plansza, mozliwosci;
    int suma_pkt, suma_wolne, wybrane, I, J;

    PlanszaSwing planszas;

    List<Integer> wolne;

    Kolory kolory;

    DaneSwing dane;

    public Gra(){
        planszas = new PlanszaSwing(this);
        suma_pkt = 0;
        plansza = new int[9][9];
        mozliwosci = new int[9][9];
        wolne = new ArrayList<>();
        suma_wolne = 81;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                wolne.add((i*9) + j);
                plansza[i][j] = 0;
                mozliwosci[i][j] = 0;
            }
        }
        kolory = new Kolory();
        wybrane = 0;
        I = 0; J = 0;
        dane = new DaneSwing(this);
    }



    public void start(){
        dodaj_nowe(kolory.random1);
        dodaj_nowe(kolory.random2);
        dodaj_nowe(kolory.random3);
        kolory.random_kolory();
        update_nast();
    }



    void ways(int a, int b){
        mozliwosci[a][b]=1;
        
        if(a>0 && plansza[a-1][b]==0 && mozliwosci[a-1][b]==0)
        {
            ways(a-1,b);
        }
        if(a<8 && plansza[a+1][b]==0 && mozliwosci[a+1][b]==0)
        {
            ways(a+1,b);
        }
        if(b>0 && plansza[a][b-1]==0 && mozliwosci[a][b-1]==0)
        {
            ways(a,b-1);
        }
        if(b<8 && plansza[a][b+1]==0 && mozliwosci[a][b+1]==0)
        {
            ways(a,b+1);
        }
    }



    void licz_pkt(){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }

        Boolean koniec = false;
        int k, kolor;

        for(int i=0; i<9; i++){
            if(koniec) break;
            for(int j=0; j<9; j++){
                if(plansza[i][j] > 0){
                    int licznik = 1;
                    if(i >= 0 && i<=4){
                        for(int m=1; m<5; m++){
                            if(plansza[i+m][j] == plansza[i][j]){
                                licznik++;
                            }
                        }
                        if(licznik == 5){
                            k = 0;
                            kolor = plansza[i][j];

                            while(i+k < 9 && plansza[i+k][j] == kolor){
                                plansza[i+k][j] = 0;
                                planszas.przycisks[i+k][j].zmien(0);
                                wolne.add(((i+k)*9)+j);
                                suma_wolne++;
                                k++;
                                suma_pkt++;
                            }
                            koniec = true;
                            break;
                        }
                    }
                    licznik = 1;
                    if(i >= 4 && i<=8){
                        for(int m=1; m<5; m++){
                            if(plansza[i-m][j] == plansza[i][j]){
                                licznik++;
                            }
                        }
                        if(licznik == 5){
                            k = 0;
                            kolor = plansza[i][j];

                            while(i+k < 9 && plansza[i-k][j] == kolor){
                                plansza[i-k][j] = 0;
                                planszas.przycisks[i-k][j].zmien(0);
                                wolne.add(((i-k)*9)+j);
                                suma_wolne++;
                                k++;
                                suma_pkt++;
                            }
                            koniec = true;
                            break;
                        }
                    }
                    licznik = 1;
                    if(j >= 0 && j<=4){
                        for(int m=1; m<5; m++){
                            if(plansza[i][j+m] == plansza[i][j]){
                                licznik++;
                            }
                        }
                        if(licznik == 5){
                            k = 0;
                            kolor = plansza[i][j];

                            while(j+k < 9 && plansza[i][j+k] == kolor){
                                plansza[i][j+k] = 0;
                                planszas.przycisks[i][j+k].zmien(0);
                                wolne.add((i*9)+j+k);
                                suma_wolne++;
                                k++;
                                suma_pkt++;
                            }
                            koniec = true;
                            break;
                        }
                    }
                    licznik = 1;
                    if(j >= 4 && j<=8){
                        for(int m=1; m<5; m++){
                            if(plansza[i][j-m] == plansza[i][j]){
                                licznik++;
                            }
                        }
                        if(licznik == 5){
                            k = 0;
                            kolor = plansza[i][j];

                            while(j-k < 9 && plansza[i][j-k] == kolor){
                                plansza[i][j-k] = 0;
                                planszas.przycisks[i][j-k].zmien(0);
                                wolne.add((i*9)+j-k);
                                suma_wolne++;
                                k++;
                                suma_pkt++;
                            }
                            koniec = true;
                            break;
                        }
                    }
                    licznik = 1;
                    if(i <=4 && j<=4){
                        for(int m=1; m<5; m++){
                            if(plansza[i+m][j+m] == plansza[i][j]){
                                licznik++;
                            }
                        }
                        if(licznik == 5){
                            k = 0;
                            kolor = plansza[i][j];

                            while(i+k < 9 && plansza[i+k][j+k] == kolor){
                                plansza[i+k][j+k] = 0;
                                planszas.przycisks[i+k][j+k].zmien(0);
                                wolne.add(((i+k)*9)+j+k);
                                suma_wolne++;
                                k++;
                                suma_pkt++;
                            }
                            koniec = true;
                            break;
                        }
                    }
                    licznik = 1;
                    if(i <=4 && j>=4){
                        for(int m=1; m<5; m++){
                            if(plansza[i+m][j-m] == plansza[i][j]){
                                licznik++;
                            }
                        }
                        if(licznik == 5){
                            k = 0;
                            kolor = plansza[i][j];

                            while(i+k < 9 && plansza[i+k][j-k] == kolor){
                                plansza[i+k][j-k] = 0;
                                planszas.przycisks[i+k][j-k].zmien(0);
                                wolne.add(((i+k)*9)+j-k);
                                suma_wolne++;
                                k++;
                                suma_pkt++;
                            }
                            koniec = true;
                            break;
                        }
                    }
                    licznik = 1;
                    if(i >= 4 && j<=4){
                        for(int m=1; m<5; m++){
                            if(plansza[i-m][j+m] == plansza[i][j]){
                                licznik++;
                            }
                        }
                        if(licznik == 5){
                            k = 0;
                            kolor = plansza[i][j];

                            while(i+k < 9 && plansza[i-k][j+k] == kolor){
                                plansza[i-k][j+k] = 0;
                                planszas.przycisks[i-k][j+k].zmien(0);
                                wolne.add(((i-k)*9)+j+k);
                                suma_wolne++;
                                k++;
                                suma_pkt++;
                            }
                            koniec = true;
                            break;
                        }
                    }
                    licznik = 1;
                    if(i >= 4 && j>=4){
                        for(int m=1; m<5; m++){
                            if(plansza[i-m][j-m] == plansza[i][j]){
                                licznik++;
                            }
                        }
                        if(licznik == 5){
                            k = 0;
                            kolor = plansza[i][j];

                            while(i+k < 9 && plansza[i-k][j-k] == kolor){
                                plansza[i-k][j-k] = 0;
                                planszas.przycisks[i-k][j-k].zmien(0);
                                wolne.add(((i-k)*9)+j-k);
                                suma_wolne++;
                                k++;
                                suma_pkt++;
                            }
                            koniec = true;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("suma pkt: " + suma_pkt);
        dane.wynik.setText("wynik: " + suma_pkt);

    }


    int usun_losowe(){
        Random rand = new Random();
        int random_index = rand.nextInt(wolne.size());

        int random_int = wolne.get(random_index);
        wolne.remove(random_index);

        suma_wolne--;
        return random_int;
    }


    void dodaj_nowe(int random){
        int x = usun_losowe();
        int a = x / 9;
        int b = x % 9;

        System.out.println("Random: " + a + " " + b);
        plansza[a][b] = random;

        planszas.zmien(a, b, random);
    }

    void dodaj(int i, int j, int x){
        //planszas.zmien(i, j, 0);
        wolne.add((i * 9) + j);
        suma_wolne++;
    }



    void usun_klik(int x){
        int i = 0;
        while(i < suma_wolne && wolne.get(i) != x){
            i++;
        }

        if(i >= suma_wolne || wolne.get(i) != x){
            System.out.println("Error!");
        }
        else{
            wolne.remove(i);
            suma_wolne--;  
        }
    }


    void zeruj(){
        plansza[I][J] = 0;
        planszas.przycisks[I][J].zmien(0);
    }

    void wroc(){
        planszas.przycisks[I][J].zmien(plansza[I][J]);
        wybrane = 0;
    }

    public void update(Gra g){
        plansza = g.plansza;
        mozliwosci = g.mozliwosci;
        suma_pkt = g.suma_pkt;
        suma_wolne = g.suma_wolne;
        wybrane = g.wybrane;
        I = g.I;
        J = g.J;
        wolne = g.wolne;
        kolory = g.kolory;
        dane.wynik.setText("wynik: " + suma_pkt);

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                planszas.przycisks[i][j].zmien(plansza[i][j]);
            }
        }

        update_nast();
    }


    void update_nast(){
        planszas.update_next(kolory.kolory[kolory.random1], kolory.kolory[kolory.random2], kolory.kolory[kolory.random3]);
    }
}