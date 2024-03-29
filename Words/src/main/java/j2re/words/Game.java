package j2re.words;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Game {

    Terminal term;
    WordList wordList;
    WordsChain chain;
    String nextWord;
    
    public Game(String wordsfilePath, Terminal term) {        
        this.term = term;
        Path path = Paths.get(wordsfilePath).toAbsolutePath();
        wordList = new WordList(path);
        chain = new WordsChain();    
    }

    void run() {        
        do {
            term.printNumberWords(wordList.getSize());
            if (chain.getSize() != 0) {
                term.printChain(chain.getFirst(), chain.getLast());
            }
            nextWord = term.inputNextWord();
            if ("".equals(nextWord)) {
                term.printWordList(wordList.getHintList(chain));
            } else if (wordList.hasWord(nextWord)) {
                if (chain.add(nextWord)) {
                    wordList.removeWord(nextWord);
                } else {
                    term.printNotFitting();
                }
            } else {
                term.printWordNotFound();
            }
        } while (!gameOver());
    }
    
    boolean gameOver() {
        if (wordList.candidatesLeft(chain)) {
            return false;          
        } else {
            return true;
        }
    }
}
