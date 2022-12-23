package pisti;
mport java.util.Random;
import java.util.Scanner;
public class Game {
	private Player player1;
    private Player player2;
    private Card[] board;
    private Card[] deck;
    private int boardIdx;
    private int handIdx;
      public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Card[52];
        this.deck = new Card[52];
        this.boardIdx = -1;
        this.handIdx = 0;
        
        
        String s[]= {"hearts","spades","diamonds","clubs"};
        String r[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int idx = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < r.length; j++) {
                this.deck[idx] = new Card(s[i],r[j]);
                idx++;
            }
        }
        
        System.out.println("-------GAME READY!-------");
    this.Shuffle();
    this.cut();
    }

        public void Shuffle() {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIdx = rand.nextInt(52) ;
            Card temp = this.deck[i];
            this.deck[i] = this.deck[randomIdx];
            this.deck[randomIdx] = temp;
        } 
        for (int i=0;i<deck.length;i++) {
        	System.out.println(deck[i].getCardInfo());
        }
        
        System.out.println("------CARDS ARE SHUFFLED------");
    }

    public void cut() {
    	Scanner sc=new Scanner (System.in);
    	System.out.println("please enter how many cards will be exchange from top to bottom");
    	int idx=sc.nextInt();
        Card[] temp = new Card[idx];
        Card[] temp1 = new Card[52-idx];
        
        for (int index = 0; index < idx; index++) {
            temp[index] = deck[index];
        }
        int a = 0;
        for (int index = idx; index < 52; index++) {
            temp1[a] = deck[index];
            a++;
        }

        deck = new Card[52];

       
        for (int index = 0; index<temp1.length; index++) {
            deck[index] = temp1[index];
        }
        int b = 0;
        for (int index = temp1.length; index < 52; index++) {
            deck[index] = temp[b];
            b++;
        }

        for (Card card : this.deck) {
            System.out.println(card.getCardInfo());
        }

        System.out.println("-----CARDS ARE CUT-------");
    }
    
    public void showBoard() {
        System.out.println("--------BOARD--------");
        if (this.boardIdx != -1) {
            System.out.println(" | " + this.board[0].getCardInfo() + " | ");
        } else {
            System.out.println(" | " + "The board is empty :(" + " | ");
        }

        System.out.println("");
        System.out.println("---------------------");

    }

    public Card[] getBoardCards() {
        return this.board;
    }

    public void removeBoard() {
        this.board = new Card[52];
        this.boardIdx = -1;
    }

    public void addCardToBoard(Card x) {
        Card[] newArr = new Card[52];
        newArr[0] = x;

        for (int i = 1; i <= this.boardIdx + 1; i++) {
            newArr[i] = this.board[i - 1];
        }

        this.board = newArr;
        this.boardIdx++;
    }

    public int calculatePoint(Card s) {

        if (s.getSuit() == "diamonds" && s.getRank() == "10") {
            return 3;
        } else if (s.getSuit() == "clubs" && s.getRank() == "2") {
            return 2;
        } else {
            return 1;
        }
    }

    public int calculatePointOnBoard() {

        int score = 0;
        for (int index = 0; index <= this.boardIdx; index++) {
            score += this.calculatePoint(this.board[index]);
        }
        return score;
    }
    public boolean compareCard(Card card, Card card2) {
        if (card.getRank() == card2.getRank()) {
            return true;
        } else {
            return false;
        }
    }
     
         public void startGame(){
        Scanner input = new Scanner(System.in);
        while (this.handIdx < 52) {

            // GIVE CARDS TO PLAYERS
            for (int i = this.handIdx; i < this.handIdx + 8; i++) {
                if (i % 2 == 0) {
                    player1.addCard(this.deck[i]);
                } else if (i % 2 == 1) {
                    player2.addCard(this.deck[i]);
                }
            }

            this.handIdx += 8;

            // GIVE CARDS TO BOARD FOR FIRST HAND
            if (this.handIdx == 8) {
                for (int j = this.handIdx; j < this.handIdx + 4; j++) {
                    this.addCardToBoard(deck[j]);
                }
                this.handIdx += 4;
            }

            while (player1.getCardIdx() != -1 && player2.getCardIdx() != -1) {
                showBoard();
                System.out.println("-----YOUR CARDS------");
                player1.showCards();
                int choosenCard;
                if (player1.getCardIdx() != -1) {
                    while (true) {
                        String showInfo = "Select 0" + "- " + (player1.getCardIdx() + ": ");
                        System.out.println("");
                        System.out.print(showInfo);
                        choosenCard = input.nextInt();

                        if (choosenCard >= player1.getCards().length || choosenCard < 0) {
                            System.out.println("PLEASE SELECT VALID CARD");
                            continue;
                        } else {
                            break;
                        }
                    }

                    this.addCardToBoard(player1.getCards()[choosenCard]);
                    player1.removeCard(choosenCard);
                    if (this.boardIdx > 0
                            && (this.compareCard(this.board[0], this.board[1]) || this.board[0].getRank() == "J")) {

                        if (this.boardIdx == 1) {
                            player1.addScore(10);
                            player1.addNumOfCards(2);
                        } else {
                            player1.addScore(this.calculatePointOnBoard());
                            player1.addNumOfCards(this.boardIdx + 1);
                        }
                        this.removeBoard();
                    }
                }

    
            }


        }
    
    }
}