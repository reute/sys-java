package j2re.dreikreuze;

import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer implements Player {

    Scanner scanner;

    public ComputerPlayer(Scanner scanner) {
        this.scanner = scanner;
    }

    public void makeTurn(Field field) {
        int position;
        Random rand = new Random();
        do {
            position = rand.nextInt((field.size - 1) + 1) + 1;
        } while (!field.take(position));
        System.out.println("Computer sets X at position " + position);
    }
}
