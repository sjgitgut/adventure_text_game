package pakage01;

class shop {
    private final Game game;

    shop(Game game) {
        this.game = game;
    }

    String name = "shop";

    weapon buysword(){
        game.player1.gold -= 15;
        return new sword();
    }
    
    weapon potion(){
        game.player1.gold-=5;
        return new potion();
    }
}
