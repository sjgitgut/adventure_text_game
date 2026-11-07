package pakage01;

class story {
    private final Game game;
    String position;

    story(Game game){
        this.game = game;
    }
    void guard(){
        position="guard";
        game.u.text_area.setText("wellcome adventurer,\n you are now at the mansion gate and a guard at the gate. \n\n what do you do?");
        game.u.button1.setText("talk to guard");
        game.u.button2.setText("tell the guard you are a friend of the owner");
        game.u.button3.setText("leave");
        game.u.button4.setText("");
    }
    void talktoguard(){
        position="talktoguard";
        game.u.text_area.setText("guard: hello adventurer, what do you want? i am sorry but i cant let you pass in:");
        game.u.button1.setText(">");
        game.u.button2.setText("");
        game.u.button3.setText("");
        game.u.button4.setText("");
    }
    void telltheguard(){
        position="telltheguard";
        game.u.text_area.setText("guard: sorry i dont got time for this, i have to protect the mansion, you can leave now");
        game.u.button1.setText(">");
        game.u.button2.setText("");
        game.u.button3.setText("");
        game.u.button4.setText("");
    }
    void towncenter(){
        position="towncenter";
        game.u.text_area.setText("you are not at theh town center, you can go to the market or outside the town.");
        game.u.button1.setText("go to shop");
        game.u.button2.setText("go outside the town");
        game.u.button3.setText("go to mansiongate");
        game.u.button4.setText("");
    }
    void shop(){
        position="shop";
        game.u.text_area.setText("you are at the shop, you can buy some items here.");
        game.u.button1.setText("buy sword: 15 gold");
        game.u.button2.setText("buy potion: 5 gold");
        game.u.button3.setText("go to town center");
        game.u.button4.setText("");
    }
    void outside(){
        position="outside";
        game.u.text_area.setText("you are outside the town, you can go to the forest or back to the town center.");
        game.u.button1.setText("go to forest");
        game.u.button2.setText("go to town center");
        game.u.button3.setText("");
        game.u.button4.setText("");
    }
    void forest(){
        position="forest";
        game.u.text_area.setText("you are in the forest, you can go back to the town center or explore the forest.");
        game.u.button1.setText("explore the forest");
        game.u.button2.setText("go to town center");
        game.u.button3.setText("");
        game.u.button4.setText("");
    }
    void exploringforest(){
        position="exploringforest";
        game.u.text_area.setText("you encountered a monster. he wants to fight\n what do you do?");
        game.u.button1.setText("knife attack");
        game.u.button2.setText("long sword attack");
        game.u.button3.setText("potion");
        game.u.button4.setText("leave");
    }

}
