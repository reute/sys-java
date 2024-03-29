package j2re.sortthings;

import java.util.ArrayList;

public class PlayersList extends ArrayList<Mountain> {

    void addMountain(Mountain mountain, int to) {
        if (to > this.size()) {
            this.add(mountain);
        } else {
            this.add(to, mountain);
        }
    }

    boolean isSorted() {
        int maxHeight = 0;
        int tmp;
        for (Mountain mountain : this) {
            tmp = mountain.height;
            if (tmp > maxHeight) {
                maxHeight = tmp;
            } else {
                return false;
            }
        }
        return true;
    }
}
