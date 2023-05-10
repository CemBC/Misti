import java.util.ArrayList;
import java.util.Random;

public class Regular extends Player {
    public Regular(String name) {
        super(name);
    }

    public int chooseACard(Board boardd, int score) {//puana göre oynama eklenecek
        ArrayList<String> board = boardd.getBoard();

        if (score < 0) {       //Skor oyuna eklenince regular için kullanılacak kod
            for (String a : hand) {
                if (!a.substring(1).equals("J") && !a.substring(1).equals(board.get(board.size() - 1).substring(1))) {
                    return hand.indexOf(a);

                }
            }
            Random rd = new Random(System.currentTimeMillis());
            return rd.nextInt(0, hand.size());
        }

        for (String a : hand) {      //Eğer elinde alabilecek bir kart varsa onu atıyor
            try {
                if (a.substring(1).equals(board.get(board.size() - 1).substring(1))) {
                    return hand.indexOf(a);
                }
            } catch (IndexOutOfBoundsException e) {

            }
        }
        for (String a : hand) {                                              //eğer elinde alabilecek kart yok ama vale varsa ve tahtada 3 den fazla kart varsa
            if (a.substring(1).equals("J")) {                         //vale atar
                if (board.size() > 3) {
                    return hand.indexOf(a);
                }
            }
        }

        Random rd = new Random(System.currentTimeMillis());                   //hiçbiri olmazsa random atar
        return rd.nextInt(0, hand.size());
    }

    public String level() {
        return "Regular";
    }
}