package j2re.sortthings;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Game {

    Terminal term;
    final int NUMBER_MOUNTAINS = 8;

    Mountain[] mountains;
    PlayersList playerList;

    public Game(String filepathBerge) {
        Path path = Paths.get(filepathBerge).toAbsolutePath();
        mountains = readFile(path);
        playerList = new PlayersList();
        term = new Terminal();
    }

    void run() {
        int indexMtnFrom, indexMtnTo;
        int input[];
        Mountain mountain;
        do {
            term.printLists(mountains, playerList);
            input = term.userInput();
            indexMtnFrom = input[0];
            indexMtnTo = input[1];
            mountain = mountains[indexMtnFrom];
            mountains[indexMtnFrom] = null;
            playerList.addMountain(mountain, indexMtnTo);
        } while (playerList.isSorted());
        term.printEndresult(playerList);
    }

    Mountain[] readFile(Path path) {
        Mountain array[] = new Mountain[NUMBER_MOUNTAINS];
        List<String> all = null;
        try {
            all = java.nio.file.Files.readAllLines(path, Charset.defaultCharset());
        } catch (IOException ex) {
            System.exit(0);
        }
        int count = 0;
        Random random = new Random();
        Mountain berg;
        for (String item : all) {
            String[] arr = item.split(":");
            berg = new Mountain(arr[0], Integer.parseInt(arr[1]));
            if (count < array.length) {
                array[count] = berg;
            } else {
                int randomPos = random.nextInt(count);
                if (randomPos < array.length) {
                    array[randomPos] = berg;
                }
            }
            count++;
        }
        return array;
    }
}
