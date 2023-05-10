import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class HighScorer {
    private static String fileName = "HighScore.txt";
    private static ArrayList<HighScorer> list = new ArrayList<HighScorer>();
    private String name;
    private int score;
    private String level;

    public HighScorer(String name, int score , String level) {
        this.name = name;
        this.level = level;
        this.score = score;
    }
    public static void sort() {
        for(int i = 0 ; i < list.size()-1 ; i++) {
            boolean swapped= false;
            HighScorer temp = null;
            for(int j = 0 ; j < list.size()-1 ; j++) {
                if(list.get(j).getScore() < list.get(j+1).getScore()) {
                    temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                    swapped = true;
                }
            }
            if(!swapped) {break;}
        }

    }

    public static void addToList(HighScorer h) {
        list.add(h);
    }
    public static void create() {
        Scanner input = null;
        boolean fileExists = false;
        try {
            input = new Scanner(Paths.get(fileName));
            fileExists = true;
        } catch (IOException e) {

        }
        finally {
            if (input!=null) input.close();
        }


        if (!fileExists) {
            Formatter output = null;
            try {
                output = new Formatter(fileName);
                output.format("");
            } catch (SecurityException e) {
                System.err.println("Write permission denied, terminating.");
                System.exit(1);
            }  catch (FileNotFoundException e) {
                System.err.println("Error opening the file, terminating.");
                System.exit(1);
            } finally {
                if (output!=null) output.close();
            }
        }
    }
    public static void Read() {
        Scanner input = null;
        try{
            input = new Scanner(Paths.get(fileName));
            System.out.println("\t\t\t-TOP 10 PLAYER-");
            while(input.hasNextLine()){
                System.out.println("\t\t" + input.nextLine());
            }
        }catch (IOException e) {
            System.out.println("Something went wrong while reading file");
            System.exit(31);
        }finally {
            if(input!= null) {input.close(); }
        }
    }

    public static void  updateNwrite() {
        Scanner input = null;
        try{
            input = new Scanner(Paths.get(fileName));
            while(input.hasNextLine()) {
                String[] splitted = input.nextLine().split(" ");
                HighScorer.addToList(new HighScorer(splitted[0],Integer.valueOf(splitted[1]),splitted[2]));
            }
        }catch(IOException e) {
            System.out.println("Something went wrong while updating file");
            System.exit(32);
        }finally{
            if(input != null) {
                input.close();
            }
        }
        HighScorer.sort();

        Formatter output = null;
        try {
            output = new Formatter(fileName);
            for(HighScorer h : list) {
                output.format("%s  %d  %s%n",h.getName(),h.getScore(),h.getLevel());
            }
        } catch (SecurityException e) {
            System.err.println("Write permission denied, terminating.");
            System.exit(1);
        }  catch (FileNotFoundException e) {
            System.err.println("Error opening the file, terminating.");
            System.exit(1);
        } finally {
            if (output!=null) output.close();
        }
    }

    public int getScore() {
        return score;
    }

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
