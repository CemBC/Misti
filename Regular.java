import java.util.ArrayList;
import java.util.Random;

public class Regular extends Player{

    public Regular() {
        super();
    }

    public int chooseACard(ArrayList<String> board) {
        for(String a : hand) {
            if(a.substring(1).equals(board.get(board.size()-1).substring(1))){
                return hand.indexOf(a);
            }
        }
        for(String a : hand) {
            if(a.substring(1).equals("J")){
                if(board.size() > 3) {
                    return hand.indexOf(a);
                }
            }
        }

        Random rd = new Random(System.currentTimeMillis());
        return rd.nextInt(0,hand.size());
    }

}