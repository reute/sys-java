package j2re.dreikreuze;

import java.util.Scanner;

abstract class Player {

    Scanner scanner;
    Field field;

    public Player(Scanner scanner, Field field) {
        this.scanner = scanner;
        this.field = field;
    }

    abstract void makeTurn();
}
