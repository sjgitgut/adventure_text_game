package pakage01;

import java.util.Random;

class Game {
    ui u = new ui();
    story s = new story(this);
    player player1 =new player(this);
    shop shop1 = new shop(this);
    knife knife1 = new knife();
    int monster=0;
    monster mons;
    fighting fight1;
    Random rand = new Random();

    static void main(String[] args) {
        new Game();
    }
    Game(){
        u.setstory(s,shop1,this);
        player1.addweapons(knife1);
    }
    monster createmonster(){
        return new monster(this);
    }

}
