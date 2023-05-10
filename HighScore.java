import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class HighScore {
    private static ArrayList<HighScore> highScores = new ArrayList<>(11);
    private static String highScoresFileName = "highScores.txt";
    private String name;
    private int score;
    private String expertiseLevel;

    public HighScore(String name, int score, String expertiseLevel) {
        this.name = name;
        this.score = score;
        this.expertiseLevel = expertiseLevel;
    }

    public String getName() {return name;}
    public int getScore() {return score;}
    public String getExpertiseLevel() {return expertiseLevel;}


    // If file doesn't exist, creates it. If file exist, reads all of it.
    public static void updateHighScores () {
        // Check if the file exists
        Scanner input = null;
        boolean fileExists = false;
        try {
            input = new Scanner(Paths.get(highScoresFileName));
            fileExists = true;
        } catch (IOException e) {
            // Ignore
        }
        finally {
            if (input!=null) input.close();
        }

        // Create the file if it doesn't exist.
        if (!fileExists) {
            Formatter output = null;
            try {
                output = new Formatter(highScoresFileName);
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

        int totalLinesRead = 0;
        try {
            input = new Scanner(Paths.get(highScoresFileName));
            while (input.hasNextLine() && totalLinesRead <10) { // Only first 10 lines are read.
                totalLinesRead++;
                String line = input.nextLine();
                if (!line.matches("^[a-zA-Z]{3,10}\\s-?\\d+\\s[HNRE]$")) {
                    System.err.println("High scores file is badly formatted, terminating.");
                    System.exit(1);
                } else {
                    String[] values = line.split(" ");
                    highScores.add(new HighScore(
                            values[0],
                            Integer.parseInt(values[1]),
                            values[2]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error opening the high scores file, terminating.");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println("A score was too large for an int, terminating.");
            System.exit(1);
        } finally {
            if (input!=null) input.close();
        }
    }

    // Returns which placement the player will be in and updates high score list, returns 0 if not a high score.
    public static int checkIfHighScore(Player player) {
        // In case of file is empty.
        if (highScores.isEmpty()) {
            highScores.add(new HighScore(
                    player.getName(),
                    player.getScore(),
                    player.getExpertiseLevel()
            ));
            return 1;
        } else {
            for (int i = 0; i < 10; i++) {
                if (player.getScore() > highScores.get(i).getScore()) {
                    // We have a high score.
                    highScores.add(i, new HighScore(
                            player.getName(),
                            player.getScore(),
                            player.getExpertiseLevel()
                    ));

                    // Rewrite the entire high score file.
                    Formatter output = null;
                    try {
                        output = new Formatter(highScoresFileName);
                        for (HighScore highScore : highScores) {
                            output.format(
                                    "%s %d %s%n",
                                    highScore.getName(),
                                    highScore.getScore(),
                                    highScore.getExpertiseLevel());
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

                    // In case of high score file doesn't have 10 entries.
                    if (highScores.get(10)!=null) highScores.remove(10);
                    return i+1;
                }
            }
            return 0;
        }
    }
}
