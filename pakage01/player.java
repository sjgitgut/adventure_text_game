package pakage01;
import java.util.Random;

public class player {
    public int health=50;
    public int gold=30;
    boolean weaponcheck = false;
    boolean potioncheck = false;
    int potcount;
    Random rand = new Random();

    weapons[] w = new weapons[5];

    public weapons currentweapon;
   
    public void addweapons(weapons w1){
        for(int i=0;i<w.length;i++){
            if(w[i]==null){
                w[i]=w1;
                break;
            }
        }
        currentweapon = w1;
    }

    public void useitem(int id){
        weaponcheck = false;
        for(int i=0;i<w.length-1;i++){
            if(w[i] != null && w[i].id == id){
                currentweapon=w[i];
                weaponcheck = true;
            }
        }
    }
    public void potioncount(){
        for(int i=0; i<=w.length-1;i++){
            if(w[i] instanceof potion){
                potcount++;
            }
        }
    }

    public int attack(){
        int damage = rand.nextInt(1,11);
        if(currentweapon instanceof potion){
            return 0;
        }
        if(weaponcheck){
            damage+=currentweapon.damage;
            return damage;    
        }
        return 0;
    }   

}
