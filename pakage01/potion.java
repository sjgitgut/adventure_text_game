package pakage01;

public class potion extends weapons{
    int health;
    potion(){
        id=102;
        health = 15;
        name="potion";
    }
    @Override 
    public void use(player player1){
        player1.health += 15;
        player1.weaponcheck=false;
        for(int i=0; i<= player1.w.length-1;i++){
            if(player1.w[i] instanceof potion){
                player1.w[i]=null;
                player1.potcount--;
                break;
            }
        }
    }
}
