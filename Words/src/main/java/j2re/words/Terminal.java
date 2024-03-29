package j2re.words;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Terminal {

    Scanner scanner = new Scanner(System.in);

    //String language = new String("en");
    //String country = new String("US"); 
    String language = "de";
    String country = "DE";
    Locale currentLocale = new Locale(language, country);
    ResourceBundle messages = ResourceBundle.getBundle("messages", currentLocale);

    public void printWordList(List<String> list) {
        for (String word : list) {
            System.out.print(word + ", ");
        }
        System.out.println();
    }

    public void printChain(String first, String last) {
        if (first == last) {
            System.out.print(first + "\n");
        } else {
            System.out.print(first + " ... " + last + "\n");
        }
    }

    public void printNumberWords(int number) {
        System.out.println(number + messages.getString("NumberWords"));
    }

    public void printNotFitting() {
        System.out.println(messages.getString("NotFitting"));
    }

    public void printWordNotFound() {
        System.out.println(messages.getString("WordNotFound"));
    }

    public String inputNextWord() {
        System.out.print(messages.getString("NextWord"));
        return scanner.nextLine();
    }

    public void printStartNewChain() {
        System.out.println(messages.getString("StartNewChain"));
    }
}
