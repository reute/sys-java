package j2re.dreikreuze;

import java.util.Scanner;

abstract class Player {

    Field field;

    public Player(Field field) {    
        this.field = field;
    }

    abstract void makeTurn();
}
