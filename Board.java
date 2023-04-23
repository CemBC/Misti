import java.util.ArrayList;

public class Board {
    private ArrayList<String> board;

    public ArrayList<String> getBoard() { return board; }
    public Board() {
        board = new ArrayList<String>();
    }

    public void addToBoard(String card){    //Elden tahtaya kart atmada kullanılacak
        board.add(card);
    }
    public void addToBoard(String card1 , String card2 , String card3 , String card4){     //Oyunun başında tahtaya 4 kart açarken kullanılacak
        board.add(card1);
        board.add(card2);
        board.add(card3);
        board.add(card4);
    }

    public void clearBoard() { //bir oyuncu kartları aldığı zaman tahtayı temizler (Tahtadan ele methodunu botların kendi class'ında tanımalamayı düşünüyorum)
        board.clear();
    }

    public void display() {   //Deck class'ındaki display methodu ile aynı
        System.out.println("-THE BOARD-");
        System.out.print("TOP --> [ ");
        for(String a : board){
            System.out.print(a + " ");
        }
        System.out.print("] <-- BOTTOM");
        System.out.println();
    }

    public boolean condition() {
        try {                                           //Tahtaya bir kart atıldıktan sonra atılan kartın tahtayı alıp alamadığını boolean döndürür
            if (board.get(board.size() - 1).substring(1).equals(board.get(board.size() - 2).substring(1))) {
                return true;                            //Player.addtoChest() methodunda condition olarak kullanılacak
            }
        }catch(IndexOutOfBoundsException ex) {
            return false;
        }
        if(board.get(board.size()-1).substring(1).equals("J")){
            return true;
        }
        return false;
    }

    public boolean mistiCondition() {                   //Condition for mişti
        if(board.size() == 2 && board.get(board.size() - 1).substring(1).equals(board.get(board.size() - 2).substring(1))) {
            return true;
        }
        return false;
    }
}
