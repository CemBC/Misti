public interface Bot {

    default void display() {
        System.out.println();
    }
    void play(int index);
    int chooseACard();

}
