package pakage01;

public class shop {
    player player1;
    public String name = "shop";

    public weapons buysword(){
        player1.gold -=15;
        return new sword();
    }
    
    public weapons potion(){
        player1.gold-=5;
        return new potion();
    }

    public void giveplayer(player player1){
    this.player1 = player1;
    }
    
    
}
