/* import java.util.ArrayList;
import java.util.Random;

public class Regular implements Bot {
    private ArrayList<String> hand;    //Şimdilik ele alma ve atma olaylarına kolaylık sağlasın diye ArrayList kullandım
                                        //duruma göre Array'e dönüştürülebilir
    private ArrayList<String> chest;
    public Regular() {
        hand = new ArrayList<String>();
        chest = new ArrayList<String>();
    }
    @Override
    public void display(int p ) {
        System.out.print("Player" + p + ": {,");
        for(String a : hand) {
            System.out.print(a+",");
        }
        System.out.print("}");
    }



    @Override
    public String play(int index) {
        return hand.get(index);
    }

    @Override
    public void addToHand(String card) {
        hand.add(card);
    }




    @Override
    public void addToCache(ArrayList<String> board, boolean condition) {
        if(condition) {
            for (String a : board) {
                chest.add(a);
            }
        }
    }
    public ArrayList<String> getHand() {
        return hand;
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
}  */

import java.util.ArrayList;
import java.util.Random;

public class Regular extends Bot{

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