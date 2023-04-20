import java.util.ArrayList;

public class Expert implements  Bot{

    private ArrayList<String> hand;  //Şimdilik ele alma ve atma olaylarına kolaylık sağlasın diye ArrayList kullandım
                                    //duruma göre Array'e dönüştürülebilir
    private ArrayList<String> chest;
    public Expert() {
        hand = new ArrayList<String>();
        chest = new ArrayList<String>();
    }
    @Override
    public void display(int p) {
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
                hand.add(a);
            }
        }
    }
    public ArrayList<String> getHand() {
        return hand;
    }
}
