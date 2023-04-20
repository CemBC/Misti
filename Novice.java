import java.util.Random;
public class Novice extends Bot{

    public Novice() {
        super();
    }

    public int chooseACard() {
        Random rd = new Random(System.currentTimeMillis());
        return rd.nextInt(0,hand.size());
    }

}
