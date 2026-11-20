package pakage01;

public class Game {
    ui u = new ui();
    story s = new story(u);
    player player1 =new player();
    shop shop1 = new shop();
    knife knife1 = new knife();
    int monster=0;
    monster mons;
    fighting fight1;
    public static void main(String[] args) {
        new Game();
    }
    public Game(){
        u.frame.setVisible(true);
        u.setstory(s,shop1,this);
        shop1.giveplayer(player1);
        player1.addweapons(knife1);


    }
    public monster createmonster(){
        return new monster();
    }

}
