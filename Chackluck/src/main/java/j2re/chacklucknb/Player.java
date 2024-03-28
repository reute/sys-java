package j2re.chacklucknb;

import java.util.Scanner;

public class Player {

    int money;
    Scanner scanner = new Scanner(System.in);

    public Player(int money) {
        this.money = money;
    }

    int makeBet() {        
        System.out.print("Enter your Bet: ");
        return scanner.nextInt();
    }
    
    int makeGuess() {
        System.out.print("Enter your Guess Number: ");
        return scanner.nextInt();
    }
}
