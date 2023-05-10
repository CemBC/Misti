import java.util.ArrayList;
import java.util.Random;

public class Novice extends Player {

    public Novice(String name) {
        super(name);
    }

    public int chooseACard(Board board, int score) {                                        //random olarak kart atıyor
        Random rd = new Random(System.currentTimeMillis());
        return rd.nextInt(0, hand.size());
    }

    public String level() {
        return "Novice";
    }
}
