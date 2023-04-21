import java.util.Random;
public class Novice extends Player{

    public Novice() {
        super();
    }

    public int chooseACard() {                                        //random olarak kart atıyor
        Random rd = new Random(System.currentTimeMillis());
        return rd.nextInt(0,hand.size());
    }

}
