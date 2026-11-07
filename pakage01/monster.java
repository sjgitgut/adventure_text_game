package pakage01;

class monster {
    private final Game game;

    monster(Game game) {
        this.game = game;
    }

    int health= 50;

    int attack(){
        int damage = game.rand.nextInt(1,21);
        return damage;
    }

}
