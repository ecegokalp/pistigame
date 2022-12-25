	    
	import java.util.Scanner;
public class Main {
	    public static void main(String[] args) {
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("welcome to pisti! please enter your name");
	    	String name=sc.nextLine();
	    	Player player1 = new Player(name);
	        Player player2 = new Player("computer");
	        Game newGame = new Game(player1, player2);
	    	
}
}
