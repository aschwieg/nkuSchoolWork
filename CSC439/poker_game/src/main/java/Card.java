public class Card implements Comparable<Card>{
    public int rank;
    public char suit;

    public Card(String newCard) {
        if(newCard.substring(0,1).equals("T")) {
            this.rank = 10;
        }
        else if(newCard.substring(0,1).equals("J")) {
            this.rank = 11;
        }
        else if(newCard.substring(0,1).equals("Q")) {
            this.rank = 12;
        }
        else if(newCard.substring(0,1).equals("K")) {
            this.rank = 13;
        }
        else if(newCard.substring(0,1).equals("A")) {
            this.rank = 14;
        }
        else {
            this.rank = Integer.parseInt(newCard.substring(0,1));
        }
        this.suit = newCard.charAt(1);
    }

    @Override
    public int compareTo(Card o) {
        if (this.rank < o.rank) {
            return -1;
        }
        else if (this.rank == o.rank) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
