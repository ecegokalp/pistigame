package pisti;
import java.util.Random;
public class Game {
	package pisti;
import java.util.Random;
import java.util.Scanner;
public class Game {
    private Card[] board;
    private Card[] deck;
    public Game() {;
        this.deck = new Card[52];
        
        String s[]= {"hearts","spades","diamonds","clubs"};
        String r[] = {"Ace","2","3","4","5","6","7","8","9","10","J","K","A"};
        int idx = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < r.length; j++) {
                this.deck[idx] = new Card(s[i],r[j]);
                idx++;
            }
        }
        
        System.out.println("-------GAME READY!-------");
    }


        public void Shuffle() {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIdx = rand.nextInt(52) ;
            Card temp = this.deck[i];
            this.deck[i] = this.deck[randomIdx];
            this.deck[randomIdx] = temp;
        } 
        for (Card card : this.deck) {
            System.out.println(card.getCardInfo());
        }
        System.out.println("------CARDS ARE SHUFFLED------");
    }

    public void cut(int idx) {
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
    
    }
    
    

