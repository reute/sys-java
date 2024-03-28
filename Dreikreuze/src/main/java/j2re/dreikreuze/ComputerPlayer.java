package j2re.dreikreuze;

import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer extends Player {

    public ComputerPlayer(Scanner scanner, Field field) {
        super(scanner, field);
    }

    public void makeTurn() {
        int position;
        Random rand = new Random();
        do {
            position = rand.nextInt((field.size - 1) + 1) + 1;
        } while (!field.take(position));
        System.out.println("Computer sets X at position " + position);
    }
}
