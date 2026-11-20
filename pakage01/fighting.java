package pakage01;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class fighting {
    public player player1;
    public monster monster1;
    ui u;
    Timer timer;
    int monsterkilled;
    String monsterdeathtext="you have defeated the monster \n congratulations.    \n\nyou optained the pass";
    String playerdeathtext="you have been killed by the monster";
    boolean monsterlost = false;

    public void giveui(ui u){
        this.u = u;
    }

    public void getready(player player1, monster monster1){
        this.player1 = player1;
        this.monster1=monster1;
    }

        public void fight(){
        SwingUtilities.invokeLater(() -> {

        if(monster1.health<1){
            u.text_area.setText(monsterdeathtext); 
            monsterkilled ++;   
            monsterlost=true;
        }
        else if(player1.health<1){
            u.text_area.setText(playerdeathtext);    
        }
        else{ 
            int damplay = player1.attack();
            int dammon=monster1.attack();
            monster1.health-=damplay;
            u.text_area.setText("you gave the monster "+ damplay +" damage");
            u.monsterstats();
            player1.health-=dammon;
            timer=new Timer(1700, e ->{
                u.text_area.setText("the monster gave you "+ dammon +" damage");
                u.showstats();
            });
            timer.setRepeats(false);
            timer.start();
        }

        });
    }
}