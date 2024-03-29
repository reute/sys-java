package j2re.enigma;

public final class EnigmaMachine {

    public static final int MAX_CHARS = 37;
    String text, key;
    char[] result;
    static final String CLEAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
    String DEFAULT_KEY  = "EKLMF6GDQVZ0TO8Y XUSP2IB4CJ5AR197W3NH";

    public EnigmaMachine(String text, int walzenstellung) {
        this.text = text.toUpperCase();
        result = new char[text.length()];
        key = createKey(DEFAULT_KEY, walzenstellung);
    }

    String createKey(String key, int walzenstellung) {        
        for (int i = 0; i < walzenstellung; i++) {
            key = key.substring(1) + key.charAt(0);
        }
        return key;
    }

    String encrypt() {
        int i_key;
        boolean zeichen_erlaubt;
        char ctext, cclear;
        for (int i = 0; i < text.length(); i++) {
            ctext = text.charAt(i);
            zeichen_erlaubt = false;
            for (int j = 0; j < CLEAR.length(); j++) {
                cclear = CLEAR.charAt(j);
                if (ctext == cclear) {
                    zeichen_erlaubt = true;
                    break;
                }
            }
            if (!zeichen_erlaubt) {
                i_key = CLEAR.indexOf(" ");
            } else {
                i_key = CLEAR.indexOf(ctext);
            }
            result[i] = key.charAt(i_key);
            key = key.substring(1) + key.charAt(0);
        }
        return new String(result);
    }

    public String decrypt() {
        int i_key;
        char ctext;
        for (int i = 0; i < text.length(); i++) {
            ctext = text.charAt(i);
            i_key = key.indexOf(ctext);
            result[i] = CLEAR.charAt(i_key);
            key = key.substring(1) + key.charAt(0);
        }
        return new String(result);
    }
}
