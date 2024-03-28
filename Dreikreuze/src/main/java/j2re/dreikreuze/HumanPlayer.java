package j2re.dreikreuze;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(Scanner scanner, Field field) {
        super(scanner, field);
    }

    @Override
    public void makeTurn() {
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
