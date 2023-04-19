import java.util.ArrayList;

public class Novice implements Bot{

    private ArrayList<String> hand;   //Şimdilik ele alma ve atma olaylarına kolaylık sağlasın diye ArrayList kullandım
                                       //duruma göre Array'e dönüştürülebilir
    public Novice() {
        hand = new ArrayList<String>();
    }
    @Override
    public void display() {
        Bot.super.display();
    }

    @Override
    public String play(int index) {
        return "";
    }

    @Override
    public int chooseACard() {
        return 0;
    }

    public ArrayList<String> getHand() {
        return hand;
    }
}
