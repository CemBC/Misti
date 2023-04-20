import java.util.ArrayList;
public class Bot{
    protected ArrayList<String> hand;
    protected ArrayList<String> chest;


    public Bot() {
        hand = new ArrayList<String>();
        chest = new ArrayList<String>();
    }

    public void display(int p) {                   //Bot'un elini göstermesi için bir method
        System.out.print("Player" + p + ": {,");
        for(String a : hand) {
            System.out.print(a+",");
        }
        System.out.print("}");
    }

    public String play(int index) {             //Bot'un oynayacağı kartı döndüren bir method. Board\addToBoard() methodu için kullanılır
        return hand.get(index);
    }

    public void addToHand(String card) {
        hand.add(card);
    }

    public void addToChest(ArrayList<String> board, boolean condition) {             //Tahtadan zulaya kart aktarır
        if(condition) {
            for (String a : board) {
                chest.add(a);
            }
        }
    }

    public ArrayList<String> getHand() {
        return hand;
    }

}