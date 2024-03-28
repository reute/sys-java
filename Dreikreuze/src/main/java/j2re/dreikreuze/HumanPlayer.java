package j2re.dreikreuze;

import java.util.Scanner;

public class HumanPlayer implements Player {

    Scanner scanner;

    public HumanPlayer(Scanner scanner) {
        this.scanner = scanner;
    }

    public void makeTurn(Field field) {
        int position;
        System.out.print("Your move: ");
        position = scanner.nextInt();
        while (!field.take(position)) {
            System.out.print("Feld schon belegt, bitte freies Feld auswählen");
            System.out.print("Your move: ");
            position = scanner.nextInt();
        }
    }
}
