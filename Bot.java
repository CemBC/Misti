public interface Bot {

    default void display() {
        System.out.println();
    }   //Bot'un elini göstermesi için bir method
    String play(int index);                            //Bot'un oynayacağı kartı döndüren bir method. Board\addToBoard() methodu için kullanılır
    int chooseACard();                                  //Bot'un kart seçme mekanizması olacak

}
