import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Value {
    private static ArrayList<Value> values = new ArrayList<>();
    private static int defaultValue = 1;
    private final String suit;
    private final String cardface;
    int point;

    public Value(String suit, String cardface, int point) {
        this.suit = suit;
        this.cardface = cardface;
        this.point = point;
    }

    public String getSuit() {return suit;}
    public String getCardface() {return cardface;}
    public int getPoint() {return point;}

    // How to use:
    // Value.of("S3")
    // will return 5
    public static int of (String card) {
        for(Value value : values) {
            String suit = value.getSuit();
            String cardface = value.getCardface();
            if (card.substring(0,1).equals(suit) || suit.equals("*")) {
                if (card.substring(1,2).equals(cardface) || cardface.equals("*")) {
                    return value.getPoint();
                }
            }
        }
        return defaultValue; // In case of there being no values.
    }

    // Can be run whenever points file is updated, in this case only at the beginning
    public static void updateValues (String fileName) {
        Scanner input = null;
        try {
            input = new Scanner(Paths.get(fileName));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (!line.matches("^[SCHD*][A123456789TJQK*]\\s-?\\d+$")) {
                    System.err.println("Points file is badly formatted, terminating.");
                    System.exit(1);
                } else {
                    values.add(new Value(
                            line.substring(0,1), // charAt kullanılırsa char döndürüyor, String değil.
                            line.substring(1,2),
                            Integer.parseInt(line.substring(3))));
                }
            }
        } catch (IOException e) {
            System.err.println("Error opening the points file, terminating.");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println("A point was too large for an int, terminating.");
            System.exit(1);
        } finally {
            if (input!=null) input.close();
        }
    }
}
