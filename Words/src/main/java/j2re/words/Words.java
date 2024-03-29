package j2re.words;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Words {

    static Logger log = LoggerFactory.getLogger(Words.class);

    public static void main(String[] args) {
        Terminal term = new Terminal();
        String wordsfilePath = loadKey("file");
        do {
            new Game(wordsfilePath, term).run();
            term.printStartNewChain();
        } while (true);
    }

    static String loadKey(String value) {
        Properties prop = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream("src/main/resources/config.properties");
            prop.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            log.error(e.getMessage() + e);
        } catch (IOException e) {
            log.error(e.getMessage() + e);
        }
        return prop.getProperty(value);
    }
}
