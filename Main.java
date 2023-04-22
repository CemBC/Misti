import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int checkerSize = 0;                //Control variables for control codes to checking game flow appropriate
            int[] checkerLevelOfBot = null;
            //----------------------------------------------
            Deck deck = new Deck();
            Board board = new Board();
            Scanner sc = new Scanner(System.in);
            Player player = new Player();
            System.out.println("WELCOME TO GAME MIŞTI");
            System.out.println("Will you play as a player or just watch the cache fight huh?");
            System.out.println("Enter 'w' for watching or type something to play = ");
            String playOrNot = sc.nextLine();
            ArrayList<Player> bots = new ArrayList<Player>();
            //WATCH--------------------------------------------------------------------------------------
            if (playOrNot.equals("W") || playOrNot.equals("w")) {

                int sizeOfPlayer = sizeOfPlayer();
                checkerSize = sizeOfPlayer;
                int[] levelOfBots = new int[sizeOfPlayer];
                levelOfPlayers(sizeOfPlayer, levelOfBots, true);
                checkerLevelOfBot = levelOfBots;
                boolean flagOfLevels = true;
                for (int i = 0; i < levelOfBots.length - 1; i++) {
                    if (levelOfBots[i] != levelOfBots[i + 1]) {
                        flagOfLevels = false;
                        break;
                    }
                }
                if (flagOfLevels) {
                    switch (levelOfBots[0]) {
                        case 1:
                            Player novice = new Novice();
                            Player novice1 = new Novice();
                            Player novice2 = new Novice();
                            Player novice3 = new Novice();
                            bots.add(novice);
                            bots.add(novice1);
                            bots.add(novice2);
                            bots.add(novice3);
                            break;
                        case 2:
                            Player regular = new Regular();
                            Player regular1 = new Regular();
                            Player regular2 = new Regular();
                            Player regular3 = new Regular();
                            bots.add(regular);
                            bots.add(regular1);
                            bots.add(regular2);
                            bots.add(regular3);
                            break;
                        case 3:
                            Player expert = new Expert();
                            Player expert1 = new Expert();
                            Player expert2 = new Expert();
                            Player expert3 = new Expert();
                            bots.add(expert);
                            bots.add(expert1);
                            bots.add(expert2);
                            bots.add(expert3);
                            break;
                    }
                } else {
                    for (int i = 0; i < levelOfBots.length; i++) {
                        switch (levelOfBots[i]) {
                            case 1:
                                Player novice = new Novice();
                                bots.add(novice);
                                break;
                            case 2:
                                Player regular = new Regular();
                                bots.add(regular);
                                break;
                            case 3:
                                Player expert = new Expert();
                                bots.add(expert);
                                break;
                        }
                    }
                }
                //------------------------------------------------------------------------------------
                //PLAY--------------------------------------------------------------------------------
            } else {
                int sizeOfPlayer = sizeOfPlayer();
                checkerSize = sizeOfPlayer;
                int[] levelOfBots = new int[sizeOfPlayer - 1];
                levelOfPlayers(sizeOfPlayer, levelOfBots, false);
                checkerLevelOfBot = levelOfBots;
                boolean flagOfLevels = true;
                for (int i = 0; i < levelOfBots.length - 1; i++) {
                    if (levelOfBots[i] != levelOfBots[i + 1]) {
                        flagOfLevels = false;
                        break;
                    }
                }
                if (flagOfLevels) {
                    switch (levelOfBots[0]) {
                        case 1:
                            Player novice = new Novice();
                            Player novice1 = new Novice();
                            Player novice2 = new Novice();
                            bots.add(novice);
                            bots.add(novice1);
                            bots.add(novice2);
                            break;
                        case 2:
                            Player regular = new Regular();
                            Player regular1 = new Regular();
                            Player regular2 = new Regular();
                            bots.add(regular);
                            bots.add(regular1);
                            bots.add(regular2);
                            break;
                        case 3:
                            Player expert = new Expert();
                            Player expert1 = new Expert();
                            Player expert2 = new Expert();
                            bots.add(expert);
                            bots.add(expert1);
                            bots.add(expert2);
                            break;
                    }
                } else {
                    for (int i = 0; i < levelOfBots.length; i++) {
                        switch (levelOfBots[i]) {
                            case 1:
                                Player novice = new Novice();
                                bots.add(novice);
                                break;
                            case 2:
                                Player regular = new Regular();
                                bots.add(regular);
                                break;
                            case 3:
                                Player expert = new Expert();
                                bots.add(expert);
                                break;
                        }
                    }
                }


            }
            //------------------------------------------------------------------------------------
            System.out.println("Deck is shuffling...");
            deck.shuffle();
            System.out.println("Cutting the deck...");
            deck.cut();
            System.out.println("Cards are being dealt...");
            board.addToBoard(deck.getACard(), deck.getACard(), deck.getACard(), deck.getACard());

            if (playOrNot.equals("W") || playOrNot.equals("w")) {     //Pişti condition , log ekle , gameflow bitir , file I/O
                while (true) {
                    for (int i = 0; i < bots.size(); i++) {
                        bots.get(i).addToHand(deck.getACard(), deck.getACard(), deck.getACard(), deck.getACard());
                    }
                    if (deck.isEmpty()) {
                        break;
                    }
                    //KOD YAZILACAK ALAN














                    //-------------------
                }
            } else {
                while (true) {
                    player.addToHand(deck.getACard(), deck.getACard(), deck.getACard(), deck.getACard());
                    for (int i = 0; i < bots.size(); i++) {
                        bots.get(i).addToHand(deck.getACard(), deck.getACard(), deck.getACard(), deck.getACard());
                    }
                    if (deck.isEmpty()) {
                        break;
                    }
                    //KOD YAZILACAK ALAN














                    //-------------------
                }

            }
            //Control codes
            for (int a : checkerLevelOfBot) {
                System.out.println(a);
            }
            System.out.println(checkerSize);
            for (Player a : bots) {
                System.out.println(a.level());
            }
            bots.get(0).addToHand("A", "B", "C", "D");
            System.out.println(bots.get(1).hand.size());
            System.out.println(bots.get(0).hand.size());


            break;
        }
    }

    public static void log() {   //buraya log gelecek
    }

    public static int sizeOfPlayer() {     //İki kere aynı kodu yazmamak için oyuncu sayısını seçme işini methoda aktardım iki oyun akışında da kullandım
        Scanner sc = new Scanner(System.in);
        int size = 0;
        while (true) {

            System.out.println("Enter the size of the player. Between 2-4 = ");
            size = sc.nextInt();
            if (size < 2 || size > 4) {
                System.out.println("Please enter an integer between 2-4");
                continue;
            } else {
                break;
            }


        }
        return size;

    }

    public static void levelOfPlayers(int sizeOfPlayer, int[] arr, boolean flag) {
        if (flag == true) { //watching
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 - for novice\nEnter 2 - for regular\nEnter 3 - for expert");
            System.out.println("Please enter a level for each bot");
            for (int i = 0; i < sizeOfPlayer; i++) {
                System.out.print(i + 1 + ". bot's level = ");
                while (true) {

                    int level = sc.nextInt();
                    if (level < 1 || level > 3) {
                        System.out.println("Please enter an integer for level of bot between 1-3");
                        continue;
                    } else {
                        arr[i] = level;
                        break;
                    }
                }
            }
        } else {  //playing
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 - for novice\nEnter 2 - for regular\nEnter 3 - for expert");
            System.out.println("Please enter a level for each bot");
            for (int i = 0; i < sizeOfPlayer - 1; i++) {
                System.out.print(i + 1 + ". bot's level = ");
                while (true) {

                    int level = sc.nextInt();
                    if (level < 1 || level > 3) {
                        System.out.println("Please enter an integer for level of bot between 1-3");
                        continue;
                    } else {
                        arr[i] = level;
                        break;
                    }
                }
            }
        }

    }
}
