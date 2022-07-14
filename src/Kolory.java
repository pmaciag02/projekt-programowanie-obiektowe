import java.util.Random;
import java.io.Serializable;

public class Kolory implements Serializable{
    String[] kolory, kolory_klik;
    int random1, random2, random3;
    Random rand;

    public Kolory(){
        kolory = new String[]{"kolor/ramka.png","kolor/ciemnyz.png","kolor/niebieski.png","kolor/czerwony.png","kolor/zolty.png","kolor/rozowy.png","kolor/granatowy.png","kolor/zielony.png"};
        kolory_klik = new String[]{"kolor/ramka.png","kolor/ciemnyz2.png","kolor/niebieski2.png","kolor/czerwony2.png","kolor/zolty2.png","kolor/rozowy2.png","kolor/granatowy2.png","kolor/zielony2.png"};

        rand = new Random();

        random1 = rand.nextInt(7);
        random1++;
        random2 = rand.nextInt(7);
        random2++;
        random3 = rand.nextInt(7);
        random3++;
    }


    public void random_kolory(){
        random1 = rand.nextInt(7);
        random1++;
        random2 = rand.nextInt(7);
        random2++;
        random3 = rand.nextInt(7);
        random3++;
    }
}