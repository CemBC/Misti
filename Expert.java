public class Expert implements  Bot{

    private String[] hand;

    public Expert() {
        hand = new String[52];
    }
    @Override
    public void display() {
        Bot.super.display();
    }

    @Override
    public void play(int index) {

    }

    @Override
    public int chooseACard() {
        return 0;
    }

    public String[] getHand() {
        return hand;
    }
}
