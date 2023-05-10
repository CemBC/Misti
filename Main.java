import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Appropriate argument example:\n" + ">java -jar Misti.jar <numberOfPlayer> <FileName.txt> <PlayerName> <PreviousPlayerLevel> .... <VerboseMode>");
        System.out.println(">java -jar Misti.jar 4 pointFile.txt Kaya H Ilker E Cem R Kutluhan N true");
        getArgs(args);
        Value.updateValues(args[1]);
        HighScore.updateHighScores();
        while (true) {
            //----------------------------------------------
            boolean watch = true;
            Deck deck = new Deck();
            Board board = new Board();
            Scanner sc = new Scanner(System.in);

            ArrayList<Player> bots = new ArrayList<Player>();
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("H")) {
                    watch = false;
                    if (args[args.length-1].equals("false")){
                        System.out.println("Warning = While playing, verbose mode must be on.\nVerbose mode is automatically opened");
                        args[args.length-1] = "true";
                    }
                    break;
                }
            }
            int sizeOfPlayer = 0;
            try {
                sizeOfPlayer = Integer.valueOf(args[0]);
                if (sizeOfPlayer < 2 || sizeOfPlayer > 4) {
                    System.out.println("Invalid type of number of players");
                    System.exit(2);
                }
            } catch (Exception e) {
                System.out.println("Invalid type of number of players");
                System.exit(2);
            }
            String[][] Players = new String[sizeOfPlayer][2];

            int p = 2;
            for (int i = 0; i < Players.length; i++) {
                Players[i][0] = args[p++];
                Players[i][1] = args[p++];

            }

            Player player = new Player("");
            for (int i = 0; i < Players.length; i++) {
                switch (Players[i][1]) {
                    case "E":
                        Player expert = new Expert(Players[i][0]);
                        bots.add(expert);
                        break;
                    case "R":
                        Player regular = new Regular(Players[i][0]);
                        bots.add(regular);
                        break;
                    case "N":
                        Player novice = new Novice(Players[i][0]);
                        bots.add(novice);
                        break;
                    case "H":
                        Player human = new Player(Players[i][0]);
                        player = human;
                        break;
                    default:
                        System.out.println("Invalid type of arguments");
                        System.exit(3);
                }
            }
            for (int i = 0; i < Players.length; i++) {
                if (Players[i][0].equals("H") || Players[i][0].equals("R") || Players[i][0].equals("E") || Players[i][0].equals("N")) {
                    System.out.println("Player's or Bot's name can not represent the level of them");
                    System.exit(3);
                }
            }
            if (Collections.frequency(List.of(args), "H") > 1) {
                System.out.println("There can not be more than one player");
                System.exit(4);
            }

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
            minder(bots, board, false);
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
                if (watch) {
                    board.display(calculateBoard(board));
                }
                for (int j = 0; j < 4; j++) {
                    if (!watch) {                            //oyuncuya oyunu oynatman lazım
                        board.display(calculateBoard(board));
                        System.out.println("Enter an index to play");
                        player.display();
                        System.out.print("Index = ");
                        int index;
                        while (true) {
                            try {
                                index = sc.nextInt();
                                if (index < 0 || index > player.getHand().size() - 1) {
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
                        minder(bots, board, true);
                        player.addToChest(board.getBoard(), board.condition());
                        player.addScore();
                        if (board.mistiCondition() || board.condition()) {
                            if (board.mistiCondition()) {
                                //Buraya mişti için puan ekleme koyarsınız
                                log[j][0] = temp + "!!";
                                board.getBoard().clear();
                            } else {
                                //buraya normal kart alma için puan ekleme koyarsınız
                                log[j][0] = temp + "!";
                                board.getBoard().clear();
                            }
                        } else {
                            log[j][0] = temp;
                        }

                        for (int i = 0; i < bots.size(); i++) {
                            temp = bots.get(i).play(bots.get(i).chooseACard(board, calculateBoard(board)));
                            board.addToBoard(temp);
                            minder(bots, board, true);
                            bots.get(i).addToChest(board.getBoard(), board.condition());
                            bots.get(i).addScore();
                            if (board.mistiCondition() || board.condition()) {
                                if (board.mistiCondition()) {
                                    //Buraya mişti için puan ekleme koyarsınız
                                    log[j][i + 1] = temp + "!!";
                                    board.getBoard().clear();
                                } else {
                                    //buraya normal kart alma için puan ekleme koyarsınız
                                    log[j][i + 1] = temp + "!";
                                    board.getBoard().clear();
                                }
                            } else {
                                log[j][i + 1] = temp;
                            }

                        }
                    } else {
                        for (int i = 0; i < bots.size(); i++) {
                            String temp = bots.get(i).play(bots.get(i).chooseACard(board, calculateBoard(board)));
                            board.addToBoard(temp);
                            minder(bots, board, true);
                            bots.get(i).addToChest(board.getBoard(), board.condition());
                            bots.get(i).addScore();
                            if (board.mistiCondition() || board.condition()) {
                                if (board.mistiCondition()) {
                                    //Score ekleme kullanmanız lazım
                                    log[j][i] = temp + "!!";
                                    board.getBoard().clear();
                                } else {
                                    //Score ekleme kullanmanız lazım
                                    log[j][i] = temp + "!";
                                    board.getBoard().clear();
                                }
                            } else {
                                log[j][i] = temp;
                            }
                        }
                    }
                }
                if (Boolean.parseBoolean(args[args.length - 1])) {
                    log(bots, watch, hands, log);
                }
                round += 1;
            }
            board.display(calculateBoard(board));
            System.out.println("-THE FINAL SCORES-");
            if(!watch) {
                player.addScore();
                System.out.println("  "+player.getName() + " == " + player.getScore());
            }
            for(Player z : bots){
                z.addScore();
                System.out.println("  "+z.getName() + " == " + z.getScore());
            }
            // TODO Kaçıncı olduğu oyuncuya bildirilebilir,şu an yalnızca dosyaya kaydediyor.
            //  Yüksek skor yapmışsa metot 1 ile 10 arası bir sayı döndürüyor
            //  Yüksek skor yapmamışsa metot 0 döndürüyor
            HighScore.checkIfHighScore(player);
            for (Player z : bots) {
                HighScore.checkIfHighScore(z);
            }
            System.out.println("Do you want to play again ? ");
            System.out.println("If you want to quit please enter '1' , or keep up the game");
            try {
                int ch = sc.nextInt();
                if (ch == 1) {
                    System.out.println("See you then");
                    break;
                }
            } catch (Exception e) {

            }


        }
    }

    public static void log(ArrayList<Player> bots, boolean watch, String hands, String[][] log) {   //buraya log gelecek
        System.out.println("----------------------------------------------------");
        System.out.println(hands);
        int size;
        if (watch) {
            size = bots.size();
        } else {
            size = bots.size() + 1;
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
            temp += bots.get(i).display(0); //+ bots.get(i).getScore()+ "/";
        }

        return temp;
    }


    public static void minder(ArrayList<Player> bots, Board board, boolean flag) {

        for (int k = 0; k < bots.size(); k++) {
            if (bots.get(k).level().equals("Expert")) {
                bots.get(k).addToMind(board, flag);
            }

        }

    }

    public static void getArgs(String[] args) {
        try {
            if (args.length < 7 || args.length != Integer.valueOf(args[0]) * 2 + 3) {
                System.out.println("Invalid arguments");
                System.exit(1);
            }
            if (!(args[args.length - 1].equals("true") || args[args.length - 1].equals("false"))) {
                System.out.println("Please enter the verbose type 'true' or 'false' ");
                System.exit(1);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter an integer as number of players");
            System.exit(1);
        }
    }


    public static int calculateBoard(Board boardd) {
        ArrayList<String> board = boardd.getBoard();
        int total = 0;
        for (String a : board) {
            total += Value.of(a);
        }
        return total;
    }
}

//hErkes aynı anda yazmamalıymış beyler
