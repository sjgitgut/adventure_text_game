package pakage01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ui {
    JFrame frame;
    JPanel panel, startpanel, choicepanel, mosterhealthpanel;
    JLabel titlelabel,monsterhealthlabel,playerhealthLabel; 
    JButton startbutton, button1, button2, button3, button4;
    JTextArea text_area;
    Container c;
    story s;
    shop shop1;
    Game game;
    choicehandler ch = new choicehandler();
    ui(){
        
        frame = new JFrame("Game");
        frame.setBounds(300,150,900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);;
        c = frame.getContentPane();
        frame.setLayout(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(50,20,800,300);
        panel.setBackground(Color.BLACK);

        titlelabel = new JLabel("Adventure");
        titlelabel.setBounds(90,20,600,200);
        titlelabel.setForeground(Color.white);
        titlelabel.setFont(new Font("Times new Roman", Font.BOLD,110));

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

        frame.setVisible(true);
    }
    void setstory(story s, shop shop1, Game game){
        this.s =s;
        this.shop1 = shop1;
        this.game= game;

    }
    void startgame(){
        startbutton.setVisible(false);
        titlelabel.setVisible(false);
        startpanel.setBounds(200,320,400,230);
        startpanel.setLayout(new GridLayout(4,1));

        text_area = new JTextArea("");
        text_area.setBounds(30,70,680,300);
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
        showstats();
        s.guard();
    }
    void showstats(){
        playerhealthLabel = new JLabel();
        playerhealthLabel.setBounds(30,10,800,70);
        playerhealthLabel.setForeground(Color.white);
        playerhealthLabel.setText("health:  "+ game.player1.health +"        gold:  "+ game.player1.gold +"         weapon:  "+ game.player1.currentweapon);
        panel.add(playerhealthLabel);
        
    }
    
    class choicehandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String click = arg0.getActionCommand();

            switch (click) {
                case "startbutt" -> {
                    startgame();
                }
                case "butt1" -> {
                    switch (s.position) {
                        case "guard" -> {
                            s.talktoguard();
                        }
                        case "talktoguard" -> {
                            s.guard();
                        }
                        case "telltheguard" -> {
                            s.guard();
                        }
                        case "towncenter" -> {
                            s.shop();
                        }
                        case "shop" -> {
                            game.player1.addweapons(shop1.buysword());
                        }
                        case "outside" -> {
                            s.forest();
                        }
                        case "forest" -> {
                            s.exploringforest();
                            if (game.monster == 0) {
                                game.monster++;
                                game.mons = game.createmonster();
                                game.fight1 = new fighting();
                            }
                        }
                        case "exploringforest" -> {
                            game.player1.useitem(103);
                            if (game.fight1.monsterlost == true) {
                                game.monster = 0;
                                s.forest();
                            }

                            game.fight1.getready(game.player1, game.mons);
                            game.fight1.fight();
                        }
                    }
                    ;
                }
                case "butt2" -> {
                    switch (s.position) {
                        case "guard" -> {
                            s.telltheguard();
                        }
                        case "towncenter" -> {
                            s.outside();
                        }
                        case "shop" -> {
                            game.player1.addpotion(shop1.potion());
                        }
                        case "outside" -> {
                            s.towncenter();
                        }
                        case "forest" -> {
                            s.towncenter();
                        }
                        case "exploringforest" -> {
                            game.player1.useitem(103);
                            if (game.fight1.monsterlost == true) {
                                game.monster = 0;
                                s.forest();
                            }
                            game.fight1.getready(game.player1, game.mons);
                            game.fight1.fight();
                        }
                    }
                    ;
                }
                case "butt3" -> {
                    switch (s.position) {
                        case "guard" -> {
                            s.towncenter();
                        }
                        case "towncenter" -> {
                            s.guard();
                        }
                        case "shop" -> {
                            s.towncenter();
                        }
                        case "exploringforest" -> {
                            game.player1.useitem(102);
                            if (game.fight1.monsterlost == true) {
                                game.monster = 0;
                                s.forest();
                            }
                            game.fight1.getready(game.player1, game.mons);
                            game.fight1.fight();
                        }
                    }
                    ;
                }
                case "butt4" -> {
                    switch (s.position) {
                        case "guard" -> {
                        }
                        case "talktoguard" -> {
                        }
                        case "telltheguard" -> {
                        }
                        case "towncenter" -> {
                        }
                        case "shop" -> {
                        }
                        case "outside" -> {
                        }
                        case "exploringforest" -> {
                        }
                    }
                    ;
                }
                default -> {
                }
            }
        }
    
        
    }
}
