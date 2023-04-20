import java.util.ArrayList;

public class Expert extends Bot{
    private ArrayList<String> mind;  //mind of the expert bot
    public Expert() {
        super();
        mind = new ArrayList<String>();
    }

   public int chooseACard(ArrayList<String> board) {
        return 0;
   }
}