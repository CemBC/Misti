import java.util.ArrayList;
public class Player{
    protected ArrayList<String> hand;
    protected ArrayList<String> chest;


    public Player() {
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

    public void addToHand(String a, String b , String c , String d) {
        hand.add(a);
        hand.add(b);
        hand.add(c);
        hand.add(d);
    }   

    public void addToChest(ArrayList<String> board, boolean condition) {             //Tahtadan zulaya kart aktarır
        if(condition) {
            for (String a : board) {
                chest.add(a);
            }
        }
    }

    public final void display(){
        int p = 0;
        System.out.println("-YOUR HAND-");
        System.out.print("[");
        for(String a : hand) {
            System.out.print(a+" ");
        }
        System.out.println("]");
        System.out.print(" ");
        for(String a : hand) {
            System.out.print(p+ "  ");
            p++;
        }
    }
    public ArrayList<String> getHand() {
        return hand;
    }

}