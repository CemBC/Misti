import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //----------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO GAME MIŞTI");
        System.out.println("Will you play as a player or just watch the cache fight huh?");
        System.out.println("Enter 'w' for watching or type something to play = ");
        String playOrNot =  sc.nextLine();
        if(playOrNot.equals("W") || playOrNot.equals("w")) {
            Player[] bots = new  Player[sizeOfPlayer()-1];
            int sizeOfPlayer = sizeOfPlayer();
            int[] levelOfBots = new int[sizeOfPlayer];
            levelOfPlayers(sizeOfPlayer,levelOfBots);
        }else {
            Player[] bots = new  Player[sizeOfPlayer()-1];
            int sizeOfPlayer = sizeOfPlayer();
            int[] levelOfBots = new int[sizeOfPlayer-1];
            levelOfPlayers(sizeOfPlayer,levelOfBots);
            if(levelOfBots[0] == levelOfBots[1] && levelOfBots[0] == levelOfBots[2]) {  //BURAYI ELLEME DAHA BİTİRMEDİM YUKARIDAKİ İF CLAUSE U DA ELLEME
                switch(levelOfBots[0]) {
                    case 1:

                }
            }else{
                for (int i = 0; i < levelOfBots.length; i++) {
                    switch (levelOfBots[i]) {
                        case 1:
                            try {
                                Player novice = new Novice();
                                break;
                            }catch(Exception e) {
                                Player novice2 = new Novice();
                                break;
                            }
                        case 2:
                            try {
                                Player regular = new Regular();
                                break;
                            }catch(Exception e) {
                                Player regular2 = new Regular();
                                break;
                            }
                        case 3:
                            try {
                                Player expert = new Expert();
                                break;
                            }catch(Exception e) {
                                Player expert2 = new Expert();
                                break;
                            }
                    }
                }
            }

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

    public static void levelOfPlayers(int sizeOfPlayer,int[] arr) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < sizeOfPlayer ; i++) {
            System.out.print(i+1+". bot's level");
            while(true) {
                try {
                    arr[i++] = sc.nextInt();
                    break;
                }catch(Exception e) {
                    System.out.println("Please enter an integer for level of bot between 1-3");
                    sc.nextLine();
                }
            }
        }

    }
}
