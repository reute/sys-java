package j2re.dreikreuze;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer( Field field) {
        super(field);
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
