package pakage01;

public class story {
    ui u;
    public String position;
    public story(ui u){
        this.u = u;
    }
    public void guard(){
        position="guard";
        u.text_area.setText("wellcome adventurer,\n you are now at the mansion gate and a guard at the gate. \n\n what do you do?");
        u.button1.setText("talk to guard");
        u.button2.setText("tell the guard you are a friend of the owner");
        u.button3.setText("leave");
        u.button4.setText("");
    }
    public void talktoguard(){
        position="talktoguard";
        u.text_area.setText("guard: hello adventurer, what do you want? i am sorry but i cant let you pass in:");
        u.button1.setText(">");
        u.button2.setText("");
        u.button3.setText("");
        u.button4.setText("");
    }
    public void telltheguard(){
        position="telltheguard";
        u.text_area.setText("guard: sorry i dont got time for this, i have to protect the mansion, you can leave now");
        u.button1.setText(">");
        u.button2.setText("");
        u.button3.setText("");
        u.button4.setText("");
    }
    public void towncenter(){
        position="towncenter";
        u.text_area.setText("you are now at the town center, you can go to the market or outside the town.");
        u.button1.setText("go to shop");
        u.button2.setText("go outside the town");
        u.button3.setText("go to mansiongate");
        u.button4.setText("");
    }
    public void shop(){
        position="shop";
        u.text_area.setText("you are at the shop, you can buy some items here.");
        u.button1.setText("buy sword: 15 gold");
        u.button2.setText("buy potion: 5 gold");
        u.button3.setText("go to town center");
        u.button4.setText("");
    }
    public void outside(){
        position="outside";
        u.text_area.setText("you are outside the town, you can go to the forest or back to the town center.");
        u.button1.setText("go to forest");
        u.button2.setText("go to town center");
        u.button3.setText("");
        u.button4.setText("");
    }
    public void forest(){
        position="forest";
        u.text_area.setText("you are in the forest, you can go back to the town center or explore the forest.");
        u.button1.setText("explore the forest");
        u.button2.setText("go to town center");
        u.button3.setText("");
        u.button4.setText("");
    }
    public void exploringforest(){
        position="exploringforest";
        u.text_area.setText("you encountered a monster. he wants to fight\n what do you do?");
        u.button1.setText("knife attack");
        u.button2.setText("long sword attack");
        u.button3.setText("potion: " + u.game.player1.potcount);
        u.button4.setText("leave");    
    }

}
