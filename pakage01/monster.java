package pakage01;

import java.util.Random;

public class monster {
    public int health= 50;
    Random rand = new Random();
    public int attack(){
        int damage = rand.nextInt(1,21);
        return damage;
    }

}
