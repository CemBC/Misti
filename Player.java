import java.util.ArrayList;

public class Player {

    protected String name;
    protected ArrayList<String> hand;
    protected ArrayList<String> chest;

    protected int score;


    public Player(String name) {
        this.name = name;
        score = 0;
        hand = new ArrayList<String>();
        chest = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public String display(int p) { //Bot'un elini göstermesi için bir method
        String temp = "";
        temp += name + ": {,";
        for (String a : hand) {
            temp += a + ",";
        }
        temp += "}\t";
        return temp;
    }

    public String play(int index) { //Bot'un oynayacağı kartı döndüren bir method. Board\addToBoard() methodu için kullanılır
        String temp = hand.get(index);
        hand.remove(index);
        return temp;
    }

    public void addToHand(String a, String b, String c, String d) {           //Her seferinde bir ele 4 kart ekleneceği için 4 lü  ekleme methodu
        hand.add(a);
        hand.add(b);
        hand.add(c);
        hand.add(d);
    }

    public void addToChest(ArrayList<String> board, boolean condition) {             //Tahtadan zulaya kart aktarır
        if (condition) {
            for (String a : board) {
                chest.add(a);
            }
        }
    }

    public final void display() {       //oyuncunun elini göstermesi için ayarlanmış subclasslara aktarılmasın diye final anahtar kelimesiyle yazılmış method
        int p = 0;
        System.out.println("-YOUR HAND-");
        System.out.print("[");
        for (String a : hand) {
            System.out.print(a + " ");
        }
        System.out.println("]");
        System.out.print(" ");
        for (String a : hand) {
            System.out.print(p + "  ");
            p++;
        }
    }

    public ArrayList<String> getHand() {
        return hand;
    }

    public String level() {
        return "player";
    }

    public int chooseACard(Board board, int score) {
        return 0;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public void addToMind(Board board, boolean flag) {
    }
}