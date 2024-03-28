package j2re.dreikreuze;

import java.util.Scanner;

public class Dreikreuze {

    Scanner scanner;
    Field field;
    int playerIndex;
    Player players[];

    final int FIELD_SIZE = 23;
    final int HUMAN = 0;
    final int COMP = 1;

    public Dreikreuze() {
        scanner = new Scanner(System.in);
        field = new Field(FIELD_SIZE);
        players = new Player[2];
        players[HUMAN] = new HumanPlayer(field, scanner);
        players[COMP] = new ComputerPlayer(field);
    }

    public static void main(String[] args) {
        Dreikreuze game = new Dreikreuze();
        game.intro();
        game.run();

    }

    void run() {
        while (field.spaceLeft()) {
            players[playerIndex].makeTurn();
            field.print();
            if (field.gameover()) {
                break;
            }
            playerIndex = (playerIndex + 1) % 2;
        }
        if (players[playerIndex] instanceof HumanPlayer) {
            System.out.println("You win !");
        } else {
            System.out.println("You lose !");
        }
    }

    void intro() {
        System.out.println("*** Drei Kreuze ***\nGegeben ist eine Kette von 23 freien Feldern. In jedem Zug setzt jeder der Spieler ein X auf ein freies Feld. Wenn dadurch drei oder mehr X benachbart sind, hat der Spieler gewonnen.");
        System.out.print("Wollen Sie anfangen? Ja=1 Nein=2 ");
        int playerBegins = scanner.nextInt();
        if (playerBegins == 1) {
            playerIndex = HUMAN;
        } else {
            playerIndex = COMP;
        }
        field.print();
    }
}
