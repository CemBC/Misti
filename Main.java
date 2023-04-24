import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            int checkerSize = 0;                //Control variables for control codes to checking game flow appropriate
            int[] checkerLevelOfBot = null;
            //----------------------------------------------
            boolean watch = false;
            Deck deck = new Deck();
            Board board = new Board();
            Scanner sc = new Scanner(System.in);
            Player player = new Player();
            System.out.println("WELCOME TO GAME MIŞTI");
            System.out.println("Will you play as a player or just watch the cache fight huh?");
            System.out.println("Enter 'w' for watching or type something to play = ");
            String playOrNot = sc.nextLine();
            ArrayList<Player> bots = new ArrayList<Player>();
            if (playOrNot.equals("W") || playOrNot.equals("w")) {
                watch = true;
            }

            int sizeOfPlayer = sizeOfPlayer();
            checkerSize = sizeOfPlayer;
            int[] levelOfBots;
            if(watch) {
                levelOfBots = new int[sizeOfPlayer];
            }else{
                levelOfBots = new int[sizeOfPlayer-1];
            }
            levelOfPlayers(sizeOfPlayer, levelOfBots, watch);
            checkerLevelOfBot = levelOfBots;
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
            /*if (watch) { //WATCH--------------------------------------------------------------------------------------

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
                            for(int i = 0 ; i < sizeOfPlayer ; i++) {
                                Player novice = new Novice();
                                bots.add(novice);
                            }
                            break;
                        case 2:
                            for(int i = 0 ; i < sizeOfPlayer ; i++) {
                                Player regular = new Regular();
                                bots.add(regular);
                            }
                            break;
                        case 3:
                            for(int i = 0 ; i < sizeOfPlayer ; i++) {
                                Player expert = new Expert();
                                bots.add(expert);
                            }

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
                            for(int i = 0 ; i < sizeOfPlayer ; i++) {
                                Player novice = new Novice();
                                bots.add(novice);
                            }
                            break;
                        case 2:
                            for(int i = 0 ; i < sizeOfPlayer ; i++) {
                                Player regular = new Regular();
                                bots.add(regular);
                            }
                            break;
                        case 3:
                            for(int i = 0 ; i < sizeOfPlayer ; i++) {
                                Player expert = new Expert();
                                bots.add(expert);
                            }
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


            }  */
            String[][] log;
            if (watch) {
                log = new String[4][bots.size()];
            } else {
                log = new String[4][bots.size() + 1];
            }
            //------------------------------------------------------------------------------------
            System.out.println("Deck is shuffling...");
            deck.shuffle();
            System.out.println("Cutting the deck...");
            deck.cut();
            System.out.println("Cards are being dealt...");
            board.addToBoard(deck.getACard(), deck.getACard(), deck.getACard(), deck.getACard());
            int round = 1;
            while (true) {

                if (deck.isEmpty()) {
                    break;
                }
                if (!watch) {
                    player.addToHand(deck.getACard(), deck.getACard(), deck.getACard(), deck.getACard());
                }
                for (int i = 0; i < bots.size(); i++) {
                    bots.get(i).addToHand(deck.getACard(), deck.getACard(), deck.getACard(), deck.getACard());
                }
                String hands = hands(bots, player, round, watch);
                if(watch) {
                    board.display();
                }
                for (int j = 0; j < 4; j++) {
                    if (!watch) {                            //oyuncuya oyunu oynatman lazım
                        board.display();
                        System.out.println("Enter an index to play");
                        player.display();
                        System.out.print("Index = ");
                        int index = -1;
                        while (true) {
                            try {
                                index = sc.nextInt();
                                if (index < 0 || index > player.getHand().size()-1) {
                                    System.out.println("Please enter a valid index");
                                    continue;
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Please enter an integer");
                                sc.nextLine();
                            }
                        }
                        String temp = player.play(index);
                        board.addToBoard(temp);
                        player.addToChest(board.getBoard(), board.condition());
                        if (board.mistiCondition() || board.condition()) {
                            log[j][0] = temp + "!";
                            board.getBoard().clear();
                        } else {
                            log[j][0] = temp;
                        }

                        for (int i = 0; i < bots.size(); i++) {
                            temp = bots.get(i).play(bots.get(i).chooseACard(board));
                            board.addToBoard(temp);
                            for(int k = 0 ; k < bots.size() ; k++) {
                                if(bots.get(k).level().equals("Expert")){
                                    bots.get(k).addToMind();
                                }

                            }
                            bots.get(i).addToChest(board.getBoard(), board.condition());
                            if (board.mistiCondition() || board.condition()) {
                                log[j][i+1] = temp + "!";
                                board.getBoard().clear();
                            } else {
                                log[j][i+1] = temp;
                            }

                        }
                    } else {
                        for (int i = 0; i < bots.size(); i++) {
                            String temp = bots.get(i).play(bots.get(i).chooseACard(board));
                            board.addToBoard(temp);
                            for(int k = 0 ; k < bots.size() ; k++) {
                                if(bots.get(k).level().equals("Expert")){
                                    bots.get(k).addToMind();
                                }

                            }
                            bots.get(i).addToChest(board.getBoard(), board.condition());
                            if (board.mistiCondition() || board.condition()) {
                                log[j][i] = temp + "!";
                                board.getBoard().clear();
                            } else {
                                log[j][i] = temp;
                            }
                        }
                    }
                }
                log(bots, watch, hands, log);
                round += 1;
            }
            board.display();
            //Control codes
            /* for (int a : checkerLevelOfBot) {
                System.out.println(a);
            }
            System.out.println(checkerSize);
            for (Player a : bots) {
                System.out.println(a.level());
            }
            bots.get(0).addToHand("A", "B", "C", "D");
            System.out.println(bots.get(1).hand.size());
            System.out.println(bots.get(0).hand.size());


            break;  */
            System.out.println("Do you want to play againg ? ");
            System.out.println("If you want to quit please enter 'q' , or keep up the game");
            String ch = sc.nextLine();
            if(ch.equals("q")||ch.equals("Q")) {
                System.out.println("See you then");
                break;
            }
        }
    }

    public static void log(ArrayList<Player> bots, boolean watch, String hands, String[][] log) {   //buraya log gelecek
        System.out.println("----------------------------------------------------");
        System.out.println(hands);
        int size = -1;
        if(watch) {
            size = bots.size();
        }else{
            size = bots.size()+1;
        }
        for (int i = 0; i < 4; i++) {
            System.out.print(i + 1 + ". ");
            for (int j = 0; j < size; j++) {
                System.out.print(log[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("\n");
        System.out.println("----------------------------------------------------");


    }


    public static String hands(ArrayList<Player> bots, Player player, int round, boolean watch) {
        String temp = "";
        temp += "Hand " + round + " :";
        if (!watch) {
            temp += "Your hand = " + player.display(0);
        }
        for (int i = 0; i < bots.size(); i++) {
            temp += bots.get(i).display(i+1);
        }

        return temp;
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

    public static void levelOfPlayers(int sizeOfPlayer, int[] arr, boolean watch) {
        if (watch) { //watching
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 - for novice\nEnter 2 - for regular\nEnter 3 - for expert");
            System.out.println("Please enter a level for each bot");
            for (int i = 0; i < sizeOfPlayer; i++) {
                System.out.print(i + 1 + ". bot's level = ");
                while (true) {
                    try {
                        int level = sc.nextInt();
                        if (level < 1 || level > 3) {
                            System.out.println("Please enter an integer for level of bot between 1-3");
                            continue;
                        } else {
                            arr[i] = level;
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter an integer");
                        sc.nextLine();
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
                    try {
                        int level = sc.nextInt();
                        if (level < 1 || level > 3) {
                            System.out.println("Please enter an integer for level of bot between 1-3");
                            continue;
                        } else {
                            arr[i] = level;
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter an integer");
                        sc.nextLine();
                    }
                }
            }
        }

    }
}
