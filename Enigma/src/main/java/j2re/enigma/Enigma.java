package j2re.enigma;

public class Enigma {

    public static void main(String[] args) {
        Terminal term = new Terminal();        
        term.intro();        
        String text = term.getText();
        int mode = term.getMode();
        String result = "";        
        switch (mode) {
            case 1 -> {
                int walzenstellung = term.inputWalzenstellung();
                EnigmaMachine em = new EnigmaMachine(text, walzenstellung);
                result = em.encrypt();
            }
            case 2 -> {
                int walzenstellung = term.inputWalzenstellung();
                EnigmaMachine em = new EnigmaMachine(text, walzenstellung);
                result = em.decrypt();
            }
            case 3 -> {
                String searchTerm = term.inputSearchTerm();            
                result = crack(text, searchTerm);
            }
        }
        term.printResult(result, mode);
    }
    
    static String crack(String text, String searchTerm) {
        searchTerm = searchTerm.toUpperCase();
        String result;
        EnigmaMachine em;
        for (int i = 0; i < EnigmaMachine.CLEAR.length(); i++) {
            em = new EnigmaMachine(text, i);
            result = em.decrypt();
            if (result.contains(searchTerm)) {
                return result;
            }
        }
        return null;
    }
}
