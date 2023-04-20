import java.util.ArrayList;
/* import java.util.ArrayList;

public interface Bot {

    void display(int p);//Bot'un elini göstermesi için bir method
    void addToCache(ArrayList<String> board, boolean condition);           //Tahtadan zulaya kart aktarır
    String play(int index);                            //Bot'un oynayacağı kartı döndüren bir method. Board\addToBoard() methodu için kullanılır
    void addToHand(String card);
    //addToCache ve play methodları bütün botlar için aynı olacak ancak hand ve board değişkenleri burada tanımlı olmadığı için default olarak tanımlayamıyorum
    //çözümünü biliyorsan hallet
}
*/
public class Bot{
    protected ArrayList<String> hand;
    protected ArrayList<String> chest;


    public Bot() {
        hand = new ArrayList<String>();
        chest = new ArrayList<String>();
    }

    public void display(int p) {
        System.out.print("Player" + p + ": {,");
        for(String a : hand) {
            System.out.print(a+",");
        }
        System.out.print("}");
    }

    public String play(int index) {
        return hand.get(index);
    }

    public void addToHand(String card) {
        hand.add(card);
    }

    public void addToChest(ArrayList<String> board, boolean condition) {
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