package j2re.enigma;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Terminal {

    Scanner scanner;

    public Terminal() {
        scanner = new Scanner(System.in);
    }

    String getText() {
        System.out.println("Bitte Text eingeben: ");
        return scanner.nextLine();
    }

    int getMode() {
        int choice;
        do {
            System.out.println("1 - Verschlüsseln\n2 - Entschlüsseln\n3 - Text knacken");
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Bitte Wert zwischen 1 und 3 eingeben");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Bitte Zahl eingeben");
                scanner.nextLine();
            }
        } while (true);
    }

    public void printResult(String result, int mode) {
        switch (mode) {
            case 1 ->
                printResultEncrypted(result);
            case 2 ->
                printResultDecrypted(result);
            case 3 ->
                printResultCracked(result);
        }
    }

    int inputWalzenstellung() {
        int walzenstellung;
        do {
            System.out.println("Bitte Walzenstellung eingeben (0 - 37)");
            try {
                walzenstellung = scanner.nextInt();
                if (walzenstellung >= 0 && walzenstellung <= 37) {
                    return walzenstellung;
                } else {
                    System.out.println("Bitte Wert zwischen 0 und 37 eingeben");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Bitte Zahl eingeben");
                scanner.nextLine();
            }
        } while (true);
    }

    String inputSearchTerm() {
        System.out.println("Bitte Suchwort eingeben: ");
        return scanner.next();
    }

    void intro() {
        System.out.println(" * * * * ENIGMA * * * * *");
    }

    void printResultEncrypted(String result) {
        System.out.println("Verschlüsselter Text:\n" + result);
    }

    void printResultDecrypted(String result) {
        System.out.println("Entschlüsselter Text:\n" + result);
    }

    void printResultCracked(String result) {
        if (result == null) {
            System.out.println("Suchwort nicht gefunden !");
        } else {
            System.out.println("Gecrackter Text:\n" + result);
        }
    }
}
