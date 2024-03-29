package j2re.words;

import java.util.LinkedList;

public class WordsChain {

    LinkedList<String> list;

    public WordsChain() {
        list = new LinkedList<String>();
    }

    public String getLast() {
        return list.getLast();
    }

    public String getFirst() {
        return list.getFirst();
    }

    public int getSize() {
        return list.size();
    }

    public boolean add(String word) {
        if (fitsBegin(word)) {
            list.addFirst(word);
            return true;
        } else if (fitsEnd(word)) {
            list.addLast(word);
            return true;
        } else {
            return false;
        }
    }

    public boolean fits(String word) {
        if (fitsBegin(word) || fitsEnd(word)) { // NOSONAR
            return true;
        } else {
            return false;
        }
    }

    private boolean fitsBegin(String word) {
        if (list.isEmpty()) {
            return true;
        } else {
            String wordUpper = word.toUpperCase();
            String wordChain = list.getFirst().toUpperCase();
            char charWord = wordUpper.charAt(wordUpper.length() - 1);
            char charChain = wordChain.charAt(0);
            if (charWord == charChain) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean fitsEnd(String word) {
        if (list.isEmpty()) {
            return true;
        } else {
            String wordUpper = word.toUpperCase();
            String wordChain = list.getLast().toUpperCase();
            char charWord = wordUpper.charAt(0);
            char charChain = wordChain.charAt(wordChain.length() - 1);
            if (charWord == charChain) {
                return true;
            } else {
                return false;
            }
        }
    }
}
