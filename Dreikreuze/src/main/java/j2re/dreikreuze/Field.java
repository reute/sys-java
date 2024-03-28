package j2re.dreikreuze;

public class Field {

    int size, elements;

    public Field(int size) {       
        this.size = size;
    }

    boolean gameover() {
        int crossesInRow = 0;
        for (int i = 0; i < size; i++) {
            if (taken(i)) {
                crossesInRow += 1;
                if (crossesInRow == 3) {
                    return true;
                }
            } else {
                crossesInRow = 0;
            }
        }
        return false;
    }
    
    boolean spaceLeft() {
        if (elements < Math.pow(2, size)) {
            return true;
        } else {
            return false;
        }
    }

    void print() {
        for (int i = 0; i <= size; i++) {
            if (taken(i)) {
                System.out.print("\\/ ");
            } else {
                System.out.print("   ");
            }
        }
        System.out.println();

        for (int i = 0; i <= size; i++) {
            if (taken(i)) {
                System.out.print("/\\ ");
            } else {
                System.out.print("   ");
            }
        }
        System.out.println();

        for (int i = 0; i <= size; i++) {
            System.out.printf("%02d ", i);
        }
        System.out.println();
    }

    boolean taken(int pos) {
        int tmp = 1 << pos;
        if ((tmp & elements) == tmp) {
            return true;
        } else {
            return false;
        }
    }

    boolean take(int pos) {
        if (!taken(pos)) {
            int tmp = 1 << pos;
            elements = (elements | tmp);
            return true;
        } else {
            return false;
        }
    }
}
