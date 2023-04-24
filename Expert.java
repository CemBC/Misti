import java.util.ArrayList;

public class Expert extends Player{
    private ArrayList<String> mind;  //mind of the expert bot
    public Expert() {
        super();
        mind = new ArrayList<String>();
    }

   public int chooseACard(ArrayList<String> board) {
        return 0;   //burası doldurulacak
   }

   public void addToMind(ArrayList<String> board) {
        for(String a : board) {
            mind.add(a);
        }
   }
    public String level() {return "Expert";}
}