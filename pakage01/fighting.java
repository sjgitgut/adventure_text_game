package pakage01;
import javax.swing.Timer;

class fighting {
    player player1;
    monster monster1;
    Timer timer;
    ui u;
    int monsterkilled;
    String monsterdeathtext="you have defeated the monster \n congratulations.    \n\nyou optained the pass";
    String playerdeathtext="you have been killed by the monster";
    boolean monsterlost = false;

    void getready(player player1, monster monster1){
        this.player1 = player1;
        this.monster1=monster1;
    }

    void fight(){
        if(monster1.health<0){
            u.text_area.setText(monsterdeathtext); 
            monsterkilled ++;   
            monsterlost=true;
        }
        else if(player1.health<0){
            u.text_area.setText(playerdeathtext);    
        }
        else{ 
            int damplay = player1.attack();
            int dammon=monster1.attack();
            
            u.text_area.setText("you gave the monster "+ damplay +" damage");    
            timer=new Timer(1700, e ->{
                player1.health-=dammon;
                u.text_area.setText("you gave the monster "+ dammon +" damage");    
            });
            timer.setRepeats(false);
            timer.start();
        }
            

    }
}
