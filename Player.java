public class Player {
	private String name;
    private Card[] cards;
    private int score;
    private int cardIdx;
    private int numOfCards;
    public Player(String name) {
        this.name = name;
        cards = new Card[4];
        this.score = 0;
        this.cardIdx=-1;
    }
    
    public void addCard(Card card) {
    	this.cardIdx++;
        this.cards[this.cardIdx] = card;
        
    }
    public void showCards() {
    	 for (int i = 0; i < this.cardIdx; i++) {
            System.out.print(i+") "+cards[i].getCardInfo()+ " | ");
        }
    }
   
    public void removeCards() {
        cards = new Card[4];
        this.cardIdx=-1;
    }//use this method if you want to remove all cards in your hand

    public void addNumOfCards(int numOfCards) {
        this.numOfCards += numOfCards;
    }

    public void removeCard(int removeIdx) {
        
        Card[] arr_new = new Card[4];
        
        for(int i=0,k=0;i<cards.length;i++){
            if(i!=removeIdx){
                arr_new[k]=cards[i];
                k++;
            }
        }
        cards = arr_new;
    }// use this method if you want to remove spesific card in your hand
 
    public int getCardIdx() {
    	 return cardIdx;
    }

  

    public Card[] getCards() {
        return cards;
    }

    
    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    																																																																																																																																																																																
}
