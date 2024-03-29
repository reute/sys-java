package j2re.sortthings;

import java.util.Scanner;

public class Terminal {

    Scanner scanner = new Scanner(System.in);

    void printLists(Mountain[] mountains, PlayersList playersList) { //  playersList
        System.out.println("Current state:");
        int i = 0;
        for (Mountain mountain : playersList) {
            System.out.println(" " + i + ": " + mountain.name);
            i++;
        }
        System.out.println("Still to be sorted:");
        i = 0;
        for (Mountain mountain : mountains) {
            if (mountain != null) {
                System.out.println(" " + i + ": " + mountain.name);
            }
            i++;
        }
    }

    void printEndresult(PlayersList playersList) {
        System.out.println("Sorry, then it is no longer sorted:");
        for (Mountain mountain : playersList) {
            System.out.printf("%5d %s \n", mountain.height, mountain.name);
        }
        System.out.println("Bye!");
        System.out.println("You got " + playersList.size() + " Points.");
    }

    int[] userInput() {
        int[] num = new int[2];
        System.out.println("What is to be inserted where? ");
        String str = scanner.nextLine();
        String[] arr = str.split("\\s+");
        num[0] = Integer.parseInt(arr[0]);
        num[1] = Integer.parseInt(arr[1]);
        return num;
    }
}
