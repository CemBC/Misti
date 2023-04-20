import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO GAME MIŞTI");
        System.out.println("Will you play as a player or just watch the cache fight huh?");
        System.out.println("Enter 'w' for watching or type something to play = ");
        String playOrNot =  sc.nextLine();
        if(playOrNot.equals("W") || playOrNot.equals("w")) {
            int sizeOfPlayer = sizeOfPlayer();

        }else {
            int sizeOfPlayer = sizeOfPlayer();




        }

    }

    public static void log() {   //buraya log gelecek
    }

    public static int sizeOfPlayer() {
        Scanner sc = new Scanner(System.in);
        int size = 0;
        while(true) {
            try{
                System.out.println("Enter the size of the player. Between 2-4 = ");
                size = sc.nextInt();
                break;
            }catch(Exception e) {
                System.out.println("Please enter an integer between 2-4");
                sc.nextLine();
            }

        }
        return size;

    }
}
