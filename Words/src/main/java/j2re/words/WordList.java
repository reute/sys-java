package j2re.words;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordList {

    List<String> list = new ArrayList<String>();
    Logger log = LoggerFactory.getLogger(WordList.class);

    public WordList(Path path) {
        readFile(path);
    }

    void readFile(Path path) {
        try {
            list = java.nio.file.Files.readAllLines(path, Charset.defaultCharset());
        } catch (IOException e) {
            log.error(e.getMessage() + e);
        }
    }

    public List<String> getList() {
        return new ArrayList<String>(list);
    }

    public int getSize() {
        return list.size();
    }

    public boolean hasWord(String word) {
        if (list.contains(word)) {
            return true;
        } else {
            return false;
        }
    }

    public void removeWord(String word) {
        list.remove(word);
    }

    public boolean candidatesLeft(WordsChain chain) {
        for (String word : list) {
            if (chain.fits(word)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getHintList(WordsChain chain) {
        List<String> hintList = new ArrayList<String>();
        for (String word : list) {
            if (chain.fits(word)) {
                hintList.add(word);
            }
        }
        return hintList;
    }
}
