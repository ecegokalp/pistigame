	    package pisti;

	import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to pisti! please enter your name");
        String name = sc.nextLine();
       System.out.println("Please enter how many cards will be exchange from top to bottom");
        int x = sc.nextInt();
        newGame.cut(x);
        
    }
}
        }
}