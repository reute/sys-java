package j2re.chacklucknb;

import java.util.Random;

public class Chackluck {

    Player player;

    public Chackluck() {
        player = new Player(1000);
    }

    public static void main(String[] args) {
        Chackluck game = new Chackluck();
        game.showIntro();
        game.run();
    }

    void run() {
        int playerBet, playerGuess;
        int[] dice;
        while (player.money > 0) {
            printStatusPlayer();
            playerBet = player.makeBet();
            playerGuess = player.makeGuess();
            dice = rollDice();
            calcTurn(dice, playerBet, playerGuess);
        }
        System.out.println("\nGlückwunsch, Sie verlassen das Casino mit " + player.money + " Geldeinheiten!!");
    }

    int[] rollDice() {
        System.out.println("Die Würfel sind gefallen:");
        Random rand = new Random();
        int numberDice;
        int[] numbersDice = new int[3];
        for (int i = 0; i < 3; i++) {
            numbersDice[i] = rand.nextInt(6) + 1;  
        }
        return numbersDice;
    }    

    void calcTurn(int[] dice, int playerBet, int playerGuess) {
        boolean playerWins = false;
        for (int numberDice : dice) {
            System.out.print(numberDice + " ");
            if (numberDice == playerGuess) {
                playerWins = true;
            }
        }
        if (playerWins) {
            player.money += playerBet;
            System.out.print("\nGlueckwunsch, Sie erhalten " + playerBet + " Geldeinheiten!!");
        } else {
            player.money -= playerBet;
            System.out.print("\nPech, da war nichts fuer Sie dabei!!");
        }
    }

    void showIntro() {
        System.out.println("**** Chuck-a-luck ****\nSie haben 1000 Geldeinheiten\nIn jeder Runde können Sie einen Teil davon auf eine der Zahlen 1 bis 6 setzen. Danach werden 3 Würfel geworfen. Falls Ihr Wert dabei ist, erhalten Sie Ihren Einsatz zurück und zusatzlich Ihren Einsatz fuer jeden Würfel,der die von Ihnen gesetzte Zahl zeigt.");
    }

    void printStatusPlayer() {
        System.out.println("Sie haben " + player.money + " Geldeinheiten");
    }    
}
