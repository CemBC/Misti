import java.util.ArrayList;

public interface Bot {

    default void display() {
        System.out.println();
    }   //Bot'un elini göstermesi için bir method

    int chooseACard();                                  //Bot'un kart seçme mekanizması olacak
    void addToCache(ArrayList<String> board,boolean condition);           //Tahtadan zulaya kart aktarır
    String play(int index);                            //Bot'un oynayacağı kartı döndüren bir method. Board\addToBoard() methodu için kullanılır

    //addToCache ve play methodları bütün botlar için aynı olacak ancak hand ve board değişkenleri burada tanımlı olmadığı için default olarak tanımlayamıyorum
    //çözümünü biliyorsan hallet
}
