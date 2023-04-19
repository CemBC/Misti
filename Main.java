public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Board board = new Board();
        deck.display();
        deck.shuffle();
        deck.display();
        deck.cut();
        deck.display();
        board.addToBoard(deck.getCard());
        board.addToBoard(deck.getCard());
        board.display();
        System.out.println(board.condition());
    }
}
