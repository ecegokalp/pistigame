package pisti;
public class Card {
	private String suit;
    private String rank;
    
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getCardInfo() {
        return "Suit: "+this.suit+ "  "+"Rank: "+ this.rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

}

