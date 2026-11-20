package pakage01;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ui {
    JFrame frame;
    JPanel panel, startpanel, choicepanel, monsterhealthpanel;
    JLabel titlelabel; 
    JButton startbutton, button1, button2, button3, button4;
    JLabel playerhealthLabel = new JLabel();
    JTextArea text_area,monsterhealthtext;
    Container c;
    story s;
    shop shop1;
    Game game;
    choicehandler ch = new choicehandler();
    public ui(){
        
        frame = new JFrame("Game");
        frame.setBounds(300,150,900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        c = frame.getContentPane();
        frame.setLayout(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50,20,900,300);
        panel.setBackground(Color.BLACK);
        
        titlelabel = new JLabel("Adventure");
        titlelabel.setBounds(90,20,600,200);
        titlelabel.setForeground(Color.white);
        titlelabel.setFont(new Font("Times new Roman", Font.BOLD,110));
        
        monsterhealthpanel = new JPanel();
        c.add(monsterhealthpanel);

        panel.add(titlelabel);
        c.add(panel);
        
        startpanel = new JPanel();
        startpanel.setBounds(340,320,150,50);
        startpanel.setLayout(new GridLayout(1,1));
        startpanel.setBackground(Color.black);
        
        
        startbutton = new JButton("start");
        startbutton.setFont(new Font("Times new Roman", Font.BOLD,30));
        startbutton.setBackground(Color.BLACK);
        startbutton.setForeground(Color.white);
        startbutton.setFocusPainted(false);
        startbutton.addActionListener(ch);
        startbutton.setActionCommand("startbutt");
        startpanel.add(startbutton);
        c.add(startpanel);
        
        
    }
    public void setstory(story s, shop shop1, Game game){
        this.s =s;
        this.shop1 = shop1;
        this.game= game;
        
    }
    public void startgame(){
        startbutton.setVisible(false);
        titlelabel.setVisible(false);
        startpanel.setBounds(200,320,400,230);
        startpanel.setLayout(new GridLayout(4,1));
        
        text_area = new JTextArea("");
        text_area.setBounds(30,70,600,300);
        text_area.setFont(new Font("Times new Roman", Font.BOLD,20));
        text_area.setForeground(Color.white);
        text_area.setBackground(Color.black);
        text_area.setLineWrap(true);
        panel.add(text_area);
        
        panel.revalidate();
        panel.repaint();
        
        button1 = new JButton("");
        button1.setFont(new Font("Times new Roman", Font.BOLD,20));
        button1.setBackground(Color.BLACK); 
        button1.setForeground(Color.white);
        button1.addActionListener(ch);
        button1.setActionCommand("butt1");
        startpanel.add(button1);
        
        button2 = new JButton("");
        button2.setFont(new Font("Times new Roman", Font.BOLD,20));
        button2.setBackground(Color.BLACK); 
        button2.setForeground(Color.white);
        button2.addActionListener(ch);
        button2.setActionCommand("butt2");
        startpanel.add(button2);
        
        button3 = new JButton("");
        button3.setFont(new Font("Times new Roman", Font.BOLD,20));
        button3.setBackground(Color.BLACK); 
        button3.setForeground(Color.white);
        button3.addActionListener(ch);
        button3.setActionCommand("butt3");
        startpanel.add(button3);
        
        button4 = new JButton("");
        button4.setFont(new Font("Times new Roman", Font.BOLD,20));
        button4.setBackground(Color.BLACK); 
        button4.setForeground(Color.white);
        button4.addActionListener(ch);
        button4.setActionCommand("butt4");
        startpanel.add(button4);
        playerhealthLabel.setBounds(30,10,800,70);
        playerhealthLabel.setForeground(Color.white);
        panel.add(playerhealthLabel);
        showstats();
        s.guard();
        
        monsterhealthpanel.setBounds(700,150,150,50);
        monsterhealthpanel.setBackground(Color.BLACK);
        
        
        monsterhealthtext = new JTextArea("hello");
        monsterhealthtext.setForeground(Color.white);
        monsterhealthtext.setBackground(Color.BLACK);
        monsterhealthtext.setFont(new Font("Times new Roman", Font.BOLD,20));
        monsterhealthtext.setBounds(0,0,150,80);
        monsterhealthpanel.add(monsterhealthtext);

        monsterhealthpanel.setVisible(false);
        
    }
    public void showstats(){
        playerhealthLabel.setText("health:  "+ game.player1.health +"        gold:  "+ game.player1.gold +"         weapon:  "+ game.player1.currentweapon.name);
        
    }
    public void monsterstats(){
        monsterhealthtext.setText("monster: " + game.mons.health);
    }
    
    public class choicehandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
            String click = arg0.getActionCommand();
            
            switch (click) {
                case "startbutt": startgame();
                
                break;
                case "butt1": switch(s.position){
                    case "guard": s.talktoguard();
                    break;
                    case "talktoguard": s.guard();
                        break;
                    case "telltheguard": s.guard();
                        break;
                    case "towncenter": s.shop();
                        break;
                    case "shop": game.player1.addweapons(shop1.buysword());
                    showstats();
                        break;
                    case "outside": s.forest();
                        break;
                    case "forest": s.exploringforest();
                    monsterhealthpanel.setVisible(true);
                    if(game.monster==0){
                        game.monster++;
                        game.mons=game.createmonster();
                        game.fight1 = new fighting();
                        game.fight1.giveui(ui.this);
                        game.fight1.getready(game.player1, game.mons);
                    }
                    monsterstats();
                        break;
                    case "exploringforest":
                    monsterstats();
                    game.player1.useitem(103);
                    if(game.fight1.monsterlost==true){
                        game.monster=0;
                        s.forest();
                    }
                    else{
                        game.fight1.fight();
                    }

                        break;

                };
                    
                    break;
                case "butt2": switch(s.position){
                    case "guard": s.telltheguard();
                        break;
                    
                    case "towncenter": s.outside();
                        break;
                    
                    case "shop": game.player1.addweapons(shop1.potion());
                    game.player1.potioncount();
                    showstats();
                        break;
                    
                    case "outside": s.towncenter();
                        break;
                    case "forest": s.towncenter();
                        break;
                    
                    case "exploringforest": game.player1.useitem(101);
                    if(game.fight1.monsterlost==true){
                        game.monster=0;
                        s.forest();
                    }
                    game.fight1.fight();

                        break;
                };
                    
                    break;
            
                case "butt3": switch(s.position){
                    case "guard": s.towncenter();
                        break;
                    
                    
                    case "towncenter": s.guard();
                        break;
                    
                    case "shop": s.towncenter();
                        break;
                    
                    
                    case "exploringforest": game.player1.useitem(102);
                    if(game.player1.weaponcheck){
                        game.player1.currentweapon.use(game.player1);
                        showstats();
                    }
                    s.exploringforest();
                    if(game.fight1.monsterlost==true){
                        game.monster=0;
                        s.forest();
                    }
                    game.fight1.fight();
                        break;
                };
                    
                    break;
            
                case "butt4": switch(s.position){
                    case "guard":
                        break;
                    
                    case "talktoguard":
                        break;
                    
                    case "telltheguard":
                        break;
                    
                    case "towncenter":
                        break;
                    
                    case "shop":
                        break;
                    
                    case "outside":
                        break;
                    
                    case "exploringforest": text_area.setText("you ran from the monster");
                    monsterhealthpanel.setVisible(false);
                    Timer timer = new Timer(1000, e ->{
                        s.towncenter();
                    });
                    timer.setRepeats(false);
                    timer.start();
                        break;
                };
                    
                    break;
            
                default:
                    break;
            }
        }
    
        
    }
}
