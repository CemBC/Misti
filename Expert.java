import java.util.ArrayList;
import java.util.Collections;

public class Expert extends Player {
    protected String expertiseLevel = "E";
    private ArrayList<String> mind;  //mind of the expert bot

    public Expert(String name) {
        super(name );
        mind = new ArrayList<String>();
    }

    public int chooseACard(Board boardd/*,int score*/) {
        ArrayList<String> board = boardd.getBoard();
       /*if(score <=  0 ) {       //Skor oyuna eklenince regular için kullanılacak kod
           for(String a : hand) {
               if(!a.substring(1).equals("J")  &&  !a.substring(1).equals(board.get(board.size() - 1).substring(1))) {
                   return hand.indexOf(a);

               }
           }
           String temp = "";                    //Başkası eksi dolu tahtayı alsın diye en az atılmış kartı atacak
           int min = Integer.MAX_VALUE;
           for(String a : hand) {
               int c = Collections.frequency(mind,a.substring(1));
               if(c < min) {
                   if (!a.substring(1).equals("J")){

                       min = c;
                       temp = a;
                   }


               }
           }
           return hand.indexOf(temp);
       } */
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

        String temp = "";
        int max = Integer.MIN_VALUE;
        for (String a : hand) {
            int c = Collections.frequency(mind, a.substring(1));
            if (c > max) {
                max = c;
                temp = a;
            }
        }
        return hand.indexOf(temp);
    }

    public void addToMind(Board boardd,boolean flag) {
        if(flag) {
            ArrayList<String> board = boardd.getBoard();
            String a = board.get(board.size() - 1);
            mind.add(a.substring(1));
        }else{
            ArrayList<String> board = boardd.getBoard();
            for(int i = 0 ; i < board.size() ; i++) {
                mind.add(board.get(i));
            }
        }
    }


    public String level() {
        return "Expert";
    }
}