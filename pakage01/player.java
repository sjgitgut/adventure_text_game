package pakage01;
import java.util.Random;

class player {
    private final Game game;

    player(Game game) {
        this.game = game;
    }

    int health=50;
    int gold=30;

    weapon[] w = new weapon[5];
    weapon[] p = new weapon[5];

    weapon currentweapon;
    void addpotion(weapon p1){
        for(int i=0;i<w.length;i++){
            if(p[i]==null){
                p[i]=p1;
                break;
            }
        }
    }
    void addweapons(weapon w1){
        for(int i=0;i<w.length;i++){
            if(w[i]==null){
                w[i]=w1;
                break;
            }
        }
    }

    void useitem(int id){
        for(int i=0;i<w.length;i++){
            if(w[i].id == id){
                currentweapon=w[i];
            }
            else{

            }
        }
    }

    int attack(){
        int damage = game.rand.nextInt(1,11);
        damage+=currentweapon.damage;
        return damage;
    }

}
