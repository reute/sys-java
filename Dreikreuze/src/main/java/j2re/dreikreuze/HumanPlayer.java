package j2re.dreikreuze;

import java.util.Scanner;

public class HumanPlayer extends Player {
    
    Scanner scanner;

    public HumanPlayer(Field field, Scanner scanner) {
        super(field);
        this.scanner = scanner;
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
