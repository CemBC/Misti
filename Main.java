public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Board board = new Board();
        deck.display();
        deck.shuffle();
        deck.display();
        deck.cut();
        deck.display();
        board.addToBoard("String");
        board.addToBoard("String");
        board.display();
        board.clearBoard();
        board.display();
    }
}
