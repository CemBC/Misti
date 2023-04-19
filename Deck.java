import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

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

    public void display() {
        System.out.println("-THE DECK-");
        System.out.print("[");
        for(String a : deck) {
                System.out.print(a + ",");
        }
        System.out.print("]");
        System.out.println();
    }

    public void shuffle() {
        Collections.shuffle(Arrays.asList(deck));
    }
    public void cut() {
        Random rd = new Random(System.currentTimeMillis());
        int card = rd.nextInt(1,52);
        System.out.println("Sliced from card = " + card);
        String[] sliced1 = Arrays.copyOfRange(deck,0,card);
        String[] sliced2 = Arrays.copyOfRange(deck,card,52);
        int p = 0;
        for(String a : sliced2) {
            deck[p++] = a;
        }
        for(String b : sliced1) {
            deck[p++] = b;
        }


    }
}
