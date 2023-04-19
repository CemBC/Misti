public class Deck {
    private String[] deck = new String[52];
    private String[] suits =  {"♠","♣","♥","♦"};
    private String[] faces = {"A","2","3","4","5","6","7","8","9","T","J","Q","K"};


    public Deck() {
        int i = 0;
        for(String a : suits) {
            for(String b: faces) {
                deck[i++] = a+b;
            }
        }
    }
}
